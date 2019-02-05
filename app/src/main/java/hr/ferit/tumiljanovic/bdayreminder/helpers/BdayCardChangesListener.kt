package hr.ferit.tumiljanovic.bdayreminder.helpers

interface BdayCardChangesListener {

    fun onNotificationCheckChanged(id: String)
    fun onAddPresentIdea(id: String)
    fun onRemovePresentIdea(id: String, presentIdea: String)
}