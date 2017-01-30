package pe.com.orbis.storesdk.api;

import pe.com.orbis.storesdk.BuildConfig;
import pe.com.orbis.storesdk.model.request.LoginRequest;
import pe.com.orbis.storesdk.model.request.RegisterRequest;
import pe.com.orbis.storesdk.model.response.LoginResponse;
import pe.com.orbis.storesdk.model.response.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public interface StoreApi {

    @Headers("Content-Type: application/json")
    @POST(BuildConfig.URL_LOGIN)
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @Headers("Content-Type: application/json")
    @POST(BuildConfig.URL_REGISTER)
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

}
