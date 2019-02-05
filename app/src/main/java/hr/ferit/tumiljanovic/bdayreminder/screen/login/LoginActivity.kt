package hr.ferit.tumiljanovic.bdayreminder.screen.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import hr.ferit.tumiljanovic.bdayreminder.screen.home.HomeActivity
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.base.BaseActivity
import hr.ferit.tumiljanovic.bdayreminder.common.onTextChanged
import hr.ferit.tumiljanovic.bdayreminder.screen.registration.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginView {

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initUi()
    }

    private fun initUi() {
        tvRegister.setOnClickListener { startActivity(Intent(applicationContext, RegisterActivity::class.java)) }
        etEmail.onTextChanged { loginPresenter.onEmailChanged(it) }
        etPassword.onTextChanged { loginPresenter.onPasswordChanged(it) }
        bLogin.setOnClickListener { loginPresenter.onLoginClick() }
    }

    override fun showPasswordError() {
        etPassword.error = getString(R.string.password_error)    }

    override fun showEmailError() {
        etEmail.error = getString(R.string.email_error)
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show()
        startActivity(Intent(applicationContext, HomeActivity::class.java))

    }

    override fun showLoginError() {
        Toast.makeText(this, "Some error occurred", Toast.LENGTH_SHORT).show()

    }


}

