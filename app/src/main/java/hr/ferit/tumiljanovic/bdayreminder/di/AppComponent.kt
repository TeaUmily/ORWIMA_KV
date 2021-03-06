package hr.ferit.tumiljanovic.bdayreminder.di

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import hr.ferit.tumiljanovic.bdayreminder.App
import hr.ferit.tumiljanovic.bdayreminder.di.module.ActivityModule
import hr.ferit.tumiljanovic.bdayreminder.di.module.AppModule
import hr.ferit.tumiljanovic.bdayreminder.login.di.LoginActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class),
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (ActivityModule::class)])

interface AppComponent : AndroidInjector<Application> {
    fun inject(app: App)
}