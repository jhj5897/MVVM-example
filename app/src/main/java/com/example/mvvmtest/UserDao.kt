package com.example.mvvmtest

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table ORDER BY name")
    fun getAlphbetizedUsers():LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(userEntity:UserEntity)

    @Query("DELETE FROM user_table")
    fun deleteAll()
}