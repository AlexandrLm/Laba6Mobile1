package com.example.laba6mobile1

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(){
    private val firstFragment = BlankFragment()
    private val secondFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, firstFragment)
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView2, secondFragment)
                .commit()
        }
    }
    fun setAction(action: String, actionCode: Int) {
        secondFragment.setAction(action, actionCode)
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .hide(secondFragment)
                .commit()
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .show(secondFragment)
                .commit()
        }
    }
}