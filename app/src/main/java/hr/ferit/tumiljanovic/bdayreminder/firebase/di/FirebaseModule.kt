package hr.ferit.tumiljanovic.bdayreminder.firebase.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.raywenderlich.android.whysoserious.firebase.authentication.FirebaseAuthenticationManager
import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.bdayreminder.firebase.authentication.FirebaseAuthenticationInterface
import hr.ferit.tumiljanovic.bdayreminder.firebase.database.FirebaseDatabaseInterface
import hr.ferit.tumiljanovic.bdayreminder.firebase.database.FirebaseDatabaseManager


@Module
class FirebaseModule {

    @Provides
     fun authentication(authentication: FirebaseAuthenticationManager): FirebaseAuthenticationInterface = authentication

    @Provides
    fun database(database: FirebaseDatabaseManager): FirebaseDatabaseInterface = database

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideFirebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()

}