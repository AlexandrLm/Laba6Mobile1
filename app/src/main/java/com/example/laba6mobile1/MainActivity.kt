package com.example.laba6mobile1

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private val firstFragment = BlankFragment()
    private val secondFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView3, firstFragment)
                .commit()
        }
        else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,firstFragment)
                .replace(R.id.fragmentContainerView2, secondFragment)
                .commit()
        }
    }
}