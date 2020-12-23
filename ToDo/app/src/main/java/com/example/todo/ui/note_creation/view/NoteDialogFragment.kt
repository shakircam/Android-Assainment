package com.example.todo.ui.note_creation.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.todo.R
import com.example.todo.data.db.NoteDataSetChangeListener
import com.example.todo.data.model.Note
import com.example.todo.data.model.NoteModelImpl
import com.example.todo.ui.note_creation.viewmodel.NoteCreateViewModel
import com.example.todo.ui.note_creation.viewmodel.NoteCreateViewModelFactory
import kotlinx.android.synthetic.main.item_note_list.*

class NoteDialogFragment:DialogFragment() {

    private val model by lazy { NoteModelImpl(requireContext().applicationContext) }
    private val viewModel by lazy {

        val factory = NoteCreateViewModelFactory(model)
        ViewModelProvider(this, factory).get(NoteCreateViewModel::class.java)
    }

    private lateinit var noteDataSetChangeListener: NoteDataSetChangeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NoteDataSetChangeListener) {
            noteDataSetChangeListener = context
        } else
            throw ClassCastException("Caller class must implement StudentCrudListener interface")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setTitle(getString(R.string.title_create_note))

        bt_create.setOnClickListener {

            val title = tv_title.text.toString()
            val description = tv_description.text.toString()
            val priority = tv_priority.text.toString()


            if (title.isEmpty() || description.isEmpty() || priority.isEmpty()) {
                Toast.makeText(requireContext(), "All fields are required", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val note = Note(title = title, description = description, priority = priority.toInt())
            viewModel.createNote(note)

        }
        bt_cancel.setOnClickListener { dismiss() }

        viewModel.noteCreationSuccessLiveData.observe(viewLifecycleOwner,
            {
                noteDataSetChangeListener.onNoteDataChanged()
                dismiss()
            })
        viewModel.noteCreationFailedLiveData.observe(viewLifecycleOwner, {
            noteDataSetChangeListener.onNoteDataSetChangeError(it)
        })

    }



    override fun onStart() {
        super.onStart()

        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT

        dialog?.window?.setLayout(width, height)
    }
}

