package hr.ferit.tumiljanovic.bdayreminder.fragment.account_settings

import hr.ferit.tumiljanovic.bdayreminder.model.User

interface AccountView {

    fun showUserInfo(user: User)

    fun onDeleteAccountMessage()

    fun onDeleteErrorMessage()

}