package com.example.mvpsample.login;

public class LoginPresenterImplementation implements LoginPresenter, LoginInteractor.onLoginFinishedListener{

    //create objects of the interfaces so that the Presenter can talk to the View and Model(so we create 2 objects)

    //to interact with the view section
    LoginView mLoginView;

    //to interact with the Model section
    LoginInteractor mLoginInteractor;

    //create constructor for LoginView
    public LoginPresenterImplementation(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        //create object for mLoginInteractor
        mLoginInteractor = new LoginInteractorImplementation();//LoginInteractorImplementation implements LoginInteractor so this connection is valid
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
            mLoginInteractor.login(username, password, this);
        }
    }

    @Override
    public void onDestroy() {
        if (mLoginView != null) {
            mLoginView = null; //destroy the login view
        }

    }

    @Override
    public void onUserNameError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setUserNameError();

        }

    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setPasswordError();


        }

    }

    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.navigateToMain();

        }

    }

    @Override
    public void onFailure(String message) {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.showAlert(message);

        }

    }
}
