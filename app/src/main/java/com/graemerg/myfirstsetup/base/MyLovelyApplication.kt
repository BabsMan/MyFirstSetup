package com.graemerg.myfirstsetup.base

import android.app.Application

class MyLovelyApplication: Application() {

    private lateinit var appComponent: ApplicationComponent

    private lateinit var dataLayerComponent: DataLayerComponent

    override fun onCreate() {
        super.onCreate()

        // Dagger setup
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

        dataLayerComponent = appComponent.plus(DataLayerModule())
        dataLayerComponent.inject(DataLayerObjects())
    }

}
