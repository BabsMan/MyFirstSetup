package com.graemerg.myfirstsetup.home

import com.graemerg.myfirstsetup.EventBus
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun providesHomeActivityPresenter(bus: EventBus): HomeActivityPresenter {
        return HomeActivityPresenter(bus)
    }

    @Provides
    fun providesHomeActivityInteractor(bus: EventBus): HomeActivityInteractor {
        return HomeActivityInteractor(bus)
    }
}
