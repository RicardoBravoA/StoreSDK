package com.rba.sdkdemo.login;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public interface LoginView {

    void init();

    void nextActivity();

    void showEmailError();

    void hideEmailError();

    void showPasswordError();

    void hidePasswordError();

    void validateData();

    void showErrorMessage(String message);

    void showLoading();

    void hideLoading();

}
