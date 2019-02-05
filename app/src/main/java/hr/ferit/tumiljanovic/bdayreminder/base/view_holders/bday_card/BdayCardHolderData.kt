package hr.ferit.tumiljanovic.bdayreminder.base.view_holders.bday_card

class BdayCardHolderData(var id: String,
                         var image: String,
                         var fullName: String,
                         var years: String,
                         var notification: Boolean,
                         var presentIdea: String,
                         var expanded: Boolean = false) {

    fun isExpanded() = expanded

}