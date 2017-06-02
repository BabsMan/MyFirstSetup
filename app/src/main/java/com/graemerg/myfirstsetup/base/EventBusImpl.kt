package com.graemerg.myfirstsetup.base

import com.graemerg.myfirstsetup.EventBus


class EventBusImpl(val bus: org.greenrobot.eventbus.EventBus): EventBus {

    // We use a wrapped EventBus for a couple of reasons.
    // More granular control over it's functionality is a big one.

    override fun register(subscriber: Any) {
        if (!bus.isRegistered(subscriber)) {
            bus.register(subscriber)
        }
    }

    override fun unregister(subscriber: Any) {
        bus.unregister(subscriber)
    }

    override fun post(event: Any) {
        bus.post(event)
    }
}
