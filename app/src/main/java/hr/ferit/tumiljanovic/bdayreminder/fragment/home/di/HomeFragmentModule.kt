package hr.ferit.tumiljanovic.bdayreminder.fragment.home.di

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.bdayreminder.fragment.home.HomeFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.home.HomeView
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity


@Module
class HomeFragmentModule {

    @PerActivity
    @Provides
    fun provideHomeFragment(homeFragment: HomeFragment) : HomeFragment = homeFragment

    @PerActivity
    @Provides
    fun provideHomeFragmentView(homeFragment: HomeFragment) : HomeView = homeFragment

}