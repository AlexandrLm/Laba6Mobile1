package com.example.laba6mobile1

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    var text = "Данные"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish()
            return
        }

        val extras = intent.extras
        text = extras?.getString("TEXT").toString()

        setContentView(R.layout.activity_second)
    }
    override fun onResume() {
        super.onResume()
        val fragment: SecondFragment? = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView4) as SecondFragment?
        fragment?.setText(text)
    }


}