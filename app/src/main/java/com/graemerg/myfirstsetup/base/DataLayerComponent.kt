package com.graemerg.myfirstsetup.base

import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@DataLayerScope
@Subcomponent(modules = arrayOf(DataLayerModule::class, DataManagerModule::class))
interface DataLayerComponent {

    fun inject(objects: DataLayerObjects)
}

@DataLayerScope
@Module
class DataManagerModule {
    // This is where we house all them data managers.
}

class DataLayerObjects {
    // Class that has all the inject methods for the data managers.
}

@DataLayerScope
@Module
class DataLayerModule {

    // Things that would go in the Data Layer module include the DataLayerObjects (See above)

    @DataLayerScope
    @Provides
    fun providesDataLayerObjects(): DataLayerObjects {
        return DataLayerObjects()
    }
}
