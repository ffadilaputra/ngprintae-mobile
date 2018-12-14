package ffadilaputra.org.bottom_toolbar;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AddHistory extends AppCompatActivity {
    private int mAppWidgetId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_history);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }else{
            // Making the "Set Color" button invisible when
            // the application is launched directly
            //btnSetColor.setVisibility(View.INVISIBLE);
        }

    }

}
