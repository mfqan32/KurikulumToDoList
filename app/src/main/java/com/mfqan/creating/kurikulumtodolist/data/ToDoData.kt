package com.mfqan.creating.kurikulumtodolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "todo_table")
data class ToDoData (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title : String,
    var priority : Priority,
    var description : String
)

enum class Priority{
    HIGH,
    MEDIUM,
    LOW
}