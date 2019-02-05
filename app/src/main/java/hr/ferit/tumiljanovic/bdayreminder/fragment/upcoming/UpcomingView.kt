package hr.ferit.tumiljanovic.bdayreminder.fragment.upcoming

import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper

interface UpcomingView {

    fun showUpcomingBdays(dataList : List<RecyclerWrapper>)

}