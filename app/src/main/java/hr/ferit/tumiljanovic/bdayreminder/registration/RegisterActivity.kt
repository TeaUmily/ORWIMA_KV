package hr.ferit.tumiljanovic.bdayreminder.registration

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.base.BaseActivity
import hr.ferit.tumiljanovic.bdayreminder.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        ivBackArrow.setOnClickListener{
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        }
    }
}
