package com.graemerg.myfirstsetup

import android.content.Context
import android.support.v4.content.Loader

class InteractorLoader(context: Context, private var interactors: List<Interactor>) : Loader<List<Interactor>>(context) {

    override fun onStartLoading() {
        deliverResult(interactors)
    }

    override fun onReset() {
        interactors.forEach { it.onReset() }
    }
}