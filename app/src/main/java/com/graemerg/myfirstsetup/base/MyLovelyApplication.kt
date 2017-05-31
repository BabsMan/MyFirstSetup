package com.graemerg.myfirstsetup.base

import android.app.Application

class MyLovelyApplication: Application() {

    val appComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

    //val dataLayerComponent = appComponent.plus(DataLayerModule)
}
