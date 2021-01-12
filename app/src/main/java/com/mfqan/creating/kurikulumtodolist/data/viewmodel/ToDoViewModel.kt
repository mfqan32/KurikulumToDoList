package com.mfqan.creating.kurikulumtodolist.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mfqan.creating.kurikulumtodolist.data.ToDoData
import com.mfqan.creating.kurikulumtodolist.data.ToDoDatabase
import com.mfqan.creating.kurikulumtodolist.data.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application): AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).todoDao()
    private val repository : ToDoRepository

    val getAllData : LiveData<List<ToDoData>>

    init {
        repository = ToDoRepository(toDoDao)
        getAllData = repository.getALLData
    }
    //create Data
    fun masukkinData(toDoData: ToDoData){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertData(toDoData)
        }
    }
}