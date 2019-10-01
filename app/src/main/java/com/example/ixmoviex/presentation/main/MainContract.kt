package com.example.ixmoviex.presentation.main

import com.example.ixmoviex.presentation.login.LoginContract

interface MainContract {

    interface MainView {
        fun bringDataApi()
        fun logout()

    }

    interface MainPresenter {
        fun attachView(view: MainContract.MainView)
        fun dettachView()
        fun isViewAttached():Boolean
        fun bringDataApi():String
    }

}