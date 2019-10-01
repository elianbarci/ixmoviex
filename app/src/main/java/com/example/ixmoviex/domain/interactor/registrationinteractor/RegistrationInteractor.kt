package com.example.ixmoviex.domain.interactor.registrationinteractor

import com.example.ixmoviex.domain.interactor.logininteractor.SignInInteractor

interface RegistrationInteractor {

    interface RegisterCallback{
        fun onRegisterSuccess()
        fun onRegisterFailure(errorMsg:String)
    }

    fun signUp(fullname:String, email:String, password:String, listener:RegisterCallback)

}