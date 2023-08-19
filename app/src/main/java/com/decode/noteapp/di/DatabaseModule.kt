package com.decode.noteapp.di

import android.content.Context
import androidx.room.Room
import com.decode.noteapp.db.NoteDB
import com.decode.noteapp.db.NoteDao
import com.decode.noteapp.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NoteDB::class.java, DATABASE_NAME).allowMainThreadQueries()
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideNoteDao(db:NoteDB): NoteDao = db.noteDao()
}