package pe.com.orbis.storesdk.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ricardo Bravo on 23/02/17.
 */

public class SDKApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        SDKApplication.context = getApplicationContext();
    }

    /**
     * Gets app context.
     *
     * @return the app context
     */

    public static Context getAppContext() {
        return SDKApplication.context;
    }
}
