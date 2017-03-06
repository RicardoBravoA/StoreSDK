package pe.com.orbis.storesdk.service.login;

import pe.com.orbis.storesdk.api.ErrorUtil;
import pe.com.orbis.storesdk.api.StoreApiManager;
import pe.com.orbis.storesdk.model.request.LoginRequest;
import pe.com.orbis.storesdk.model.response.ErrorResponse;
import pe.com.orbis.storesdk.model.response.LoginResponse;
import pe.com.orbis.storesdk.util.Urls;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public class LoginService {

    /**
     * Login.
     *
     * @param loginRequest the login request
     * @param callback     the callback
     */

    public static void login(LoginRequest loginRequest, final LoginCallback callback){
        LoginServiceImpl.login(loginRequest, callback);
    }

}
