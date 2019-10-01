package com.example.ixmoviex.domain.interactor.registrationinteractor

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.ixmoviex.presentation.registration.view.RegistrationActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class RegistrationInteractorImpl : RegistrationInteractor{

    override fun signUp(fullname: String, email: String, password: String, listener: RegistrationInteractor.RegisterCallback){

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener { itSignUp ->
                if(itSignUp.isSuccessful){

                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(fullname)
                        .build()

                    FirebaseAuth.getInstance().currentUser?.updateProfile(profileUpdates)?.addOnCompleteListener {
                        if(it.isSuccessful){
                            listener.onRegisterSuccess()
                        }
                    }

                }else{
                    listener.onRegisterFailure(itSignUp.exception?.message.toString())
                }
            }

    }
}