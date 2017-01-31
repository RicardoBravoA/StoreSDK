package com.rba.sdkdemo.login;

import com.rba.sdkdemo.util.Util;

import pe.com.orbis.storesdk.model.request.LoginRequest;
import pe.com.orbis.storesdk.model.response.ErrorResponse;
import pe.com.orbis.storesdk.model.response.LoginResponse;
import pe.com.orbis.storesdk.service.login.LoginCallback;
import pe.com.orbis.storesdk.service.login.LoginService;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public class LoginPresenter implements LoginCallback {

    private LoginView loginView;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }

    public void login(LoginRequest loginRequest) {
        loginView.showLoading();
        LoginService.login(loginRequest, this);
    }

    public boolean validEmail(String email){
        return Util.validEmail(email);
    }

    public boolean validPassword(String password){
        return Util.validPassword(password);
    }

    @Override
    public void onLoginResponse(LoginResponse loginResponse) {
        loginView.hideLoading();
        loginView.nextActivity();
    }

    @Override
    public void onLoginError(ErrorResponse errorResponse) {
        loginView.hideLoading();
        loginView.showErrorMessage(errorResponse.get_meta().getMessage());
    }

}
