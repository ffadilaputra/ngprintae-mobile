package ffadilaputra.org.bottom_toolbar;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.firebase.auth.FirebaseAuth;

import ffadilaputra.org.bottom_toolbar.fragment.PopularFragment;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        toolbar = getSupportActionBar();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar.setTitle("Shop");
    }

        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
//                        fragment = new PopularFragment();
//                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_history:
                        toolbar.setTitle("Ma Gift");
                        return true;
                    case R.id.navigation_cart:
                        return true;
                    case R.id.navigation_profile:
                        //auth.signOut();
                        return true;
                }
                return false;
            }
            private void loadFragment(Fragment fragment) {

            }
        };
    }
