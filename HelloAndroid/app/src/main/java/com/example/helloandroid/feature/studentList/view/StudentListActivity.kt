package com.example.helloandroid.feature.studentList.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helloandroid.R
import com.example.helloandroid.core.BaseActivity
import com.example.helloandroid.feature.studentDetails.view.DetailsActivity
import com.example.helloandroid.feature.studentList.model.StudentResponse
import com.example.helloandroid.feature.studentList.presenter.StudentListPresenter
import com.example.helloandroid.feature.studentList.presenter.StudentListPresenterImpl
import com.example.helloandroid.sharedpreference.AppPreference
import com.example.helloandroid.sharedpreference.AppPreferenceImpl
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_student_list.*
import kotlinx.android.synthetic.main.activity_student_list.progress
import kotlinx.android.synthetic.main.toolbar.*

class StudentListActivity : BaseActivity(), StudentView {
    override fun setLayoutId(): Int {
       return R.layout.activity_student_list
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = "Student List"
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get() = false
    private lateinit var studentListPresenter: StudentListPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appPreference = AppPreferenceImpl(this)
        val token = appPreference.getString(AppPreference.TOKEN)

        Log.d(token,"this is token")
        studentListPresenter = token?.let { StudentListPresenterImpl(this, it) }!!
        studentListPresenter.getStudentList(this)

    }

    override fun progressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }

    override fun onStudentListRetrieveSuccess(data: List<StudentResponse.Data>) {
        initAdapter(data)
    }

    private fun initAdapter(data: List<StudentResponse.Data>) {
        val adapter = StudentListAdapter(data, object : ItemClickListener<Int> {
            override fun onItemClick(data: Int) {
                val intent = Intent(this@StudentListActivity, DetailsActivity::class.java)
                startActivity(intent)
            }


        })
        recyclerViewId.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerViewId.adapter = adapter

    }

    override fun onStudentListRetrieveFailure(errorMessage: String) {
        TODO("Not yet implemented")
    }
}