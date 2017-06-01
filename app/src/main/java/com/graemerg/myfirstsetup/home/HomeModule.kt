package com.graemerg.myfirstsetup.home

import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun providesHomeActivityPresenter(): HomeActivityPresenter {
        return HomeActivityPresenter()
    }
}
