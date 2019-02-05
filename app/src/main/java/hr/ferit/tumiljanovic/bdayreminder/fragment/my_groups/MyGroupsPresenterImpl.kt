package hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups

import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper
import hr.ferit.tumiljanovic.bdayreminder.base.view_holders.group_card.GroupCardHolderData
import javax.inject.Inject

class MyGroupsPresenterImpl @Inject constructor(val myGroupsView: MyGroupsView) : MyGroupsPresenter {


    override fun getMyGropusInfo() {
        var list: MutableList<RecyclerWrapper> = ArrayList()
        list.add(RecyclerWrapper(GroupCardHolderData("", "",""), RecyclerWrapper.TYPE_GROUP_CARD))
        list.add(RecyclerWrapper(GroupCardHolderData("","",""), RecyclerWrapper.TYPE_GROUP_CARD))
        list.add(RecyclerWrapper(GroupCardHolderData("","",""), RecyclerWrapper.TYPE_GROUP_CARD))
        list.add(RecyclerWrapper(GroupCardHolderData("","",""), RecyclerWrapper.TYPE_GROUP_CARD))
        list.add(RecyclerWrapper(GroupCardHolderData("","",""), RecyclerWrapper.TYPE_GROUP_CARD))
        list.add(RecyclerWrapper(GroupCardHolderData("","",""), RecyclerWrapper.TYPE_GROUP_CARD))
        myGroupsView.showMyGroupsInfo(list)
    }
}