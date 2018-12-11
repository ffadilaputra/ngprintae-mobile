package ffadilaputra.org.bottom_toolbar.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;

import ffadilaputra.org.bottom_toolbar.R;
import ffadilaputra.org.bottom_toolbar.adapter.PlacesAdapter;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks,PlaceSelectionListener {

	private RecyclerView recyclerView;
	private static final String LOG_TAG = "CardFragment";
	protected GoogleApiClient mGoogleApiClient;
	private static final int PERMISSION_REQUEST_CODE = 100;
	PlacesAdapter adapter = null;
	private ArrayList<Place> place = new ArrayList<>();


	private static final LatLngBounds ALAMAT = new LatLngBounds(
			new LatLng(-7.946529	, 112.615537), new LatLng(37.430610, -121.972090));
	private static final int REQUEST_SELECT_PLACE = 1000;
	private TextView locationTextView;
	private TextView attributionsTextView;

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		mGoogleApiClient = new GoogleApiClient.Builder(getContext())
				.addConnectionCallbacks(this)
				.addOnConnectionFailedListener(this)
				.addApi(LocationServices.API)
				.addApi(Places.PLACE_DETECTION_API)
				.addApi(Places.GEO_DATA_API)
				.build();
		mGoogleApiClient.connect();

		adapter = new PlacesAdapter(place);
		retrievePlaces();


    }

	private void retrievePlaces() throws SecurityException {
		PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
		result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
			@Override
			public void onResult(@NonNull PlaceLikelihoodBuffer likelyPlaces) {

				for (PlaceLikelihood placeLikelihood : likelyPlaces) {
					place.add(placeLikelihood.getPlace().freeze());
					Log.i("Place = ",  placeLikelihood.getPlace().getName().toString());
				}
				adapter.notifyDataSetChanged();
				likelyPlaces.release();
			}
		});
	}

	@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_place_list,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.places_lst);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		recyclerView.setAdapter(adapter);

		PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)getActivity().
				getFragmentManager().findFragmentById(R.id.place_fragment);
		autocompleteFragment.setOnPlaceSelectedListener(this);
		autocompleteFragment.setHint("Search a Location");
		autocompleteFragment.setBoundsBias(ALAMAT);

        return view;
    }

	@Override
	public void onConnected(@Nullable Bundle bundle) {
		int hasPermission = 0;

		hasPermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
		if (hasPermission != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
		} else {
			Log.i("Client Connection", "Connected to GoogleClient");
		}
	}

	@Override
	public void onConnectionSuspended(int i) {

	}

	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
		Log.e(LOG_TAG, "Google Places API connection failed with error code: " + connectionResult.getErrorCode());
		Toast.makeText(getActivity(), "Google Places API connection failed with error code:" + connectionResult.getErrorCode(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onPlaceSelected(Place place) {
		Log.i(LOG_TAG, "Place Selected: " + place.getName());
		locationTextView.setText(getString(R.string.formatted_place_data, place
				.getName(), place.getAddress(), place.getPhoneNumber(), place
				.getWebsiteUri(), place.getRating(), place.getId()));
		if (!TextUtils.isEmpty(place.getAttributions())){
			attributionsTextView.setText(Html.fromHtml(place.getAttributions().toString()));
		}
	}

	@Override
	public void onError(Status status) {
		Log.e(LOG_TAG, "onError: Status = " + status.toString());
		Toast.makeText(getActivity(), "Place selection failed: " + status.getStatusMessage(),
				Toast.LENGTH_SHORT).show();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_SELECT_PLACE) {
			if (resultCode == RESULT_OK) {
				Place place = PlaceAutocomplete.getPlace(getActivity(), data);
				this.onPlaceSelected(place);
			} else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
				Status status = PlaceAutocomplete.getStatus(getActivity(), data);
				this.onError(status);
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

}
