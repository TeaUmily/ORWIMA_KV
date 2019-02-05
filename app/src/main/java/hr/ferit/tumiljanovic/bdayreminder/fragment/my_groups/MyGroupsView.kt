package hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups

import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper

interface MyGroupsView {

    fun showMyGroupsInfo(dataList: List<RecyclerWrapper>)
}