package com.graemerg.myfirstsetup.home

import com.graemerg.myfirstsetup.EventBus
import com.graemerg.myfirstsetup.Lifehook

abstract class SubscribedPresenter(val bus: EventBus): Lifehook {

    override fun onCreate() = bus.register(this)

    override fun onStart()  = bus.register(this)

    override fun onStop() = bus.unregister(this)
}