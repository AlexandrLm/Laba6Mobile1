package com.example.laba6mobile1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class SecondActivity : AppCompatActivity() {
    private val secondFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setNewFragment(secondFragment, R.id.main)
    }
    @SuppressLint("CommitTransaction")
    fun setNewFragment(fragment : Fragment, id : Int){
        val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(id, fragment)
        ft.commit()
    }
}