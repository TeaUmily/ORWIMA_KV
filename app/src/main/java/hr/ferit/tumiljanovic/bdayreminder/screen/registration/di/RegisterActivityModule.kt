package hr.ferit.tumiljanovic.bdayreminder.screen.registration.di

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.bdayreminder.screen.registration.RegisterActivity
import hr.ferit.tumiljanovic.bdayreminder.screen.registration.RegisterPresenter
import hr.ferit.tumiljanovic.bdayreminder.screen.registration.RegisterPresenterImpl
import hr.ferit.tumiljanovic.bdayreminder.screen.registration.RegisterView
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity


@Module
class RegisterActivityModule {

    @PerActivity
    @Provides
    fun provideRegisterPresenter(presenter: RegisterPresenterImpl) : RegisterPresenter = presenter


    @PerActivity
    @Provides
    fun provideRegisterView (registerActivity: RegisterActivity): RegisterView = registerActivity

}