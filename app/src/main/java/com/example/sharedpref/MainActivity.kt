package com.example.sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref=getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor=sharedPref.edit()
        btnSave.setOnClickListener {
            val myName=name.text.toString()
            val myAge=age.text.toString().toInt()
            val myAdult=isAdult.isChecked

            editor.apply {
                putString("Iname",myName)
                putInt("Iage",myAge)
                putBoolean("Iadult",myAdult)
                apply()
            }
        }

        btnLoad.setOnClickListener {
            val loadName=sharedPref.getString("Iname",null)
            val loadAge=sharedPref.getInt("Iage",0)
            val loadAdult=sharedPref.getBoolean("Iadult",false)

            name.setText(loadName)
            
            age.setText(loadAge.toString())
            isAdult.isChecked=loadAdult

        }
    }
}