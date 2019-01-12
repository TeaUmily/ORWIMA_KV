package hr.ferit.tumiljanovic.bdayreminder.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hr.ferit.tumiljanovic.bdayreminder.fragment.home.HomeFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.home.di.HomeFragmentModule
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerFragment

@Module
abstract class FragmentModule {
    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(HomeFragmentModule::class))
    abstract fun provideHomeFragment(): HomeFragment


}
