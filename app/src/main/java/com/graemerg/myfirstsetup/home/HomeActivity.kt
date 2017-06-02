package com.graemerg.myfirstsetup.home

import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v7.app.AppCompatActivity
import com.graemerg.myfirstsetup.Interactor
import com.graemerg.myfirstsetup.InteractorLoader
import com.graemerg.myfirstsetup.InteractorSupplier
import com.graemerg.myfirstsetup.R
import com.graemerg.myfirstsetup.base.MyLovelyApplication
import com.graemerg.myfirstsetup.base.dagger.ScreenComponent
import com.graemerg.myfirstsetup.base.dagger.ScreenModule
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeActivityView, LoaderManager.LoaderCallbacks<List<Interactor>> {

    @Inject
    protected lateinit var presenter: HomeActivityPresenter

    @Inject
    protected lateinit var interactor: Lazy<HomeActivityInteractor>

    val interactors: Array<InteractorSupplier> get() = arrayOf(interactor::get)

    override fun onCreate(savedInstanceState: Bundle?) {
        inject { it.inject(this) }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportLoaderManager.initLoader(1, Bundle(), this)

        pageButton.setOnClickListener { presenter.onButtonPressed() }

        presenter.onActivityCreated(this)
        presenter.onCreate()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun setPageTextToPressed() {
        pageBody.text = getString(R.string.pageBodyClicked)
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
