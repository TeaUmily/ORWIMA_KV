package hr.ferit.tumiljanovic.bdayreminder.login

import hr.ferit.tumiljanovic.bdayreminder.common.isEmailValid
import hr.ferit.tumiljanovic.bdayreminder.common.isPasswordValid
import hr.ferit.tumiljanovic.bdayreminder.model.LoginRequest
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(var loginView: LoginView) : LoginPresenter {


    private val loginRequest = LoginRequest()

    override fun onLoginClick() {
        if (loginRequest.isValid()) {
            /*authentication.login(loginRequest.email, loginRequest.password) { isSuccess ->
                if (isSuccess) {
                    view.onLoginSuccess()
                } else {
                    view.showLoginError()
                }
            }*/
        }
    }

    override fun onEmailChanged(email: String) {


        if (!isEmailValid(email)) {
            loginView.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        if (!isPasswordValid(password)) {
            loginView.showPasswordError()
        }
    }

}