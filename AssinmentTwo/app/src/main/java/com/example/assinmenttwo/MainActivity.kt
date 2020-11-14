package com.example.assinmenttwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    public 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener {
            checkLogin()
        }
    }

    private fun checkLogin() {
        val Email = "shakir@gmail.com"
        val Password = "1234"

        val email = emailTxt.text.toString()
        val password = passTxt.text.toString()

        if(emailTxt != null && passTxt != null ){
            if(email == Email && password == Password ) {
                val intent = Intent(this,Activity2::class.java)
                startActivity(intent)

            }
        }else{
            Toast.makeText(this,"Enter your Email & Password",Toast.LENGTH_SHORT)
        }
    }
}