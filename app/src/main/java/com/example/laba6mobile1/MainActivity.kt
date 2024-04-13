package com.example.laba6mobile1

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), BlankFragment.OnFragmentSendDataListener{
    private val firstFragment = BlankFragment()
    private val secondFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView3, firstFragment)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, firstFragment)
                .replace(R.id.fragmentContainerView2, secondFragment)
                .commit()
        }

    }

    override fun onSendData(data : String) {
        val fragment: SecondFragment? = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView2) as SecondFragment?
        if (fragment != null && fragment.isVisible) {
                fragment.setText(data)
        }
        else{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("TEXT", data)
            startActivity(intent)
        }
    }
}