package com.graemerg.myfirstsetup.base.dagger

import com.graemerg.myfirstsetup.home.HomeActivity
import com.graemerg.myfirstsetup.home.HomeModule
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(
        ScreenModule::class,
        HomeModule::class
))
interface ScreenComponent {

    // It is at this point you would inject activities used in the application, like this(!):
    fun inject(homeActivity: HomeActivity)
}

@Module
class ScreenModule {

}
