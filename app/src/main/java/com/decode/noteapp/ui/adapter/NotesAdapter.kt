package com.decode.noteapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.decode.noteapp.databinding.ItemNotesBinding
import com.decode.noteapp.db.NotesEntity

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    var onItemClick:((NotesEntity)->Unit)? = null

    class NotesViewHolder(private val binding: ItemNotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(notesEntity: NotesEntity, onItemClick:(NotesEntity)->Unit) {
                binding.note = notesEntity

                binding.cardView.setOnClickListener {
                    onItemClick.invoke(notesEntity)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NotesViewHolder(ItemNotesBinding.inflate(layoutInflater,parent,false))
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        onItemClick?.let { holder.bind(differ.currentList[position], it) }
    }

    private val differCalBack = object :DiffUtil.ItemCallback<NotesEntity>() {
        override fun areItemsTheSame(oldItem: NotesEntity, newItem: NotesEntity): Boolean {
            return oldItem.noteId == newItem.noteId
        }

        override fun areContentsTheSame(oldItem: NotesEntity, newItem: NotesEntity): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCalBack)

}