package com.decode.noteapp.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.decode.noteapp.utils.Constants.TABLE_NAME
import kotlinx.parcelize.Parcelize

@Entity(tableName = TABLE_NAME)
@Parcelize
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
    val noteTitle: String?,
    val note: String?,
    val date: String?
):Parcelable
