package com.example.ixmoviex.presentation.login.view
//Esta es la Vista
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.ixmoviex.R
import com.example.ixmoviex.base.BaseActivity
import com.example.ixmoviex.domain.interactor.logininteractor.SignInInteractorImpl
import com.example.ixmoviex.presentation.login.LoginContract
import com.example.ixmoviex.presentation.login.presenter.LoginPresenter
import com.example.ixmoviex.presentation.main.view.MainActivity
import com.example.ixmoviex.presentation.registration.view.RegistrationActivity
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : BaseActivity(), LoginContract.LoginView {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(SignInInteractorImpl())  //¿Porque debo pasarle la implementacion? Se resuelve con Dagger
        presenter.attachView(this)
        btn_signIn.setOnClickListener{
            signIn()
        }
        registrarse_login.setOnClickListener{
            navigateToRegistration()
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
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK     //Esto hace que se destruya la pestaña de login y se establezca la nueva proxima pestaña como la "Main"
        startActivity(Intent(this, MainActivity::class.java))                  //Una actividad normalmente va a iniciar con in
        startActivity(intent)
    }

    override fun onDestroy() {                  //¿Porque son necesarios estos metodos?
        super.onDestroy()
        presenter.dettachView()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.dettachView()
    }

    override fun navigateToRegistration(){
        val intent = Intent(this, RegistrationActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK     //Esto hace que se destruya la pestaña de login y se establezca la nueva proxima pestaña como la "Main"
        startActivity(Intent(this, RegistrationActivity::class.java))                  //Una actividad normalmente va a iniciar con in
        startActivity(intent)
    }

}
