package com.example.mvpsample.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractorImplementation implements LoginInteractor {
    @Override
    public void login(String username, String password, final onLoginFinishedListener onLoginFinishedListener) {

        if(TextUtils.isEmpty(username)){
            onLoginFinishedListener.onUserNameError();
        }

        else if(TextUtils.isEmpty(password)){
            onLoginFinishedListener.onPasswordError();
        }

        else if(username.equals("admin") && password.equals("12345"))
        {
            //if you want to make any API calls to server and validate username and password present on database, do here
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    onLoginFinishedListener.onSuccess();
                }
            }, 3000);
            onLoginFinishedListener.onSuccess();
        }
        else {
            onLoginFinishedListener.onFailure("Invalid Credentials");
        }

    }
}
