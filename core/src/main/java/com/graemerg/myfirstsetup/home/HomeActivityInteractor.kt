package com.graemerg.myfirstsetup.home

import com.graemerg.myfirstsetup.BaseInteractor
import com.graemerg.myfirstsetup.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HomeActivityInteractor(bus: EventBus) : BaseInteractor(bus) {

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onEvent(event: MyFirstEvent) {
        bus.post(MyResponseEvent)
    }
}

object MyResponseEvent
