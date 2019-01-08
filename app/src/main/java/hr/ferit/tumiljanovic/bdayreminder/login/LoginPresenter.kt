package hr.ferit.tumiljanovic.bdayreminder.login

interface LoginPresenter {

    fun onLoginClick()

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

}