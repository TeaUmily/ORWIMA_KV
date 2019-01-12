package hr.ferit.tumiljanovic.bdayreminder.screen.registration


import hr.ferit.tumiljanovic.bdayreminder.common.arePasswordsSame
import hr.ferit.tumiljanovic.bdayreminder.common.isBirthDateValid
import hr.ferit.tumiljanovic.bdayreminder.common.isEmailValid
import hr.ferit.tumiljanovic.bdayreminder.common.isPasswordValid
import hr.ferit.tumiljanovic.bdayreminder.firebase.authentication.FirebaseAuthenticationInterface
import hr.ferit.tumiljanovic.bdayreminder.firebase.database.FirebaseDatabaseInterface
import hr.ferit.tumiljanovic.bdayreminder.model.RegisterRequest
import javax.inject.Inject

class RegisterPresenterImpl @Inject constructor(private val registerView: RegisterView, private val database: FirebaseDatabaseInterface, private val authentication: FirebaseAuthenticationInterface) : RegisterPresenter {

    private val userData = RegisterRequest()


    override fun onEmailChanged(email: String) {
        userData.email = email

        if (!isEmailValid(email)) {
            registerView.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        userData.password = password

        if (!isPasswordValid(password)) {
            registerView.showPasswordError()
        }
    }

    override fun onConfirmPasswordChanged(repeatPassword: String) {
        userData.repeatPassword = repeatPassword

        if (!arePasswordsSame(userData.password, repeatPassword)) {
            registerView.showPasswordMatchingError()
        }
    }

    override fun onRegisterClick() {
        if (userData.isValid()) {
            val (email, password, repeatPassword, firstName, lastName, birthDate) = userData

            authentication.register(email, password) { isSuccessful ->
                if (isSuccessful) {
                    createUser(firstName, lastName, email, password, birthDate)
                    database.createUser(authentication.getUserId(),firstName,lastName,email,password,birthDate)
                    registerView.onRegisterSuccess()
                } else {
                    registerView.showSignUpError()
                }

            }
        }
    }

    private fun createUser(firstName: String, lastName: String, email: String, password: String, birthDate: String) {
        val id = authentication.getUserId()

        database.createUser(id, firstName, lastName, email, password, birthDate)
    }

    override fun onFirstNameChanged(firstName: String) {
        userData.firstName = firstName

        if (firstName.isEmpty()) {
            registerView.showFirstNameError()
        }
    }

    override fun onLastNameChanged(lastName: String) {
        userData.lastName = lastName

        if (lastName.isEmpty()) {
            registerView.showLastNameError()
        }
    }

    override fun onBirthDateChanged(birthDate: String) {
        userData.birthDate = birthDate

        if (!isBirthDateValid(birthDate)) {
            registerView.showBirthDateError()
        }


    }
}