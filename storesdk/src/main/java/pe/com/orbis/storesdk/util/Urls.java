package pe.com.orbis.storesdk.util;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import pe.com.orbis.storesdk.app.SDKApplication;
import pe.com.orbis.storesdk.model.entity.UrlEntity;

/**
 * Created by Ricardo Bravo on 1/02/17.
 */

public class Urls {

    public static String URL_BASE = loadUrl().getUrl_base();
    public static String URL_LOGIN = loadUrl().getUrl_login();
    public static String URL_REGISTER = loadUrl().getUrl_register();


    /**
     * Load url url entity.
     *
     * @return the url entity
     */

    public static UrlEntity loadUrl() {
        String json = null;
        try {
            InputStream is = SDKApplication.getAppContext().getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new Gson().fromJson(json, UrlEntity.class);
    }

}
