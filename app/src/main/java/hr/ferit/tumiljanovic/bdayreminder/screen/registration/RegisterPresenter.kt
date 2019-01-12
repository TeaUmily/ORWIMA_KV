package hr.ferit.tumiljanovic.bdayreminder.screen.registration


interface RegisterPresenter {

    fun onFirstNameChanged(firstName: String)

    fun onLastNameChanged(lastName: String)

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onConfirmPasswordChanged(repeatPassword: String)

    fun onBirthDateChanged(birthDate: String)

    fun onRegisterClick()
}
