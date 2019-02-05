package hr.ferit.tumiljanovic.bdayreminder.fragment.home

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity


@Module
class HomeFragmentModule {

    @PerActivity
    @Provides
    fun provideHomeFragment(homeFragment: HomeFragment) : HomeFragment = homeFragment

    @PerActivity
    @Provides
    fun provideHomeFragmentView(homeFragment: HomeFragment) : HomeFragmentView = homeFragment

}