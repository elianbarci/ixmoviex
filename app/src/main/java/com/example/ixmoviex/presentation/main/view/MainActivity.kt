package com.example.ixmoviex.presentation.main.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.ixmoviex.R
import com.example.ixmoviex.base.BaseActivity
import com.example.ixmoviex.domain.interactor.maininteractor.MainInteractor
import com.example.ixmoviex.domain.interactor.maininteractor.MainInteractorImpl
import com.example.ixmoviex.presentation.main.MainContract
import com.example.ixmoviex.presentation.main.presentation.MainPresenter
import com.example.ixmoviex.presentation.main.view.fragments.AccountFragment
import com.example.ixmoviex.presentation.main.view.fragments.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main.*
import com.example.ixmoviex.presentation.main.view.fragments.HomeFragment


class MainActivity : BaseActivity(), MainContract.MainView, BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var presenter: MainPresenter
    private lateinit var textViewResult: TextView
    lateinit var notificationFragment: NotificationsFragment
    lateinit var accountFragment: AccountFragment
    private lateinit var homeFragment: HomeFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(MainInteractorImpl())
        presenter.attachView(this)
        setFragment(homeFragment)
        val user = intent.getStringExtra("User")
        if (user != null) {
            println("Empieza el bringData")
            bringDataApi(user)
            println("Termina el bringData")

        }
    }

    override fun showError(msgError: String) {
        toast(this, msgError)
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun getLayout(): Int {
        return R.layout.activity_main2
    }

    override fun bringDataApi(user: String) {
        textViewResult = text_view_result
        presenter.bringDataApi(textViewResult, user)
    }

    override fun logout() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK     //Esto hace que se destruya la pestaña de login y se establezca la nueva proxima pestaña como la "Main"
        startActivity(intent)
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        if(fragment != null){
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nestedScrollView, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fragment = null

        var result = when(item.itemId){
            R.id.nav_home -> navigation.itemBackgroundResource(R.color.colorPrimary)
            R.id.nav_account -> navigation.itemBackgroundResource(R.color.colorAccent)
            R.id.nav_notifications -> navigation.itemBackgroundResource(R.color.colorAccent)
            R.id.nav_movements -> navigation.itemBackgroundResource(R.color.colorAccent)
            R.id.nav_user -> navigation.itemBackgroundResource(R.color.colorAccent)
        }

        if(result === item.itemId){
            return true
        }
        return false
    }

    private fun setFragment(fragment: Fragment){
        var fragmentTransaction = getSupportFragmentManager().beginTransaction()
        fragmentTransaction.replace(R.id.nav_home, fragment)
        fragmentTransaction.commit()
    }


}

