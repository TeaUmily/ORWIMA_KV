package hr.ferit.tumiljanovic.bdayreminder.di.module

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.bdayreminder.App
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Singleton
    @Provides
    fun provideApp() = app

}