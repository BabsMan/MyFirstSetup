package com.graemerg.myfirstsetup.home

class HomeActivityPresenter {

    private lateinit var view: HomeActivityView

    fun onActivityCreated(view: HomeActivityView) {
        this.view = view
    }

    fun onButtonPressed() {
        view.setPageTextToPressed()
    }
}

interface HomeActivityView {
    fun setPageTextToPressed()
}
