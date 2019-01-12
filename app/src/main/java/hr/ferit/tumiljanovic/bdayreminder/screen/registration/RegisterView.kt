package hr.ferit.tumiljanovic.bdayreminder.screen.registration

interface RegisterView {

    fun onRegisterSuccess()

    fun showFirstNameError()

    fun showLastNameError()

    fun showSignUpError()

    fun showEmailError()

    fun showPasswordError()

    fun showPasswordMatchingError()

    fun showBirthDateError()

}