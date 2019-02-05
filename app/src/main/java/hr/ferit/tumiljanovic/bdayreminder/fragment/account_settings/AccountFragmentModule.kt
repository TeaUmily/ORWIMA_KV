package hr.ferit.tumiljanovic.bdayreminder.fragment.account_settings

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerFragment


@Module
class AccountFragmentModule {

    @PerFragment
    @Provides
    fun provideAccountView(accountFragment: AccountFragment): AccountView = accountFragment

    @PerFragment
    @Provides
    fun provideAccountPresenter(accountPresenterImpl: AccountPresenterImpl): AccountPresenter = accountPresenterImpl
}