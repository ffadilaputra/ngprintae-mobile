package ffadilaputra.org.bottom_toolbar.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBufferResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import ffadilaputra.org.bottom_toolbar.R;
import ffadilaputra.org.bottom_toolbar.adapter.PlacesRecyclerViewAdapter;

public class HomeFragment extends Fragment {

    public static final String TAG = "CurrentLocNearByPlaces";
    private static final int LOC_REQ_CODE = 1;
    protected GeoDataClient geoDataClient;
    protected PlaceDetectionClient placeDetectionClient;
    protected RecyclerView recyclerView;
    private PlacesRecyclerViewAdapter placesRecyclerViewAdapter;


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_place_list,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.places_lst);
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(recyclerLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),recyclerLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        placeDetectionClient = Places.getPlaceDetectionClient(getActivity().getApplicationContext(),null);
        getCurrentPlaceItems();
        //recyclerView.setAdapter(placesRecyclerViewAdapter);
        return view;
    }

    private void getCurrentPlaceItems(){
        if(isLocationAccessPermitted()){
            getCurrentPlaceData();
        }else{
            requestLocationAccessPermission();
        }
    }

    private void requestLocationAccessPermission() {
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                LOC_REQ_CODE);
    }

    private boolean isLocationAccessPermitted() {
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }

    @SuppressLint("MissingPermission")
    private void getCurrentPlaceData(){
        Task<PlaceLikelihoodBufferResponse> placeResult = placeDetectionClient.getCurrentPlace(null);
        placeResult.addOnCompleteListener(new OnCompleteListener<PlaceLikelihoodBufferResponse>() {
            @Override
            public void onComplete(@NonNull Task<PlaceLikelihoodBufferResponse> task) {
                Log.d(TAG,"Current location places info");
                List<Place> placelist = new ArrayList<Place>();
                PlaceLikelihoodBufferResponse likelyPlace = task.getResult();
                for (PlaceLikelihood placeLikelihood : likelyPlace){
                    placelist.add(placeLikelihood.getPlace().freeze());
                }
                likelyPlace.release();
                PlacesRecyclerViewAdapter recyclerViewAdapter = new PlacesRecyclerViewAdapter(placelist,getActivity().getApplicationContext());
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

}
