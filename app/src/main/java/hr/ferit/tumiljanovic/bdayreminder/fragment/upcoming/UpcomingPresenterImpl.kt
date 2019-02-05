package hr.ferit.tumiljanovic.bdayreminder.fragment.upcoming

import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper
import hr.ferit.tumiljanovic.bdayreminder.base.view_holders.bday_card.BdayCardHolderData
import hr.ferit.tumiljanovic.bdayreminder.base.view_holders.item_divder_by_date.DividerByDateData
import javax.inject.Inject

class UpcomingPresenterImpl @Inject constructor(var upcomingView: UpcomingView) : UpcomingPresenter {


    override fun getUpcomingBdays() {
        // treba izvuci datume za dividere i u listu ubaciti do 4 tjedna rodendane od danas
        var list: MutableList<RecyclerWrapper> = ArrayList()
        list.add(RecyclerWrapper(DividerByDateData("21.6.1993."), RecyclerWrapper.TYPE_DIVIDER_BY_DATE))
        list.add(RecyclerWrapper(BdayCardHolderData("22", "", "Terezija Umiljanovic", "22", true, ""), RecyclerWrapper.TYPE_PERSON_BDAY))
        list.add(RecyclerWrapper(BdayCardHolderData("22", "", "Marko Marulic", "45", true, "Kava sa slagom"), RecyclerWrapper.TYPE_PERSON_BDAY))
        list.add(RecyclerWrapper(DividerByDateData("21.3.1223."), RecyclerWrapper.TYPE_DIVIDER_BY_DATE))
        list.add(RecyclerWrapper(BdayCardHolderData("22", "", "Jan Drasković", "99", true, ""), RecyclerWrapper.TYPE_PERSON_BDAY))
        list.add(RecyclerWrapper(BdayCardHolderData("22", "", "Matilda Matic", "33", true, ""), RecyclerWrapper.TYPE_PERSON_BDAY))
        list.add(RecyclerWrapper(DividerByDateData("21.6.1993."), RecyclerWrapper.TYPE_DIVIDER_BY_DATE))
        list.add(RecyclerWrapper(BdayCardHolderData("22", "", "Terezija Umiljanovic", "22", true, ""), RecyclerWrapper.TYPE_PERSON_BDAY))
        list.add(RecyclerWrapper(BdayCardHolderData("22", "", "Marko Marulic", "45", true, "Kava sa slagom"), RecyclerWrapper.TYPE_PERSON_BDAY))
        list.add(RecyclerWrapper(DividerByDateData("21.3.1223."), RecyclerWrapper.TYPE_DIVIDER_BY_DATE))
        list.add(RecyclerWrapper(BdayCardHolderData("22", "", "Jan Drasković", "99", true, ""), RecyclerWrapper.TYPE_PERSON_BDAY))
        list.add(RecyclerWrapper(BdayCardHolderData("22", "", "Matilda Matic", "33", true, ""), RecyclerWrapper.TYPE_PERSON_BDAY))

        upcomingView.showUpcomingBdays(list)

    }

    override fun addPresentIdea(presentIdea: String) {
    }

    override fun removePresentIdea(presenIdea: String) {
    }

    override fun onNotificationStateChange() {
    }
}