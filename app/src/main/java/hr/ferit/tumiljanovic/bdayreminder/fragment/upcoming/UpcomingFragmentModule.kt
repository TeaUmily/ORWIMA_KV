package hr.ferit.tumiljanovic.bdayreminder.fragment.upcoming

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerAdapter
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerFragment

@Module
class UpcomingFragmentModule {

    @PerFragment
    @Provides
    fun provideRecyclerAdapter() = RecyclerAdapter()

    @PerFragment
    @Provides
    fun provideUpcomingPresenter(upcomingPresenterImpl: UpcomingPresenterImpl): UpcomingPresenter = upcomingPresenterImpl

    @PerFragment
    @Provides
    fun provideUpcomingFragmentView(upcomingFragment: UpcomingFragment): UpcomingView = upcomingFragment
}