package com.graemerg.myfirstsetup

abstract class BaseInteractor(val bus: EventBus): Interactor {

    init {
        onLoaded()
    }

    final override fun onLoaded() {
        bus.register(this)
    }

    final override fun onReset() {
        bus.unregister(this)
    }
}