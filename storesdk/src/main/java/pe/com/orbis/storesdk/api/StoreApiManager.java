package pe.com.orbis.storesdk.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pe.com.orbis.storesdk.BuildConfig;
import pe.com.orbis.storesdk.util.Urls;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public class StoreApiManager {

    private static StoreApi storeApi;

    /**
     * Api manager store api.
     *
     * @return the store api
     */

    public static StoreApi apiManager() {

        if(storeApi == null){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);

            if(BuildConfig.IS_DEBUG){
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            }

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Urls.URL_BASE)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            storeApi = client.create(StoreApi.class);
        }

        return storeApi;
    }

    /**
     * Get retrofit retrofit.
     *
     * @return the retrofit
     */

    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();

        return new Retrofit.Builder()
                .baseUrl(Urls.loadUrl().getUrl_base())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
