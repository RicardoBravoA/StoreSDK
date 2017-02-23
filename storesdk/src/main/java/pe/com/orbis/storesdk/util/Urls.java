package pe.com.orbis.storesdk.util;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ricardo Bravo on 1/02/17.
 */

public class Urls {

    //public static final String URL_BASE = getUrlBase(Context context);

    public static String getUrlBase(Context context){
        String url = "";

        InputStream input;
        try {
            input = context.getAssets().open("key.txt");

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            url = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
            url = "";
        }


        return  url;
    }


}
