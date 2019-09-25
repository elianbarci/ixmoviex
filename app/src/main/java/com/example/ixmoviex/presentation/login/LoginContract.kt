package com.example.ixmoviex.presentation.login

interface LoginContract {

    interface LoginView{
        fun showError(msgError:String)
        fun showProgressBar()
        fun hideProgressBar()
        fun signIn()
        fun navigateToMain()
        fun navigateToRegister()
    }

    interface LoginPresenter{
        fun attachView(view: LoginView)    //Funciona para añadir la vista de donde lo estamos ejecutando
        fun dettachView()                  //Para quitar la vista del presenter a la hora de por ejemplo destruir la Actividad que lo ejecutó
        fun isViewAttached():Boolean       //Nos devuelve verdadero en caso de que la vista este atachada al presenter o falso en caso contrario
        fun signInUserWithEmailAndPassword(email:String, password:String)
        fun checkEmptyFields(email:String,password:String):Boolean
    }



}