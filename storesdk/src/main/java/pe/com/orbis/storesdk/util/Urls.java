package pe.com.orbis.storesdk.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Ricardo Bravo on 1/02/17.
 */

public class Urls {

    /** @hide */
    public static final String URL_BASE = getUrlBase();

    public static String getUrlBase(){
        String url = "";
        Properties prop = new Properties();
        InputStream input;

        try {
            input = new FileInputStream("gradle.properties");
            prop.load(input);
            url = prop.getProperty("BASE_URL");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return  url;
    }


}
