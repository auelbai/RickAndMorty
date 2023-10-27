package com.example.rickandmorty.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rickandmorty.models.Character

@Database(entities = [Character::class], version = 1)
@TypeConverters(Converters::class)
abstract class CharacterDatabase: RoomDatabase() {

    abstract fun getCharactersDao(): CharactersDao

    companion object{
        @Volatile
        private var instance: CharacterDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "characters_db"

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDb(context).also { instance = it }
        }

        private fun createDb(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CharacterDatabase::class.java, DB_NAME
            ).build()
    }
}