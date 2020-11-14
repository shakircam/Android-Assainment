package com.example.assinmentfour

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.assinmentfour.DataModel.AppPreference
import com.example.assinmentfour.DataModel.AppPreferenceImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var appPreference: AppPreference
    var checkvalue = false
    var gender = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Profile Setting"
        appPreference = AppPreferenceImpl(this)

        // CheckBox Implementation
        checkBoxImp()
        //RadioButton(Gender)Implementation
        radioButtonImp()

        loginBt.setOnClickListener {
            emptyCheck()

        }

    }

    fun saveData(){

        //Data are lode to sharedferences....
        appPreference.setString(AppPreference.NAME, nameEd.text.toString())
        appPreference.setInt(AppPreference.AGE, (ageEd.text.toString().toInt()))
        appPreference.setInt(AppPreference.WEIGHT,(weightEd.text.toString().toInt()))
        appPreference.setString(AppPreference.URL, urlEd.text.toString())
        appPreference.setBoolean(AppPreference.NOTIFICATION,checkvalue)
        appPreference.setString(AppPreference.GENDER,gender)

        // After save data going To ProfileActivity...
        val intent = Intent(this,ProfileActivity::class.java)
        startActivity(intent)
    }

    fun checkBoxImp(){
        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(buttonView.isChecked){
                notiEnable.text="Enable"
                checkvalue = true
            }else
            {
                notiEnable.text="Not Enable"
                checkvalue = false
            }
        }
    }
    fun radioButtonImp(){
        radio.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioButton_Male)
            {
                gender = radioButton_Male.text.toString()
            }
            if (checkedId == R.id.radioButton_Female)
            {
                gender = radioButton_Female.text.toString()
            }

        }
    }
    @SuppressLint("ShowToast")
    fun emptyCheck(){
        if(TextUtils.isEmpty(nameEd.text.toString())){
            nameEd.error = "Please Enter Name"

        }
        else if (TextUtils.isEmpty(ageEd.text.toString())){
            ageEd.error = "Please Enter Age"
        }
       else if (TextUtils.isEmpty(weightEd.text.toString())){
            weightEd.error = "Please Enter weight"

        }
       else if (TextUtils.isEmpty(urlEd.text.toString())){
            urlEd.error = "Please Enter Image url"

        }
        else
            saveData()
        Toast.makeText(this,"Data Are Saved",Toast.LENGTH_SHORT)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}




