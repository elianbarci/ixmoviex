package com.example.ixmoviex.presentation.login.presenter
//Claramente este es el presenter, la logica que cumple el presener es muy simple no màs que
//chequear campos vacios, u homologar que los datos ingresados se hayan cargado correctamente.
import android.content.Context
import com.example.ixmoviex.domain.interactor.logininteractor.SignInInteractor
import com.example.ixmoviex.presentation.login.LoginContract
import kotlin.math.sign
import android.view.Gravity
import android.widget.Toast

class LoginPresenter(signInInteractor: SignInInteractor) : LoginContract.LoginPresenter {   //Inyectamos la interfaz que vamos a utilizar

    var view: LoginContract.LoginView? = null
    var signInInteractor: SignInInteractor? = null      //Se inicializa el interactor

    init {
        this.signInInteractor = signInInteractor        //Ese signInterac
    }

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

        signInInteractor?.signInWithEmailAndPassword(email,password, object: SignInInteractor.SigninCallback{        //Puedo pasar interfacez en las funciones siempre y cuando se implemente
            override fun onSignInSuccess() {
                view?.hideProgressBar()
                if(isViewAttached()){
                    view?.navigateToMain()
                }
            }

            override fun onSignInFailure(errorMsg: String) {
                if(isViewAttached()){
                    view?.showError("Error en Login: " + errorMsg)
                    view?.hideProgressBar()
                }
            }

        })

    }

    override fun checkEmptyFields(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }

}