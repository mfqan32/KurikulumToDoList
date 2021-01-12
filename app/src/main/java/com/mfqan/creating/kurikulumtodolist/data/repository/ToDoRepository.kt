package com.mfqan.creating.kurikulumtodolist.data.repository

import androidx.lifecycle.LiveData
import com.mfqan.creating.kurikulumtodolist.data.ToDoDao
import com.mfqan.creating.kurikulumtodolist.data.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getALLData : LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }
}