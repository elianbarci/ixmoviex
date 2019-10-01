package com.example.ixmoviex.presentation.registration.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.ixmoviex.R
import com.example.ixmoviex.base.BaseActivity
import com.example.ixmoviex.domain.interactor.registrationinteractor.RegistrationInteractorImpl
import com.example.ixmoviex.presentation.main.view.MainActivity
import com.example.ixmoviex.presentation.registration.RegistrationContract
import com.example.ixmoviex.presentation.registration.presenter.RegistrationPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity:BaseActivity(), RegistrationContract.RegistrationView {

    private lateinit var presenter:RegistrationPresenter       //Si sabes que no va a ser NULL inicializalo tarde, sino inizializalo arriba de todo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = RegistrationPresenter(RegistrationInteractorImpl())
        presenter.attachView(this)

        button_register.setOnClickListener{
            signUp()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_registration
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK     //Esto hace que se destruya la pestaña de login y se establezca la nueva proxima pestaña como la "Main"
        startActivity(intent)
    }

    override fun signUp() {

        val email = etxt_mail_register.text.toString().trim()
        val fullname = etxt_fullname_register.text.toString().trim()
        val pass1 = etxt_pass_1_register.text.toString().trim()
        val pass2 = etxt_pass_2_register.text.toString().trim()

        if(presenter.checkEmptyName(fullname)){
            etxt_fullname_register.error = "El nombre no fue ingresado"
            return
        }

        if (presenter.checkValidEmail(email)){
            etxt_email.error = "El email es invalido"
            return
        }

        if(presenter.checkEmptyPassword(pass1,pass2)){
            etxt_pass_1_register.error = "Empty Field"
            etxt_pass_2_register.error = "Empty Field"
            return
        }

        if(!presenter.checkPasswordMatch(pass1, pass2)){
            etxt_pass_1_register.error = "Passwords dont match"
            etxt_pass_1_register.error = "Passwords dont match"
            return
        }


        presenter.signUp(fullname,email, pass1)

    }

    override fun showProgress() {
        progressBar_register.visibility = View.VISIBLE
        button_register.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar_register.visibility = View.GONE
        button_register.visibility = View.VISIBLE

    }

    override fun showError(errormsg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
