package com.example.mvvmtest

import androidx.lifecycle.LiveData

class Repository(mDatabase:AppDatabase) {
    private val userDao = mDatabase.userDao()
    val allUsers:LiveData<List<UserEntity>> = userDao.getAlphbetizedUsers()

    companion object {
        private var sInstance:Repository? = null
        fun getInstance(database:AppDatabase):Repository {
            return sInstance ?: synchronized(this) {
                val instance = Repository(database)
                sInstance = instance
                instance
            }
        }
    }

    suspend fun insert(userEntity:UserEntity) {
        userDao.insert(userEntity)
    }
}