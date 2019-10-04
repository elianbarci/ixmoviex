package com.example.ixmoviex.presentation.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ixmoviex.R
import com.example.ixmoviex.base.BaseActivity
import com.example.ixmoviex.presentation.main.view.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    println("Home pressed")
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_user -> {
                    println("User pressed")
                    replaceFragment(UserFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_movements -> {
                    println("Nav Pressed")
                    replaceFragment(MovementsFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_notifications -> {
                    println("Notifications Pressed")
                    replaceFragment(NotificationsFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_account -> {
                    println("Account Pressed")
                    replaceFragment(AccountFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            return@OnNavigationItemSelectedListener false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFragment())
    }

    override fun getLayout(): Int {
        return R.layout.activity_main2
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

}
