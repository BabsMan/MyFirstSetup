package com.graemerg.myfirstsetup.base.dagger

@DataLayerScope
@dagger.Subcomponent(modules = arrayOf(com.graemerg.myfirstsetup.base.dagger.DataLayerModule::class, com.graemerg.myfirstsetup.base.dagger.DataManagerModule::class))
interface DataLayerComponent {

    fun inject(objects: com.graemerg.myfirstsetup.base.dagger.DataLayerObjects)
}

@DataLayerScope
@dagger.Module
class DataManagerModule {
    // This is where we house all them data managers.
}

class DataLayerObjects {
    // Class that has all the inject methods for the data managers.
}

@DataLayerScope
@dagger.Module
class DataLayerModule {

    // Things that would go in the Data Layer module include the DataLayerObjects (See above)

    @DataLayerScope
    @dagger.Provides
    fun providesDataLayerObjects(): com.graemerg.myfirstsetup.base.dagger.DataLayerObjects {
        return com.graemerg.myfirstsetup.base.dagger.DataLayerObjects()
    }
}
