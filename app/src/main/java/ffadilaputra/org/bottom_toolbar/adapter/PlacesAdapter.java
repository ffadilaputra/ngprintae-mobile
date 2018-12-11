package ffadilaputra.org.bottom_toolbar.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.location.places.Place;

import java.util.ArrayList;

import ffadilaputra.org.bottom_toolbar.R;

public class PlacesAdapter extends RecyclerView.Adapter <PlacesAdapter.PlaceViewHolder> {

	private ArrayList<Place> places = new ArrayList<>() ;


	public PlacesAdapter(ArrayList<Place> places){
		this.places = places;
	}

	@NonNull
	@Override
	public PlacesAdapter.PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_item, parent, false);
		return new PlacesAdapter.PlaceViewHolder(v);
	}

	@Override
	public void onBindViewHolder(@NonNull PlacesAdapter.PlaceViewHolder holder, int position) {
		holder.placeName.setText(places.get(position).getName().toString());
		holder.telephone.setText(places.get(position).getPhoneNumber().toString());
		//holder.adress.setText(places.get(position).getAddress().toString());
		//holder.location.setText(places.get(position).getLocale().getDisplayName());
		//holder.website.setText((CharSequence) places.get(position).getWebsiteUri().toString());
	}

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
	}

	@Override
	public int getItemCount() {
		return places.size();
	}

	public class PlaceViewHolder extends RecyclerView.ViewHolder {
		private TextView placeName,telephone;
		public PlaceViewHolder(@NonNull View itemView) {
			super(itemView);
			placeName = (TextView)itemView.findViewById(R.id.name);
			telephone = (TextView)itemView.findViewById(R.id.address);

		}
	}
}
