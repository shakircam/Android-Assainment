package com.example.assinmentfour

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.assinmentfour.DataModel.AppPreference
import com.example.assinmentfour.DataModel.AppPreferenceImpl
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    private lateinit var appPreference: AppPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Profile"

        appPreference = AppPreferenceImpl(this)
        showImage()
        showData()
        editBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

  @SuppressLint("SetTextI18n")
  fun  showData(){
      nameEd.text = "Name: "+appPreference.getString(AppPreference.NAME)
      ageEd.text = "Age: "+appPreference.getInt(AppPreference.AGE).toString()
      weightEd.text = "Weight: "+appPreference.getInt(AppPreference.WEIGHT).toString()
      notiEnable.text = appPreference.getBoolean(AppPreference.NOTIFICATION).toString()
      gender_item.text = appPreference.getString(AppPreference.GENDER)

    }

    private fun showImage(){
        val url = appPreference.getString(AppPreference.URL)
        Glide.with(this)
            .load(url)
            .override(300,200)
            .centerCrop()
            .placeholder(R.drawable.ic_image_place_holder)
            .error(R.drawable.ic_broken_image)
            .fallback(R.drawable.ic_no_image)
            .into(imageView)
    }
        override fun onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
        }
}