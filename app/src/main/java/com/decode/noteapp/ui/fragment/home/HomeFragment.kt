package com.decode.noteapp.ui.fragment.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.decode.noteapp.R
import com.decode.noteapp.base.BaseFragment
import com.decode.noteapp.databinding.FragmentHomeBinding
import com.decode.noteapp.ui.adapter.NotesAdapter
import com.decode.noteapp.utils.initRecyclerView
import com.decode.noteapp.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<NotesViewModel, FragmentHomeBinding>(
    FragmentHomeBinding::inflate) {
    override val viewModel: NotesViewModel by viewModels()
    private val adapter: NotesAdapter by lazy {
        NotesAdapter()
    }

    override fun observeEvents() {
        viewModel.getAllNotes()
        viewModel.notesList.observe(viewLifecycleOwner) {
            adapter.differ.submitList(it)
        }
    }

    override fun onCreateFinished() {
        initRcylerView()
        noteOnItemClick()
    }

    override fun pass() {
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_createNoteFragment)
        }
    }

    private fun initRcylerView() {
        binding.rv.initRecyclerView(StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL), adapter)
    }

    private fun noteOnItemClick() {
        adapter.onItemClick = {
            val nav = HomeFragmentDirections.actionHomeFragmentToCreateNoteFragment(it)
            findNavController().navigate(nav)
        }
    }

}