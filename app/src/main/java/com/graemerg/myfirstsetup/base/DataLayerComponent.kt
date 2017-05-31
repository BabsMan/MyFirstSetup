package com.graemerg.myfirstsetup.base

import dagger.Module
import dagger.Subcomponent

@DataLayerScope
@Subcomponent(modules = arrayOf(DataManagerModule::class))
interface DataLayerComponent {

    fun inject(objects: DataLayerObjects)
}

@DataLayerScope
@Module
class DataManagerModule {
    // This is where we house all them data managers.
}

class DataLayerObjects {

}
