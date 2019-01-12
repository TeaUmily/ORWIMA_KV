package hr.ferit.tumiljanovic.bdayreminder.screen.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBar
import android.view.MenuItem
import hr.ferit.tumiljanovic.bdayreminder.R import hr.ferit.tumiljanovic.bdayreminder.base.BaseActivity
import hr.ferit.tumiljanovic.bdayreminder.fragment.home.HomeFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.home.HomeView
import hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups.MyGroupsFragment
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)

        loadFragment(HomeFragment())

        setUpActionBar()

        handleNavigationItemSelection()

      //  logOut()

    }

    private fun logOut() {
        TODO("not implemented") // Treba se prebaciti na Login screen i odjaviti se s firebase racuna
    }

    private fun handleNavigationItemSelection() {
        nav_view.menu.getItem(0).isChecked = true
        nav_view.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.home -> loadFragment(homeFragment)
                R.id.myGropus -> loadFragment(MyGroupsFragment())

            }

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
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_frame, fragment)
        transaction.commit()
    }

}
