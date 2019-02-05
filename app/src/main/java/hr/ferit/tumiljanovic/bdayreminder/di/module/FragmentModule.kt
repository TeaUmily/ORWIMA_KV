package hr.ferit.tumiljanovic.bdayreminder.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hr.ferit.tumiljanovic.bdayreminder.fragment.account_settings.AccountFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.account_settings.AccountFragmentModule
import hr.ferit.tumiljanovic.bdayreminder.fragment.calendar.CalendarFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.calendar.CalendarFragmentModule
import hr.ferit.tumiljanovic.bdayreminder.fragment.home.HomeFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.home.HomeFragmentModule
import hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups.MyGroupsFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups.MyGroupsFragmentModule
import hr.ferit.tumiljanovic.bdayreminder.fragment.upcoming.UpcomingFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.upcoming.UpcomingFragmentModule
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerFragment

@Module
abstract class FragmentModule {
    @PerFragment
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun provideHomeFragment(): HomeFragment


    @PerFragment
    @ContributesAndroidInjector(modules = [UpcomingFragmentModule::class])
    abstract fun provideUpcomingFragment(): UpcomingFragment


    @PerFragment
    @ContributesAndroidInjector(modules = [CalendarFragmentModule::class])
    abstract fun provideCalendarFragment(): CalendarFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [AccountFragmentModule::class])
    abstract fun provideAccountFragment(): AccountFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [MyGroupsFragmentModule::class])
    abstract fun provideMyGroupsFragment(): MyGroupsFragment
}
