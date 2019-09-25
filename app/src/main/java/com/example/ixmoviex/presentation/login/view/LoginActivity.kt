package com.example.ixmoviex.presentation.login.view
//Esta es la Vista
import android.os.Bundle
import android.view.View
import com.example.ixmoviex.R
import com.example.ixmoviex.base.BaseActivity
import com.example.ixmoviex.presentation.login.LoginContract
import com.example.ixmoviex.presentation.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : BaseActivity(), LoginContract.LoginView {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter()
        presenter.attachView(this)
        btn_signIn.setOnClickListener{
            signIn()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun showError(msgError: String) {
    toast(this, msgError)
    }

    override fun showProgressBar() {
        progressBar_signIn.visibility = View.VISIBLE    //Apunte a un ID del Layout, a un atributo del layout y lo iguale VISIBLE que es un atributo de la clase VIEW
        }

    override fun hideProgressBar() {
        progressBar_signIn.visibility = View.GONE
    }

    override fun signIn() {
        val email = etxt_email.text.toString().trim()
        val password = etxt_password.text.toString().trim()

        if(presenter.checkEmptyFields(email,password)){
            toast(this, "Completa correctamente el formulario, por favor")
        } else {
            presenter.signInUserWithEmailAndPassword(email,password)
        }

    }

    override fun navigateToMain() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToRegister() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
