package hr.ferit.tumiljanovic.bdayreminder.screen.login

interface LoginView {

    fun showPasswordError()

    fun showEmailError()

    fun onLoginSuccess()

    fun showLoginError()

}