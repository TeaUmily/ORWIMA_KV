package hr.ferit.tumiljanovic.bdayreminder.fragment.account_settings

import android.net.Uri

interface AccountPresenter {

    fun getUserInfo()
    fun uploadImage(filePath: Uri)
    fun deleteAccount()
}