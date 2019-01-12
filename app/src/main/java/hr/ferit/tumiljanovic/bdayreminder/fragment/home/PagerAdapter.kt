package hr.ferit.tumiljanovic.bdayreminder.fragment.home


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import hr.ferit.tumiljanovic.bdayreminder.App
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.fragment.upcoming.UpcomingFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    var size: Int = 2

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> UpcomingFragment()
            1 -> UpcomingFragment()
            else -> UpcomingFragment()
        }

    }

    override fun getCount() = size

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> App.instance.resources.getString(R.string.upcoming)
            1 -> App.instance.resources.getString(R.string.calendar)
            else -> ""
        }
    }

}