package hr.ferit.tumiljanovic.bdayreminder.login.di

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.bdayreminder.login.LoginActivity
import hr.ferit.tumiljanovic.bdayreminder.login.LoginPresenter
import hr.ferit.tumiljanovic.bdayreminder.login.LoginPresenterImpl
import hr.ferit.tumiljanovic.bdayreminder.login.LoginView
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity


@Module
class LoginActivityModule {

    @PerActivity
    @Provides
    fun provideLoginPresenter(presenter: LoginPresenterImpl): LoginPresenter = presenter

    @PerActivity
    @Provides
    fun provideLoginView(loginActivity: LoginActivity): LoginView = loginActivity

}