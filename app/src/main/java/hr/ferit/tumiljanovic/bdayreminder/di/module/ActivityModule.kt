package hr.ferit.tumiljanovic.bdayreminder.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hr.ferit.tumiljanovic.bdayreminder.login.LoginActivity
import hr.ferit.tumiljanovic.bdayreminder.login.di.LoginActivityModule
import hr.ferit.tumiljanovic.bdayreminder.registration.RegisterActivity
import hr.ferit.tumiljanovic.bdayreminder.registration.di.RegisterActivityModule
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity

@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun provideLoginActivity(): LoginActivity


    @PerActivity
    @ContributesAndroidInjector(modules = [RegisterActivityModule::class])
    abstract fun provideRegisterActivity() : RegisterActivity

}