package com.decode.noteapp.ui.fragment.home

import androidx.fragment.app.viewModels
import com.decode.noteapp.base.BaseFragment
import com.decode.noteapp.databinding.FragmentHomeBinding
import com.decode.noteapp.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<NotesViewModel, FragmentHomeBinding>(
    FragmentHomeBinding::inflate) {
    override val viewModel: NotesViewModel by viewModels()

    override fun observeEvents() {
        TODO("Not yet implemented")
    }

    override fun onCreateFinished() {
        TODO("Not yet implemented")
    }


}