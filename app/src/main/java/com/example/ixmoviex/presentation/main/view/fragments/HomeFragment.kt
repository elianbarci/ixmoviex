package com.example.ixmoviex.presentation.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ixmoviex.R
import com.example.ixmoviex.domain.interactor.maininteractor.MainInteractorImpl
import com.example.ixmoviex.presentation.main.presentation.MainPresenter

import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment() : Fragment(){

    private lateinit var textViewResult: TextView
    lateinit var presenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_home, container, false)
        presenter = MainPresenter(MainInteractorImpl())
        bringDataApi("Usuario aca",v)

        return v
    }

    fun bringDataApi(user: String, view:View) {
        println("Entro a View Home -> Bring Data Api")
        textViewResult = view.findViewById(R.id.result_text_view)
        presenter.bringDataApi(textViewResult, user)
    }

    fun getLayout(): Int {
        return R.layout.fragment_home
    }

    fun showProgress() {
        home_ProgressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        home_ProgressBar.visibility = View.GONE
    }

    fun showError(msgError: String) {
        println( msgError)
    }

}
