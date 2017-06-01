package com.graemerg.myfirstsetup.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.graemerg.myfirstsetup.R
import com.graemerg.myfirstsetup.base.MyLovelyApplication
import com.graemerg.myfirstsetup.base.dagger.ScreenComponent
import com.graemerg.myfirstsetup.base.dagger.ScreenModule
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity: AppCompatActivity(), HomeActivityView {

    @Inject
    protected lateinit var presenter: HomeActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        inject { it.inject(this) }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        pageButton.setOnClickListener { presenter.onButtonPressed() }

        presenter.onActivityCreated(this)
    }


    override fun setPageTextToPressed() {
        pageBody.text = getString(R.string.pageBodyClicked)
    }

    fun inject(injection: (ScreenComponent) -> Unit) {
        (application as MyLovelyApplication).appComponent.plus(ScreenModule())
                .apply { injection.invoke(this) }
    }
}
