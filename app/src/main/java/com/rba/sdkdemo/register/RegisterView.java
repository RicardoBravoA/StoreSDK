package com.rba.sdkdemo.register;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public interface RegisterView {

    void init();

    void nextActivity();

    void showEmailError();

    void hideEmailError();

    void showPasswordError();

    void hidePasswordError();

    void showNameError();

    void hideNameError();

    void showSurnameError();

    void hideSurnameError();

    void validateData();

    void showErrorMessage(String message);

    void showLoading();

    void hideLoading();

}
