package com.example.mvpsample.login;

public interface LoginInteractor {
    //this is implementation of the model layer
    //returns actual result if login was successful or not

    interface onLoginFinishedListener{

        //get username as error
        void onUserNameError();

        void onPasswordError();

        void onSuccess();

        void onFailure(String message);
    }

    void login(String username, String password, onLoginFinishedListener onLoginFinishedListener);
}
