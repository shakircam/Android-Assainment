package com.example.assinmenttwo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_3.*
import java.io.Console

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setTitle("Profile");
        showProfile()
        button2Id.setOnClickListener{
            finish()
        }
    }

    private fun showProfile() {
       val bundle = intent.extras

        // Check null....
        bundle.let {  }


        if(bundle != null){

            val nameSh = bundle.getString("name")
            val ageSh = bundle.getString("age")
            val phoneSh = bundle.getString("phone")
            val bodySh = bundle.getString("body_weight")
            val professionSh = bundle.getString("profession")
            val heightSh = bundle.getString("height")
            val universitySh = bundle.getString("university")
            val semesterSh = bundle.getString("semester")

           // name.setText("  Name : $nameSh")

            nameId.text = ("Name: $nameSh")
            ageId.text = ("Age: $ageSh")
            phoneId.text = ("Phone: $phoneSh")
            body_weightId.text = ("Body Weight: $bodySh")
            professionId.text = ("Profession: $professionSh")
            heightId.text = ("Height: $heightSh")
            universityId.text = ("University: $universitySh")
            semesterId.text = ("Semester: $semesterSh")


        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return false
    }


}