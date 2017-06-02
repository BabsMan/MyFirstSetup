package com.graemerg.myfirstsetup.home

import android.os.Bundle
import android.support.v4.app.LoaderManager
import com.graemerg.myfirstsetup.*
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeActivityView, LoaderManager.LoaderCallbacks<List<Interactor>> {

    @Inject
    protected lateinit var presenter: HomeActivityPresenter

    @Inject
    protected lateinit var interactor: Lazy<HomeActivityInteractor>

    override val lifehooks: Array<Lifehook> get() = arrayOf(presenter)
    override val interactors: Array<InteractorSupplier> get() = arrayOf(interactor::get)

    override fun onCreate(savedInstanceState: Bundle?) {
        inject { it.inject(this) }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportLoaderManager.initLoader(1, Bundle(), this)

        pageButton.setOnClickListener { presenter.onButtonPressed() }

        presenter.onActivityCreated(this)
        lifehooks.forEach { it.onCreate() }
    }

    override fun setPageTextToPressed() {
        pageBody.text = getString(R.string.pageBodyClicked)
    }
}
