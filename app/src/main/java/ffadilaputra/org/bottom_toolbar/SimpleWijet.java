package ffadilaputra.org.bottom_toolbar;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class SimpleWijet extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

        Intent intent = new Intent(context, AddHistory.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetIds);
        intent.setData(Uri.parse("tel:/"+ (int)System.currentTimeMillis()));

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.simple_wijet);
        views.setOnClickPendingIntent(R.id.layout_wijet,pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetIds,views);
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
            int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);


        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.simple_wijet);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        //views.setTextViewText(R.id.dream_text, widgetDreamText);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://airbnb.com"));
        //Intent hihi = new Intent(context, AddHistory.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
        //PendingIntent tes = PendingIntent.getActivity(context,0,hihi,0);

        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);
        //views.setOnClickPendingIntent(R.id.dream_text, tes);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}

