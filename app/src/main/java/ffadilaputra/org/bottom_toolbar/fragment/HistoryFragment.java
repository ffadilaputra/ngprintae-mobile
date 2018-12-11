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
import ffadilaputra.org.bottom_toolbar.adapter.HistoryAdapter;
import ffadilaputra.org.bottom_toolbar.model.History;

public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;
    private List<History> historyList = new ArrayList<>();

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
        historyAdapter = new HistoryAdapter(historyList);
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setItemAnimator(new DefaultItemAnimator());
         recyclerView.setAdapter(historyAdapter);
         prepareData();
         return view;
    }

    private void prepareData() {
        History history = new History("Bromo Trip", "Bromo trip uhuy", "2015");
        historyList.add(history);
        history = new History("BJBR", "Gratisan uhuy", "2018");
        historyList.add(history);
        historyAdapter.notifyDataSetChanged();
    }

}
