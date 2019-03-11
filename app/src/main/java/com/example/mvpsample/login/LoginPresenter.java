package com.example.mvpsample.login;

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
