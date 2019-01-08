package hr.ferit.tumiljanovic.bdayreminder.login

interface LoginView {

    fun showPasswordError()

    fun showEmailError()

    fun onLoginSuccess()

    fun showLoginError()

}