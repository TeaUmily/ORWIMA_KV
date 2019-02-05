package hr.ferit.tumiljanovic.bdayreminder.base

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import hr.ferit.tumiljanovic.bdayreminder.R


open class BaseActivity : AppCompatActivity() {


    private lateinit var currentTheme: String
    protected lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        currentTheme = sharedPref.getString("current_theme", "default")
        setAppTheme(currentTheme)

    }

    override fun onResume() {
        super.onResume()
        val theme = sharedPref.getString("current_theme", "default")
        if(currentTheme != theme)
            recreate()
    }


    private fun setAppTheme(currentTheme: String) {
        when (currentTheme) {
            DEFAULT_THEME -> setTheme(R.style.Theme_App_Default)
            MINT_THEME -> setTheme(R.style.Theme_App_Mint)
            LILAC_THEME -> setTheme(R.style.Theme_App_Lilac)
            RED_THEME -> setTheme(R.style.Theme_App_Red)
            BROWN_THEME -> setTheme(R.style.Theme_App_Brown)
            GRAY_THEME -> setTheme(R.style.Theme_App_Gray)
            else -> setTheme(R.style.Theme_App_Default)
        }
    }

    companion object {
        private const val MINT_THEME = "mint"
        private const val DEFAULT_THEME = "default"
        private const val LILAC_THEME = "lilac"
        private const val RED_THEME = "red"
        private const val BROWN_THEME = "brown"
        private const val GRAY_THEME = "gray"
    }


}