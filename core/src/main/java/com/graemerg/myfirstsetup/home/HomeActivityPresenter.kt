package com.graemerg.myfirstsetup.home

import com.graemerg.myfirstsetup.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class HomeActivityPresenter(val bus: EventBus) {

    private lateinit var view: HomeActivityView

    fun onActivityCreated(view: HomeActivityView) {
        this.view = view
    }

    fun onButtonPressed() {
        bus.post(MyFirstEvent)
    }

    fun onCreate() = bus.register(this)
    fun onStart() = bus.register(this)
    fun onStop() = bus.unregister(this)
    fun onDestroy() = Unit

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: MyResponseEvent) {
        view.setPageTextToPressed()
    }
}

interface HomeActivityView {
    fun setPageTextToPressed()
}

object MyFirstEvent