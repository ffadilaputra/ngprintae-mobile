package ffadilaputra.org.bottom_toolbar.fragment;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

import ffadilaputra.org.bottom_toolbar.R;
import ffadilaputra.org.bottom_toolbar.model.TestimoniModel;

public class MediaFragment extends Fragment {

	private VideoView videoView;
	private ListView listView;
	private ArrayList<String> listVideo;
	private ArrayAdapter adapter;
	private TextView textLoading;

	public MediaFragment(){

	}

	public MediaFragment newInstance(String a,String b){
		MediaFragment fragment = new MediaFragment();
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

		View view = inflater.inflate(R.layout.profil,container,false);

		videoView =(VideoView) view.findViewById(R.id.videoView);
		listView = (ListView) view.findViewById(R.id.listView);
		textLoading = (TextView) view.findViewById(R.id.textLoading);
		textLoading.setVisibility(VideoView.INVISIBLE);

		listVideo = new ArrayList<>();
		listVideo.add("tersandung");
		listVideo.add("terjungkir");
		listVideo.add("terbalik");


		adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,TestimoniModel.testimoni);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				TestimoniModel testimoniModel = TestimoniModel.testimoni[(int) id];
				Uri videoUri = getMediaResources(testimoniModel.getVideoRawId());
				createPlayerUI(videoUri);

			}
		});
		return view;
		}

	private Uri getMediaResources(String videoUri) {
		if (URLUtil.isValidUrl(videoUri)) {
			return  Uri.parse(videoUri);
		}
		else {
			return Uri.parse(("android.resource://" + getActivity().getPackageName()+"/raw/"+videoUri));
		}
	}

	private void createPlayerUI(Uri videoUri) {
		textLoading.setVisibility(VideoView.VISIBLE);
		videoView.setVideoURI(videoUri);
		MediaController mc = new MediaController(getActivity());
		videoView.setMediaController(mc);
		mc.setAnchorView(videoView);

		videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mp) {
				textLoading.setVisibility(VideoView.INVISIBLE);
				videoView.start();
			}
		});

		videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				Toast.makeText(getActivity(),"video tamat",Toast.LENGTH_SHORT).show();
				videoView.seekTo(0);
			}
		});
		videoView.requestFocus();
		videoView.start();
	}
	}
