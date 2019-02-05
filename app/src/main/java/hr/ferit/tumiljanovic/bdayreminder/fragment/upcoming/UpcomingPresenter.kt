package hr.ferit.tumiljanovic.bdayreminder.fragment.upcoming

interface UpcomingPresenter {

    fun getUpcomingBdays()
    fun addPresentIdea(presentIdea: String)
    fun removePresentIdea(presenIdea: String)
    fun onNotificationStateChange()

}