package hr.ferit.tumiljanovic.bdayreminder.screen.login.di

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.bdayreminder.screen.login.LoginActivity
import hr.ferit.tumiljanovic.bdayreminder.screen.login.LoginPresenter
import hr.ferit.tumiljanovic.bdayreminder.screen.login.LoginPresenterImpl
import hr.ferit.tumiljanovic.bdayreminder.screen.login.LoginView
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