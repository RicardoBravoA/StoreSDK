package com.rba.sdkdemo.register;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;

import com.rba.sdkdemo.R;
import com.rba.sdkdemo.loading.Loading;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pe.com.orbis.storesdk.model.request.RegisterRequest;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tilEmail) TextInputLayout tilEmail;
    @BindView(R.id.txtEmail) AppCompatEditText txtEmail;
    @BindView(R.id.tilPassword) TextInputLayout tilPassword;
    @BindView(R.id.txtPassword) AppCompatEditText txtPassword;
    @BindView(R.id.tilName) TextInputLayout tilName;
    @BindView(R.id.txtName) AppCompatEditText txtName;
    @BindView(R.id.tilSurname) TextInputLayout tilSurname;
    @BindView(R.id.txtSurname) AppCompatEditText txtSurname;
    @BindView(R.id.clGeneral) TextInputLayout clGeneral;
    private Loading loading;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        loading = new Loading(this);
        registerPresenter = new RegisterPresenter(this);
    }

    @Override
    public void nextActivity() {

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
    public void showNameError() {
        tilName.requestFocus();
        tilName.setErrorEnabled(true);
        tilName.setError(getString(R.string.error_names));
    }

    @Override
    public void hideNameError() {
        tilName.setErrorEnabled(false);
        tilName.setError("");
    }

    @Override
    public void showSurnameError() {
        tilSurname.requestFocus();
        tilSurname.setErrorEnabled(true);
        tilSurname.setError(getString(R.string.error_surnames));
    }

    @Override
    public void hideSurnameError() {
        tilSurname.setErrorEnabled(false);
        tilSurname.setError("");
    }

    @Override
    public void validateData() {

        if(!registerPresenter.validName(txtName.getText().toString().trim())){
            showNameError();
            return;
        }

        if(!registerPresenter.validSurname(txtSurname.getText().toString().trim())){
            showSurnameError();
            return;
        }

        if(!registerPresenter.validEmail(txtEmail.getText().toString().trim())){
            showEmailError();
            return;
        }

        if(!registerPresenter.validPassword(txtPassword.getText().toString().trim())){
            showPasswordError();
            return;
        }

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName(txtName.getText().toString().trim());
        registerRequest.setSurname(txtSurname.getText().toString().trim());
        registerRequest.setEmail(txtEmail.getText().toString().trim());
        registerRequest.setPassword(txtPassword.getText().toString());

        registerPresenter.register(registerRequest);
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

    @OnClick(R.id.btnRegister)
    public void onClickRegister() {
        validateData();
    }

}
