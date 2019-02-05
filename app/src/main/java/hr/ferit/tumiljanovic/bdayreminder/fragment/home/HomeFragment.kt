package hr.ferit.tumiljanovic.bdayreminder.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.viewPager
import kotlinx.android.synthetic.main.fragment_home.tabLayout
import javax.inject.Inject

class HomeFragment @Inject constructor() : BaseFragment(), HomeFragmentView {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PagerAdapter(childFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)?.setIcon(R.drawable.selector_cake)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.selector_calendar)

    }
}