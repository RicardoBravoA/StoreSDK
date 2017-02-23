package pe.com.orbis.storesdk.api;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pe.com.orbis.storesdk.BuildConfig;
import pe.com.orbis.storesdk.util.UrlSdk;
import pe.com.orbis.storesdk.util.Urls;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public class StoreApiManager {

    private static StoreApi storeApi;

    /**  @hide */
    public static StoreApi apiManager(Context context) {

        if(storeApi == null){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Urls.getUrlBase(context))
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            storeApi = client.create(StoreApi.class);
        }

        return storeApi;
    }

    public static Retrofit getRetrofit(Context context){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();

        return new Retrofit.Builder()
                .baseUrl(Urls.getUrlBase(context))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
