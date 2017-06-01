package com.graemerg.myfirstsetup.base

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun plus(dataLayerModule: DataLayerModule): DataLayerComponent
}

@Module
class ApplicationModule(val myApplication: MyLovelyApplication) {

    @Provides
    internal fun providesApplication(): Application {
        return myApplication
    }
}
