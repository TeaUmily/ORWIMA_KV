package hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerAdapter
import hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups.MyGroupsFragment
import hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups.MyGroupsPresenter
import hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups.MyGroupsPresenterImpl
import hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups.MyGroupsView
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerFragment

@Module
class MyGroupsFragmentModule {

    @PerFragment
    @Provides
    fun provideRecyclerAdapter() = RecyclerAdapter()

    @PerFragment
    @Provides
    fun provideMyGroupsView(myGroupsFragment: MyGroupsFragment) : MyGroupsView = myGroupsFragment


    @PerFragment
    @Provides
    fun provideMyGroupsPresenter(myGroupsPresenterImpl: MyGroupsPresenterImpl): MyGroupsPresenter = myGroupsPresenterImpl
}