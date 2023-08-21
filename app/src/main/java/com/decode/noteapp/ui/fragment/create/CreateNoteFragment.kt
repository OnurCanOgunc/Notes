package com.decode.noteapp.ui.fragment.create

import androidx.fragment.app.viewModels
import com.decode.noteapp.base.BaseFragment
import com.decode.noteapp.databinding.FragmentCreateNoteBinding
import com.decode.noteapp.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment :
    BaseFragment<NotesViewModel, FragmentCreateNoteBinding>(FragmentCreateNoteBinding::inflate) {
    override val viewModel: NotesViewModel by viewModels()

    override fun observeEvents() {
        TODO("Not yet implemented")
    }

    override fun onCreateFinished() {
        TODO("Not yet implemented")
    }


}