package pe.com.orbis.storesdk.service.login;

import pe.com.orbis.storesdk.model.response.ErrorResponse;
import pe.com.orbis.storesdk.model.response.LoginResponse;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public interface LoginCallback {

    void onLoginResponse(LoginResponse loginResponse);

    void onLoginError(ErrorResponse errorResponse);

}
