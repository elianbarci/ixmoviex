package com.example.ixmoviex.domain.interactor.logininteractor

interface SignInInteractor {

    interface SigninCallback{
        fun onSignInSuccess()
        fun onSignInFailure(errorMsg:String)
    }

    fun signInWithEmailAndPassword(email: String, password:String, listener:SigninCallback)

}