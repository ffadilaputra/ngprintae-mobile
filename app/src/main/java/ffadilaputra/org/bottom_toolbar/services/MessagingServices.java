package ffadilaputra.org.bottom_toolbar.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

import ffadilaputra.org.bottom_toolbar.R;

public class MessagingServices extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotifications(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    private void showNotifications(String title, String body) {
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "ffadilaputra.org.bottom_toolbar";

        NotificationCompat.Builder noBuilder = new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);
        noBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.mipmap.ic_notip)
                .setContentTitle(title)
                .setContentText(body)
                .setContentInfo("Info_tes");
        notificationManager.notify(new Random().nextInt(),noBuilder.build());
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d("Tokenisasi", s);
    }
}
