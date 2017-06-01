package com.graemerg.myfirstsetup.base.dagger

import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(
        ScreenModule::class
))
interface ScreenComponent {

    // It is at this point you would inject activities used in the application.
}

@Module
class ScreenModule {

}
