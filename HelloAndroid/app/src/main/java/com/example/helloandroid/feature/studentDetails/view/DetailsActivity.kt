package com.example.helloandroid.feature.studentDetails.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.helloandroid.R
import com.example.helloandroid.core.BaseActivity
import com.example.helloandroid.feature.studentDetails.presenter.StudentInfoPresenter
import com.example.helloandroid.feature.studentDetails.presenter.StudentInfoPresenterImpl
import com.example.helloandroid.feature.studentList.model.StudentResponse
import com.example.helloandroid.sharedpreference.AppPreference
import com.example.helloandroid.sharedpreference.AppPreferenceImpl
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_details.progress
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*



class DetailsActivity : BaseActivity(),StudentInfoView {
    override fun setLayoutId(): Int {
        return R.layout.activity_details
    }

    override fun setToolbar(): Toolbar {
       toolbar.title = "Student Details"
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get() = false
    private lateinit var studentInfoPresenter: StudentInfoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appPreference = AppPreferenceImpl(this)
        val token = appPreference.getString(AppPreference.TOKEN)

        studentInfoPresenter = token?.let { StudentInfoPresenterImpl(this, id, it) }!!
        studentInfoPresenter.getSingleStudent(this)

    }

    override fun progressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    override fun onStudentListRetrieveSuccess(studentResponse: List<StudentResponse.Data>) {
       val student = studentResponse[0]
        Glide.with(this)
            .load(student.image)
            .into(iv_image)

        tvName.text = "Name : "+student.name
        tvInstu.text = "Institute : "+student.institution
        tvPhone.text = "Phone : "+student.phone
        tvEmail.text = "Email : "+student.email
        tv_title.text = getString(R.string.Biography)
        tvBio .text =student.biography


    }

    override fun onStudentListRetrieveFailure(errorMessage: String) {
        showToast("Data aren't coming....")
    }

    companion object {
        private const val id = 106
    }
}