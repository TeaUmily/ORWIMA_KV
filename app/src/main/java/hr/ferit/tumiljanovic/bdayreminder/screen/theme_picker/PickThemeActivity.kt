package hr.ferit.tumiljanovic.bdayreminder.screen.theme_picker

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.widget.Toast
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.base.BaseActivity
import kotlinx.android.synthetic.main.activity_pick_theme.*

class PickThemeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_theme)

        initUI()
    }

    private fun initUI() {
        ivBackArrowPickTheme.setOnClickListener { onBackPressed() }
        defaultTheme.setOnClickListener { changeTheme("default") }
        mintTheme.setOnClickListener { changeTheme("mint") }
        lilacTheme.setOnClickListener { changeTheme("lilac") }
        redTheme.setOnClickListener { changeTheme("red") }
        brownTheme.setOnClickListener { changeTheme("brown") }
        grayTheme.setOnClickListener { changeTheme("gray") }
    }


    private fun changeTheme(theme: String) {
        super.sharedPref.edit().putString("current_theme",
                theme).apply()
        recreate()
        Toast.makeText(this, "Theme changed to $theme", Toast.LENGTH_SHORT).show()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount >  0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

}
