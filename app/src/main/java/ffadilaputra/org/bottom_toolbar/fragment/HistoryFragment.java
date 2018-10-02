package ffadilaputra.org.bottom_toolbar.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ffadilaputra.org.bottom_toolbar.R;
import ffadilaputra.org.bottom_toolbar.adapter.MovieAdapter;
import ffadilaputra.org.bottom_toolbar.model.Movie;

public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList = new ArrayList<>();

    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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
         View view = inflater.inflate(R.layout.fragment_history,container,false);

         recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
         movieAdapter = new MovieAdapter(movieList);
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setItemAnimator(new DefaultItemAnimator());
         recyclerView.setAdapter(movieAdapter);
         prepareMovie();
         return view;
    }

    private void prepareMovie() {
        Movie movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);
        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);
        movie = new Movie("Family Friendly", "Animation", "2015");
        movieList.add(movie);
        movieAdapter.notifyDataSetChanged();
    }

}
