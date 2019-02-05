package hr.ferit.tumiljanovic.bdayreminder.screen.login

import hr.ferit.tumiljanovic.bdayreminder.common.isEmailValid
import hr.ferit.tumiljanovic.bdayreminder.common.isPasswordValid
import hr.ferit.tumiljanovic.bdayreminder.firebase.authentication.FirebaseAuthenticationInterface
import hr.ferit.tumiljanovic.bdayreminder.model.LoginRequest
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(private var loginView: LoginView, private val authentication: FirebaseAuthenticationInterface) : LoginPresenter {


    private val loginRequest = LoginRequest()

    override fun onLoginClick() {
        if (loginRequest.isValid()) {
            authentication.login(loginRequest.email, loginRequest.password) { isSuccess ->
                if (isSuccess) {
                    loginView.onLoginSuccess()
                } else {
                    loginView.showLoginError()
                }
            }
        }
    }

    override fun onEmailChanged(email: String) {
        loginRequest.email = email

        if (!isEmailValid(email)) {
            loginView.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        loginRequest.password = password

        if (!isPasswordValid(password)) {
            loginView.showPasswordError()
        }
    }

}