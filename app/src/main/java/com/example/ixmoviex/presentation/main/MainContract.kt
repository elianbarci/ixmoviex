package com.example.ixmoviex.presentation.main

import android.widget.TextView
import com.example.ixmoviex.base.BaseActivity
import com.example.ixmoviex.presentation.login.LoginContract

interface MainContract {

    interface MainView {
        fun bringDataApi(user: String)
        fun showProgress()
        fun hideProgress()
        fun showError(msgError: String)
        fun getLayout(): Int
    }

    interface MainPresenter {
        fun attachView(view: MainView)
        fun dettachView()
        fun isViewAttached():Boolean
        fun bringDataApi(textViewResult: TextView, user:String)
    }

}