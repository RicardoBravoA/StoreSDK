package com.rba.sdkdemo.register;

import com.rba.sdkdemo.util.Util;

import pe.com.orbis.storesdk.model.request.RegisterRequest;
import pe.com.orbis.storesdk.model.response.ErrorResponse;
import pe.com.orbis.storesdk.model.response.RegisterResponse;
import pe.com.orbis.storesdk.service.register.RegisterCallback;
import pe.com.orbis.storesdk.service.register.RegisterService;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public class RegisterPresenter implements RegisterCallback {

    private RegisterView registerView;

    public RegisterPresenter(RegisterView registerView){
        this.registerView = registerView;
    }

    public void register(RegisterRequest registerRequest) {
        registerView.showLoading();
        RegisterService.register(registerRequest, this);
    }

    public boolean validEmail(String email){
        return Util.validEmail(email);
    }

    public boolean validPassword(String password){
        return Util.validPassword(password);
    }

    public boolean validName(String name){
        return Util.validName(name);
    }

    public boolean validSurname(String surname){
        return Util.validName(surname);
    }

    @Override
    public void onRegisterResponse(RegisterResponse registerResponse) {
        registerView.hideLoading();

    }

    @Override
    public void onRegisterError(ErrorResponse errorResponse) {
        registerView.hideLoading();
        registerView.showErrorMessage(errorResponse.get_meta().getMessage());
    }
}
