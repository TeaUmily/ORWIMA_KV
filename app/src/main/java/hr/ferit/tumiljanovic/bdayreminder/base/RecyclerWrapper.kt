package hr.ferit.tumiljanovic.bdayreminder.base

import hr.ferit.tumiljanovic.bdayreminder.R

class RecyclerWrapper(var data: Any, var type: Int) {

companion object {
    const val TYPE_PERSON_BDAY = R.layout.cell_person_bday
    const val TYPE_DIVIDER_BY_DATE = R.layout.cell_divider_by_date
    const val TYPE_GROUP_CARD = R.layout.cell_group
}
}