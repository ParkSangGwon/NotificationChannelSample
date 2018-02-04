package gun0912.notificationchannel;

import android.app.Application;
import android.os.Build;

/**
 * Created by TedPark on 2018. 2. 3..
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager.createChannel(this);
        }
    }
}
