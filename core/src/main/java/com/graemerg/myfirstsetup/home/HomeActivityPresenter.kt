package com.graemerg.myfirstsetup.home

import com.graemerg.myfirstsetup.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class HomeActivityPresenter(bus: EventBus): SubscribedPresenter(bus) {

    private lateinit var view: HomeActivityView

    fun onActivityCreated(view: HomeActivityView) {
        this.view = view
    }

    fun onButtonPressed() {
        bus.post(MyFirstEvent)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: MyResponseEvent) {
        view.setPageTextToPressed()
    }
}

interface HomeActivityView {
    fun setPageTextToPressed()
}

object MyFirstEvent