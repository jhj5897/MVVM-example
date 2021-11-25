package com.example.mvvmtest

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val mainText :ObservableField<String> = ObservableField("Main")

    val repository:Repository = Repository(AppDatabase.getDatabase(application, viewModelScope))
    val allUsers:LiveData<List<UserEntity>> = repository.allUsers

    fun insert(userEntity: UserEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(userEntity)
    }
}