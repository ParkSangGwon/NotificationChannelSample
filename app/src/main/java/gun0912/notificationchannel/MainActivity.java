package gun0912.notificationchannel;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_message).setOnClickListener(this);
        findViewById(R.id.btn_comment).setOnClickListener(this);
        findViewById(R.id.btn_notice).setOnClickListener(this);
        findViewById(R.id.btn_setting_message).setOnClickListener(this);
        findViewById(R.id.btn_setting).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_message:
                NotificationManager.sendNotification(this, 1, NotificationManager.Channel.MESSAGE, "Message title", "Message body");
                break;
            case R.id.btn_comment:
                NotificationManager.sendNotification(this, 2, NotificationManager.Channel.COMMENT, "Comment title", "Comment body");
                break;
            case R.id.btn_notice:
                NotificationManager.sendNotification(this, 3, NotificationManager.Channel.NOTICE, "Notice title", "Notice body");
                break;
            case R.id.btn_setting_message:
                goToNotificationSettings(NotificationManager.Channel.MESSAGE);
                break;
            case R.id.btn_setting:
                goToNotificationSettings();
                break;
        }

    }

    /**
     * Send Intent to load system Notification Settings for this app.
     */
    public void goToNotificationSettings() {
        Intent i = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
        i.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
        startActivity(i);
    }

    /**
     * Send intent to load system Notification Settings UI for a particular channel.
     *
     * @param channel Name of channel to configure
     */
    public void goToNotificationSettings(String channel) {
        Intent i = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
        i.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
        i.putExtra(Settings.EXTRA_CHANNEL_ID, channel);
        startActivity(i);
    }
}
