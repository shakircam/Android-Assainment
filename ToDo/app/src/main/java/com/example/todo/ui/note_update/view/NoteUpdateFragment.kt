package com.example.todo.ui.note_update.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
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
import com.example.todo.ui.note_update.viewmodel.NoteUpdateViewModel
import com.example.todo.ui.note_update.viewmodel.NoteUpdateViewModelFactory
import kotlinx.android.synthetic.main.fragment_note_update.*
import kotlinx.android.synthetic.main.fragment_note_update.tv_description
import kotlinx.android.synthetic.main.fragment_note_update.tv_priority
import kotlinx.android.synthetic.main.fragment_note_update.tv_title
import kotlinx.android.synthetic.main.item_note_list.*


class NoteUpdateFragment : DialogFragment() {

    private lateinit var noteDataSetChangeListener: NoteDataSetChangeListener
    private val model by lazy { NoteModelImpl(requireContext().applicationContext) }
    private val viewModel by lazy {

        val factory = NoteUpdateViewModelFactory(model)
        ViewModelProvider(this, factory).get(NoteUpdateViewModel::class.java)
    }
    
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

        return inflater.inflate(R.layout.fragment_note_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setTitle(getString(R.string.title_update_note))

        bt_update.setOnClickListener {
            val title = tv_title.text.toString()
            val description = tv_description.text.toString()
            val priority = tv_priority.text.toString()

            val note = Note(title = title, description = description, priority = priority.toInt())
            viewModel.upNote(note)
        }
        btn_cancel.setOnClickListener { dismiss() }

        viewModel.noteUpdateSuccessLiveData.observe(viewLifecycleOwner,
            {
                noteDataSetChangeListener.onNoteDataChanged()
                dismiss()
            })
        viewModel.noteUpdateFailedLiveData.observe(viewLifecycleOwner, {
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