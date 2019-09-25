package com.example.ixmoviex.presentation.login.presenter
//Claramente este es el presenter, la logica que cumple el presener es muy simple no màs que
//chequear campos vacios, u homologar que los datos ingresados se hayan cargado correctamente.
import com.example.ixmoviex.presentation.login.LoginContract

class LoginPresenter() : LoginContract.LoginPresenter {

    var view: LoginContract.LoginView? = null

    override fun attachView(view: LoginContract.LoginView) {
        this.view = view
    }

    override fun dettachView() {
        view = null
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun signInUserWithEmailAndPassword(email: String, password: String) {
        view?.showProgressBar()
        view?.showError("Hasta acá todo bien, llego al presenter")

    }

    override fun checkEmptyFields(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }

}