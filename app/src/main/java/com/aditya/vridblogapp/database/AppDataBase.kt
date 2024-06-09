package com.aditya.vridblogapp.database

import androidx.room.Database
import androidx.room.RoomDatabase


import android.content.Context
import androidx.room.Room
@Database(entities = [BlogPostEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun blogPostDao(): BlogPostDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "blog_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
