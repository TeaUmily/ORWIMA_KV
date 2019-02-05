package hr.ferit.tumiljanovic.bdayreminder.screen.home

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity

@Module
class HomeActivityModule {

    @PerActivity
    @Provides
    fun provideHomeActivityView(homeActivity: HomeActivity): HomeActivityView = homeActivity

    @PerActivity
    @Provides
    fun provideHomeActivityPresenter(homeActivityPresenterImpl: HomeActivityPresenterImpl): HomeActivityPresenter = homeActivityPresenterImpl
}