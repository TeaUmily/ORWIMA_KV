package hr.ferit.tumiljanovic.bdayreminder.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.base.BaseActivity
import hr.ferit.tumiljanovic.bdayreminder.registration.RegisterActivity
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

        etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loginPresenter.onEmailChanged(s.toString())
            }
        })

        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loginPresenter.onPasswordChanged(s.toString())
            }
        })


        bLogin.setOnClickListener { loginPresenter.onLoginClick() }
    }


    override fun showPasswordError() {
        etPassword.error = getString(R.string.password_error)    }

    override fun showEmailError() {
        etEmail.error = getString(R.string.email_error)
    }

    override fun onLoginSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoginError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

