package pe.com.orbis.storesdk.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Ricardo Bravo on 1/02/17.
 */

public class Urls {

    public final String URL_BASE = getUrlBase();

    public String getUrlBase(){
        String url = "";
        /*
        Properties prop = new Properties();
        InputStream input;

        try {
            input = new FileInputStream("gradle.properties");
            prop.load(input);
            url = prop.getProperty("BASE_URL");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        */

        Properties prop = new Properties();
        InputStream input = null;

        try{
            String filename = "gradle.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            prop.load(input);

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);

                if(key.equals("BASE_URL")){
                    url = value;
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return  url;
    }


}
