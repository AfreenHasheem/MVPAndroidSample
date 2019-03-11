# MVPAndroidSample
A basic MVP Android application.

Model-View-Presenter is a user interface architectural pattern engineered to facilitate automated unit testing and improve the separation of concerns in presentation logic:

- The Model is an interface defining the data to be displayed or otherwise acted upon in the user interface.

- The View is a passive interface that displays data the Model and routes user commands events to the presenter to act upon that data.

- The Presenter acts upon the model and the view. It retrieves data from repositories the model and formats it for display in the view.

User can enter a user name and password. Currently checking against a static username and password and validating to show errors respectively. 
There are three layers:
1. VIEW : LoginActivity and LoginView(interface)
2. PRESENTER: LoginPresenterImplementation and LoginPresenter(interface)
3. MODEL : LoginInteractorImplementation and LoginInteractor(interface). All the business logic is implemented here.
