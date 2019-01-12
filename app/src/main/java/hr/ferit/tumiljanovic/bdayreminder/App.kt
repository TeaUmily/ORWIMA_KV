package hr.ferit.tumiljanovic.bdayreminder

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import hr.ferit.tumiljanovic.bdayreminder.di.AppComponent
import hr.ferit.tumiljanovic.bdayreminder.di.DaggerAppComponent
import javax.inject.Inject

class App : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>


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

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return dispatchingFragmentInjector
    }
}