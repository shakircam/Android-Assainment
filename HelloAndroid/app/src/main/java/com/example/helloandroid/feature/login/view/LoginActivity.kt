package com.example.helloandroid.feature.login.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.helloandroid.R
import com.example.helloandroid.core.BaseActivity
import com.example.helloandroid.core.DataFetchCallback
import com.example.helloandroid.feature.login.model.LoginResponse
import com.example.helloandroid.feature.login.model.UserCredential
import com.example.helloandroid.feature.login.presenter.AuthPresenterImpl
import com.example.helloandroid.feature.studentList.view.StudentListActivity
import com.example.helloandroid.sharedpreference.AppPreference
import com.example.helloandroid.sharedpreference.AppPreferenceImpl
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*



class LoginActivity : BaseActivity(), LoginView,DataFetchCallback<LoginResponse> {
    override val isHomeUpButtonEnable: Boolean get() = false
    lateinit var authPresenterImpl: AuthPresenterImpl
    private val apiKey = R.string.api_key.toString()
    lateinit var appPreferenceImpl: AppPreferenceImpl
    override fun setLayoutId(): Int {
      return  R.layout.activity_login
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.login)
        return toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appPreferenceImpl = AppPreferenceImpl(this)
        login.setOnClickListener {
            authPresenterImpl = AuthPresenterImpl(this,this,userCredential(),apiKey,this )
            loginCheck()
            authPresenterImpl.login()

        }
    }

    override fun onSuccess(data: LoginResponse) {

            val intent = Intent(this, StudentListActivity::class.java)
            startActivity(intent)
        data.token?.let { appPreferenceImpl.setString(AppPreference.TOKEN, it)
        }
    }

    override fun onBlogListRetrieveFailure(errorMessage: String) {
          showToast(errorMessage)
    }

    override fun onError(throwable: Throwable) {
         showToast("Login isn't successful")
    }
    private fun userCredential(): UserCredential{
        return UserCredential(getEmail(),getPassword())
    }
    private fun getEmail(): String{
        if(TextUtils.isEmpty(username.editText?.text.toString())){
            username.error = "Please Enter User Id"
        }else{
            if(TextUtils.isEmpty(password.editText?.text.toString())){
                password.error = "Please Enter Password"
            }
        }

        return username.editText?.text.toString()
    }

    private fun getPassword(): String{

        return password.editText?.text.toString()
    }
    private fun loginCheck() {
        val id = getString(R.string.id)
        val pass = getString(R.string.password)
        if (username.editText?.text.toString() == id &&  password.editText?.text.toString() == pass){
            showToast("Login Successful")

        } else{
            showToast("Id & Password not match")
        }

    }
}