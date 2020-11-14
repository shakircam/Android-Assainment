package com.example.assinmenttwo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.isEmpty
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : AppCompatActivity() {
    var name = ""
    var age = ""
    var phone = ""
    var body_weight = ""
    var profession = ""
    var height = ""
    var university = ""
    var semester = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setTitle("Edit Profile");
        Save.setOnClickListener { sendProfile() }

    }

    private fun sendProfile() {

// Null Sefty Check....
       name = nameEd?.text.toString()



        if(nameEd != null  ){
            name = nameEd.text.toString()
        }
        if (AgeEd != null){
            age = AgeEd.text.toString()
        }
        if (phoneEd != null){
            phone = phoneEd.text.toString()
        }
        if (body_weightEd != null){
            body_weight = body_weightEd.text.toString()
        }
        if (ProfessionEd != null){
            profession = ProfessionEd.text.toString()
        }
        if (HightEd != null){
            height = HightEd.text.toString()
        }
        if (UniversityEd != null){
            university = UniversityEd.text.toString()
        }

        if (semisterEd != null){
            semester = semisterEd.text.toString()
        }



        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("age", age)
        bundle.putString("phone", phone)
        bundle.putString("body_weight", body_weight)
        bundle.putString("profession", profession)
        bundle.putString("height", height)
        bundle.putString("university", university)
        bundle.putString("semester", semester)

        val intent = Intent(this, Activity3::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
        Toast.makeText(this, "Data send perfectly...", Toast.LENGTH_SHORT).show()
        finish()


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


