package hr.ferit.tumiljanovic.bdayreminder.fragment.account_settings

import android.net.Uri
import hr.ferit.tumiljanovic.bdayreminder.firebase.authentication.FirebaseAuthenticationInterface
import hr.ferit.tumiljanovic.bdayreminder.firebase.database.FirebaseDatabaseInterface
import javax.inject.Inject

class AccountPresenterImpl @Inject constructor(private var accountView: AccountView, private val database: FirebaseDatabaseInterface, private val authentication: FirebaseAuthenticationInterface) : AccountPresenter {

    override fun getUserInfo() {
        database.getProfile(authentication.getUserId()) {
            accountView.showUserInfo(it)
        }
    }

    override fun uploadImage(filePath: Uri) {
        database.addProfileImage(filePath, authentication.getUserId())
    }

    override fun deleteAccount() {
        database.removeUser(authentication.getUserId()) { isDeleted ->
            if (isDeleted) {
                authentication.deleteAccount { isSuccessful ->
                    if (isSuccessful) {
                        accountView.onDeleteAccountMessage()
                    }
                }
            } else {
                accountView.onDeleteErrorMessage()
            }

        }
    }
}

