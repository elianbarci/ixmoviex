package com.example.ixmoviex.domain.interactor.maininteractor

import android.widget.TextView
import com.example.ixmoviex.domain.interactor.logininteractor.SignInInteractor

interface MainInteractor {
    interface MainCallback{
        fun onMainSuccess()
        fun onMainFailure(errorMsg:String)
    }

    fun bringDataApi(textViewResult: TextView, user: String, listener: MainCallback)

}