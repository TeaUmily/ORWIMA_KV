package hr.ferit.tumiljanovic.bdayreminder.screen.home

import hr.ferit.tumiljanovic.bdayreminder.model.User

interface HomeActivityView {

    fun onLogOut()

    fun setNameAndPicture(it: User)
}