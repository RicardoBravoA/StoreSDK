package pe.com.orbis.storesdk.service.register;

import pe.com.orbis.storesdk.model.response.ErrorResponse;
import pe.com.orbis.storesdk.model.response.RegisterResponse;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public interface RegisterCallback {

    void onRegisterResponse(RegisterResponse registerResponse);

    void onRegisterError(ErrorResponse errorResponse);

}
