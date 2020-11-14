package com.example.assinmentthree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val  mySharedPreferences = MySharedPreferences.getPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerTx.setOnClickListener {
          val  intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        loginBt.setOnClickListener {
            val  intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)

        }
    }

    fun saveUserName() {
        val user_name = userNameEd.text.toString()
        mySharedPreferences.setUserName(user_name)
    }

    fun savePassword(){
        val password = passwordEd.text.toString()
        mySharedPreferences.setPassword(password)
    }

    fun loginCheck(){

    }

}