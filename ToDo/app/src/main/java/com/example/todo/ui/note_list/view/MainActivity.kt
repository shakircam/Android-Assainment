package com.example.todo.ui.note_list.view

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helloandroid.core.BaseActivity
import com.example.todo.R
import com.example.todo.data.db.NoteDataSetChangeListener
import com.example.todo.data.model.Note
import com.example.todo.data.model.NoteModelImpl
import com.example.todo.ui.note_creation.view.NoteDialogFragment
import com.example.todo.ui.note_list.viewmodel.NoteListViewModel
import com.example.todo.ui.note_list.viewmodel.NoteListViewModelFactory
import com.example.todo.ui.note_update.view.NoteUpdateFragment
import com.example.todo.utils.CREATE_NOTE
import com.example.todo.utils.UPDATE_NOTE
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity(), NoteDataSetChangeListener {

    private val model by lazy { NoteModelImpl(applicationContext) }
    private val viewModel by lazy {

        val factory = NoteListViewModelFactory(model)
        ViewModelProvider(this, factory).get(NoteListViewModel::class.java)
    }

    private val noteList by lazy { mutableListOf<Note>()  }
    private val noteListAdapter by lazy {
       NoteListAdapter(noteList, object : NoteListClickListener {

           override fun onEditButtonClicked(noteId: Long) {
               showNoteEditDialog(noteId)
           }

           override fun onDeleteButtonClicked(noteId: Long) {
               showNoteDeleteDialog(noteId)
           }

       })
    }


    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setToolbar(): Toolbar {
         toolbar.title = "To Do "
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()
        viewModel.getNoteList()

        viewModel.noteListLiveData.observe(this, {
            noteListAdapter.replaceData(it)
        })
        viewModel.noteListFailedLiveData.observe(this, {
            showToast(it)
        })
        viewModel.noteDeletionSuccessLiveData.observe(this, {
            viewModel.getNoteList()
            showToast("$it item is deleted")
        })
        viewModel.noteDeletionFailedLiveData.observe(this, {
            showToast(it)
        })

        fab.setOnClickListener { showNoteCreationDialog() }
    }

    private fun initRecyclerView() {
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.adapter = noteListAdapter
    }

    private fun showNoteCreationDialog() {

        val dialogFragment = NoteDialogFragment()
        dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog)

        dialogFragment.show(supportFragmentManager, CREATE_NOTE)
    }

    override fun onNoteDataChanged() {
        viewModel.getNoteList()
    }

    override fun onNoteDataSetChangeError(error: String) {
        showToast("Error....")
        Logger.e(error)
    }

    private fun showNoteEditDialog(noteId: Long) {
        val updateDialogFragment = NoteUpdateFragment()
        updateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog)

        updateDialogFragment.show(supportFragmentManager, UPDATE_NOTE)
        showToast(noteId.toString())
    }

    private fun showNoteDeleteDialog(noteId: Long) {
        var dialog: AlertDialog? = null

        dialog = MaterialAlertDialogBuilder(this)
            .setMessage(getString(R.string.note_delete_alert))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.deleteNoteById(noteId)
            }
            .setNegativeButton(getString(R.string.no)) { _, _ ->
                dialog?.dismiss()
            }
            .show()
    }
}