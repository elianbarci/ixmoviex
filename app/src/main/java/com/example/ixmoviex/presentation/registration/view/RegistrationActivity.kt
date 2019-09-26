package com.example.ixmoviex.presentation.registration.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ixmoviex.R
import com.example.ixmoviex.base.BaseActivity
import com.example.ixmoviex.presentation.main.view.MainActivity
import com.example.ixmoviex.presentation.registration.RegistrationContract

class RegistrationActivity : BaseActivity(), RegistrationContract.RegistrationView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(errormsg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
