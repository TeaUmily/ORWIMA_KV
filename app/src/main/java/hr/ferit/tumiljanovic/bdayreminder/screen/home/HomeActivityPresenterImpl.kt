package hr.ferit.tumiljanovic.bdayreminder.screen.home

import android.util.Log
import hr.ferit.tumiljanovic.bdayreminder.firebase.authentication.FirebaseAuthenticationInterface
import hr.ferit.tumiljanovic.bdayreminder.firebase.database.FirebaseDatabaseInterface
import javax.inject.Inject

class HomeActivityPresenterImpl @Inject constructor(private var homeActivityView: HomeActivityView, private val authentication: FirebaseAuthenticationInterface, private val database: FirebaseDatabaseInterface) : HomeActivityPresenter {

    override fun getUserInfo() {
        database.getProfile(authentication.getUserId()){
            homeActivityView.setNameAndPicture(it)
        }
    }


    override fun logOut() {
        authentication.logOut {
            homeActivityView.onLogOut()
        }
    }

}