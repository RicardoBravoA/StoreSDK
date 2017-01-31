package com.rba.sdkdemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.rba.sdkdemo.R;
import com.rba.sdkdemo.list.ListActivity;
import com.rba.sdkdemo.loading.Loading;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import pe.com.orbis.storesdk.model.request.LoginRequest;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.tilEmail) TextInputLayout tilEmail;
    @BindView(R.id.txtEmail) AppCompatEditText txtEmail;
    @BindView(R.id.tilPassword) TextInputLayout tilPassword;
    @BindView(R.id.txtPassword) AppCompatEditText txtPassword;
    @BindView(R.id.clGeneral) CoordinatorLayout clGeneral;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private LoginPresenter loginPresenter;
    private Loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        loading = new Loading(this);
        loginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.btnLogin)
    public void onClickLogin() {
        validateData();
    }

    @OnTextChanged(value = R.id.txtPassword, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPasswordInput() {
        if(!TextUtils.isEmpty(txtPassword.getText().toString())){
            hidePasswordError();
        }
    }

    @OnTextChanged(value = R.id.txtEmail, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterEmailInput() {
        if(!TextUtils.isEmpty(txtEmail.getText().toString())){
            hideEmailError();
        }
    }

    @Override
    public void nextActivity() {
        startActivity(new Intent(this, ListActivity.class));
    }

    @Override
    public void showEmailError() {
        tilEmail.requestFocus();
        tilEmail.setErrorEnabled(true);
        tilEmail.setError(getString(R.string.error_email));
    }

    @Override
    public void hideEmailError() {
        tilEmail.setErrorEnabled(false);
        tilEmail.setError("");
    }

    @Override
    public void showPasswordError() {
        tilPassword.requestFocus();
        tilPassword.setErrorEnabled(true);
        tilPassword.setError(getString(R.string.error_password));
    }

    @Override
    public void hidePasswordError() {
        tilPassword.setErrorEnabled(false);
        tilPassword.setError("");
    }

    @Override
    public void validateData() {
        if(!loginPresenter.validEmail(txtEmail.getText().toString().trim())){
            showEmailError();
            return;
        }

        if(!loginPresenter.validPassword(txtPassword.getText().toString().trim())){
            showPasswordError();
            return;
        }

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(txtEmail.getText().toString().trim());
        loginRequest.setPassword(txtPassword.getText().toString());

        loginPresenter.login(loginRequest);
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(clGeneral, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        if(!loading.isShowing()){
            loading.show();
        }
    }

    @Override
    public void hideLoading() {
        if(loading.isShowing()){
            loading.dismiss();
        }
    }
}
