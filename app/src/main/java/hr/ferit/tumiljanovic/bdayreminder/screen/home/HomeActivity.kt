package hr.ferit.tumiljanovic.bdayreminder.screen.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBar
import android.view.MenuItem
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.base.BaseActivity
import hr.ferit.tumiljanovic.bdayreminder.fragment.account_settings.AccountFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.home.HomeFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups.MyGroupsFragment
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject
import android.content.Intent
import android.support.v4.app.NavUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hr.ferit.tumiljanovic.bdayreminder.App
import hr.ferit.tumiljanovic.bdayreminder.model.User
import kotlinx.android.synthetic.main.nav_header.*
import android.support.v4.content.ContextCompat.startActivity
import android.app.Activity


class HomeActivity : BaseActivity(), HomeActivityView {

    @Inject
    lateinit var homeActivityPresenter: HomeActivityPresenter

    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)

        setFragment()

        if (savedInstanceState == null) {
            fragment = HomeFragment()
            loadFragment(HomeFragment())
        }

        setUpActionBar()

        handleNavigationItemSelection()

        setOnLogOutListener()

        homeActivityPresenter.getUserInfo()

    }

    private fun setFragment() {
        val currentFragment = super.sharedPref.getString("current_fragment", "fragment")
        when (currentFragment) {
            HomeFragment().javaClass.name -> fragment = HomeFragment()
            AccountFragment().javaClass.name -> fragment = AccountFragment()
            MyGroupsFragment().javaClass.name -> fragment = MyGroupsFragment()
        }
    }

    private fun setOnLogOutListener() {
        logout.setOnClickListener {
            homeActivityPresenter.logOut()
        }
    }

    private fun handleNavigationItemSelection() {
        nav_view.menu.getItem(0).isChecked = true
        nav_view.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.home -> fragment = HomeFragment()
                R.id.myGropus -> fragment = MyGroupsFragment()
                R.id.account -> fragment = AccountFragment()
            }
            loadFragment(fragment)

            super.sharedPref.edit().putString("current_fragment", fragment.javaClass.name).apply()
            menuItem.isChecked = !menuItem.isChecked
            menuItem.isChecked = true
            drawerLayout.closeDrawers()


            true
        }

    }

    private fun setUpActionBar() {
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayShowTitleEnabled(false)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_frame, fragment, "fragmentTag").addToBackStack(null).commit()
    }

    override fun onLogOut() {
        finish()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (fragment is HomeFragment) {
                finish()
            } else {
                fragment = HomeFragment()
                nav_view.menu.getItem(0).isChecked = true
                loadFragment(HomeFragment())
            }
        }
    }

    override fun setNameAndPicture(user: User) {
        if (user.image != "") {
            Glide.with(App.instance)
                    .load(user.image)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivUserPhoto)
        }
        val fullName = user.firstName + " " + user.lastName
        tvUserName.text = fullName
    }

    override fun recreate() {
        val intent = intent
        finish()
        startActivity(intent)
    }


}
