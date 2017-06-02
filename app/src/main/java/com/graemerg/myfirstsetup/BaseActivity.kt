package com.graemerg.myfirstsetup

import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v7.app.AppCompatActivity
import com.graemerg.myfirstsetup.base.MyLovelyApplication
import com.graemerg.myfirstsetup.base.dagger.ScreenComponent
import com.graemerg.myfirstsetup.base.dagger.ScreenModule

abstract class BaseActivity: AppCompatActivity(), LoaderManager.LoaderCallbacks<List<Interactor>> {

    //open val lifehooks: Array<Lifehook> = emptyArray()
    abstract val lifehooks: Array<Lifehook>
    open val interactors: Array<InteractorSupplier> = emptyArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        lifehooks.forEach { it.onStart() }
    }

    override fun onStop() {
        super.onStop()
        lifehooks.forEach { it.onStop() }
    }

    fun inject(injection: (ScreenComponent) -> Unit) {
        (application as MyLovelyApplication).appComponent.plus(ScreenModule())
                .apply { injection.invoke(this) }
    }

    //region LoaderManager overrides
    override fun onCreateLoader(id: Int, args: Bundle?): Loader<List<Interactor>> {
        return InteractorLoader(this, interactors.map { it() })
    }

    override fun onLoaderReset(loader: Loader<List<Interactor>>?) {}

    override fun onLoadFinished(loader: Loader<List<Interactor>>?, data: List<Interactor>?) {}
    //endregion
}