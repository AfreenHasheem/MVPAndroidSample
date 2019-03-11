package com.example.mvpsample.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpsample.MainActivity;
import com.example.mvpsample.R;

public class LoginActivity extends AppCompatActivity implements LoginView {
    //LoginActivity has to implement all the methods inside LoginView interface

    private EditText username,userPassword;
    private Button btnLogin;
    private ProgressBar progressBar;

    //create object of login presenter in LoginActivity to interact with Presenter
    private LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginPresenter = new LoginPresenterImplementation(this);

        username = findViewById(R.id.userName);
        userPassword = findViewById(R.id.userPassword);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.validateCredentials(username.getText().toString().trim(), userPassword.getText().toString().trim());
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setUserNameError() {
        username.setError("Username is empty");

    }

    @Override
    public void setPasswordError() {
        userPassword.setError("Password id empty");

    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
