package com.example.mvpsample.login;

public interface LoginView {

    //show progress bar
    void showProgress();

    //hide progress bar
    void hideProgress();

    //when username is wrong, show error
    void setUserNameError();

    //when password is wrong, show error
    void setPasswordError();

    //if username and password are correct go to main activity
    void navigateToMain();

    //if you get an error on login, ie. if if username and password are wrong show error
    void showAlert(String message);

}
