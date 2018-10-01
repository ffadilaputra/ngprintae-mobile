package ffadilaputra.org.bottom_toolbar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ffadilaputra.org.bottom_toolbar.R;

public class PopularFragment extends Fragment{

    public PopularFragment(){

    }

    public PopularFragment newInstance(String a,String b){
        PopularFragment fragment = new PopularFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_popular, container, false);
    }
}
