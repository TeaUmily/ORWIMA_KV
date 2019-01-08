package hr.ferit.tumiljanovic.bdayreminder

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import hr.ferit.tumiljanovic.bdayreminder.di.AppComponent
import hr.ferit.tumiljanovic.bdayreminder.di.DaggerAppComponent
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: AppComponent

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
        appComponent.inject(this)

        instance = this

    }


    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}