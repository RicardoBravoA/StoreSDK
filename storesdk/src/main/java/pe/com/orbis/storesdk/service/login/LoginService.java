package pe.com.orbis.storesdk.service.login;

import pe.com.orbis.storesdk.impl.LoginServiceImpl;
import pe.com.orbis.storesdk.model.request.LoginRequest;

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
        LoginServiceImpl loginService = new LoginServiceImpl(loginRequest, callback);
        loginService.getLogin();
    }

}
