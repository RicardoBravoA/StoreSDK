package pe.com.orbis.storesdk.api;

import pe.com.orbis.storesdk.model.request.LoginRequest;
import pe.com.orbis.storesdk.model.request.RegisterRequest;
import pe.com.orbis.storesdk.model.response.LoginResponse;
import pe.com.orbis.storesdk.model.response.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public interface StoreApi {

    @Headers("Content-Type: application/json")
    @POST
    Call<LoginResponse> login(@Url String url, @Body LoginRequest loginRequest);

    @Headers("Content-Type: application/json")
    @POST
    Call<RegisterResponse> register(@Url String url, @Body RegisterRequest registerRequest);

}
