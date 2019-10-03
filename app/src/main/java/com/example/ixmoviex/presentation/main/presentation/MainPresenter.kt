package com.example.ixmoviex.presentation.main.presentation

import android.widget.TextView
import android.widget.Toast
import com.example.ixmoviex.domain.interactor.logininteractor.SignInInteractor
import com.example.ixmoviex.domain.interactor.maininteractor.MainInteractor
import com.example.ixmoviex.presentation.login.LoginContract
import com.example.ixmoviex.presentation.main.MainContract

class MainPresenter(MainInteractor: MainInteractor): MainContract.MainPresenter {

    var view: MainContract.MainView? = null
    var MainInteractor: MainInteractor? = null      //Se inicializa el interactor

    init {
        this.MainInteractor = MainInteractor        //Ese signInterac
    }

    override fun attachView(view: MainContract.MainView) {
        this.view = view
    }

    override fun dettachView() {
        view = null
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun bringDataApi(textViewResult: TextView, user: String) {
        println("Entro al presenter")
        MainInteractor?.bringDataApi(textViewResult, user, object: MainInteractor.MainCallback{
            override fun onMainSuccess() {
                view?.hideProgress()
            }

            override fun onMainFailure(errorMsg: String) {
                view?.showError("Error en Login: " + errorMsg)
            }
        })
    }
}