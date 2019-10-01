package com.example.ixmoviex.presentation.registration

interface RegistrationContract {

    interface RegistrationView {
        fun navigateToMain()
        fun signUp()
        fun showProgress()
        fun hideProgress()
        fun showError(errormsg:String)

    }

    interface RegistrationPresenter{

        fun attachView(view:RegistrationView)       //Inserta o attachea la vista
        fun isViewAttached():Boolean                //Pregunta si esta attacheada o no
        fun detachView()                            //Desattachea la vista
        //Estos tres primeros metodos se repiten en todos los contracts de los MVP
        //Ahora se encuentran los especificos de la Activity
        fun checkEmptyName(fullname:String):Boolean
        fun checkValidEmail(email:String):Boolean
        fun checkEmptyPassword(pw1:String, pw2:String):Boolean
        fun checkPasswordMatch(pw1:String,pw2: String):Boolean
        fun signUp(fullname:String, email:String, password:String)      //¿Porque se debe repetir el metodo de la View?

    }

}