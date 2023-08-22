package com.decode.noteapp.ui.fragment.create

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.decode.noteapp.R
import com.decode.noteapp.base.BaseFragment
import com.decode.noteapp.databinding.FragmentCreateNoteBinding
import com.decode.noteapp.db.NotesEntity
import com.decode.noteapp.viewmodel.NotesViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class CreateNoteFragment :
    BaseFragment<NotesViewModel, FragmentCreateNoteBinding>(FragmentCreateNoteBinding::inflate) {
    override val viewModel: NotesViewModel by viewModels()

    override fun observeEvents() {

    }

    override fun onCreateFinished() {

    }

    override fun pass() {
        binding.apply {
            imageViewBack.setOnClickListener {
                findNavController().navigate(R.id.action_createNoteFragment_to_homeFragment)
            }
            imageViewCheck.setOnClickListener {
                saveNote()
            }
        }
    }

    private fun saveNote() {

        when {
            binding.editTextTitle.text.isNullOrEmpty() -> {
                Snackbar.make(requireView(), getString(R.string.note_title), Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.ok)) {}.show()
            }

            binding.editTextNote.text.isNullOrEmpty() -> {
                Snackbar.make(requireView(), getString(R.string.note), Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.ok)) {}.show()
            }

            else -> {
                NotesEntity(
                    noteTitle = binding.editTextTitle.text.toString(),
                    note = binding.editTextNote.text.toString(),
                    date = dateTime()!!
                ).also {
                    viewModel.saveNote(it)
                    findNavController().navigate(R.id.action_createNoteFragment_to_homeFragment)
                }
            }
        }
    }

    private fun dateTime(): String? {
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.ROOT)
        return sdf.format(Date())
    }

}