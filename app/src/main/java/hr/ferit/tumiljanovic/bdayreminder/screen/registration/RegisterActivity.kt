package hr.ferit.tumiljanovic.bdayreminder.screen.registration

import android.os.Bundle
import android.widget.Toast
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.common.onTextChanged
import hr.ferit.tumiljanovic.bdayreminder.base.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterView {

    @Inject
    lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initUi()
    }

    private fun initUi() {
        ivBackArrow.setOnClickListener { finish() }
        etEmail.onTextChanged { registerPresenter.onEmailChanged(it) }
        etPassword.onTextChanged { registerPresenter.onPasswordChanged(it) }
        etConfirmPassword.onTextChanged { registerPresenter.onConfirmPasswordChanged(it) }
        etFirstName.onTextChanged { registerPresenter.onFirstNameChanged(it) }
        etLastName.onTextChanged { registerPresenter.onLastNameChanged(it) }
        etBirthDate.onTextChanged { registerPresenter.onBirthDateChanged(it) }
        bRegister.setOnClickListener{registerPresenter.onRegisterClick()}
    }

    override fun onRegisterSuccess() {
        Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
    }

    override fun showSignUpError() {
        Toast.makeText(this, "Some error occurred", Toast.LENGTH_SHORT).show()
    }


    override fun showEmailError() {
        etEmail.error = getString(R.string.email_error)    }

    override fun showPasswordError() {
        etPassword.error = getString(R.string.password_error)
    }

    override fun showPasswordMatchingError() {
        etConfirmPassword.error = getString(R.string.confirm_password_error)
    }

    override fun showFirstNameError() {
        etFirstName.error = getString(R.string.empty_input_field_error)
    }

    override fun showLastNameError() {
        etLastName.error = getString(R.string.empty_input_field_error)
    }

    override fun showBirthDateError() {
        etBirthDate.error = getString(R.string.birthdate_error)
    }

}
