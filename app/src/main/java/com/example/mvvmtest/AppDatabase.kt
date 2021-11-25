package com.example.mvvmtest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(UserEntity::class), version=1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao():UserDao

    companion object {
        private var INSTANCE:AppDatabase? = null
        private const val DATABASE_NAME = "app_database"

        fun getDatabase(context: Context, scope: CoroutineScope) : AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}