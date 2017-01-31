package com.rba.sdkdemo.register;

import com.rba.sdkdemo.util.Util;

import pe.com.orbis.storesdk.model.request.RegisterRequest;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public class RegisterPresenter {

    private RegisterView registerView;

    public RegisterPresenter(RegisterView registerView){
        this.registerView = registerView;
    }

    public void register(RegisterRequest registerRequest) {
        registerView.showLoading();
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

}
