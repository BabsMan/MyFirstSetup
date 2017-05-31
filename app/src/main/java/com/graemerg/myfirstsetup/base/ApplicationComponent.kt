package com.graemerg.myfirstsetup.base

import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

}

@Module
class ApplicationModule(myApplication: MyLovelyApplication) {

}
