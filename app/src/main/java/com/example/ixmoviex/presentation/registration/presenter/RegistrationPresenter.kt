package com.example.ixmoviex.presentation.registration.presenter

import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.example.ixmoviex.domain.interactor.registrationinteractor.RegistrationInteractor
import com.example.ixmoviex.presentation.registration.RegistrationContract

class RegistrationPresenter(registrationInteractor:RegistrationInteractor): RegistrationContract.RegistrationPresenter {

    var view:RegistrationContract.RegistrationView? = null
    var registrationInteractor:RegistrationInteractor? = null

    init{
        this.registrationInteractor = registrationInteractor
    }

    override fun attachView(view: RegistrationContract.RegistrationView) {
        this.view = view
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun detachView() {
        view = null
    }

    override fun checkEmptyName(fullname: String): Boolean {
        return fullname.isEmpty()
    }

    override fun checkValidEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()       //Chequea si el mail posee su expresion regular
    }

    override fun checkEmptyPassword(pw1: String, pw2: String): Boolean {
        return pw1.isEmpty() or pw2.isEmpty()
    }

    override fun checkPasswordMatch(pw1: String, pw2: String): Boolean {
        return pw1 == pw2          //Para comparar dos strings siemrpe utilizar equals recordar
}                                   //Equals en Kotlin es ==

    override fun signUp(fullname: String, email: String, password: String) {

        view?.showProgress()
        registrationInteractor?.signUp(fullname,email,password,object: RegistrationInteractor.RegisterCallback{
            override fun onRegisterSuccess() {
                view?.navigateToMain()
                view?.hideProgress()
            }

            override fun onRegisterFailure(errorMsg: String) {
                view?.showError(errorMsg)
                view?.hideProgress()
            }
        })

    }
}