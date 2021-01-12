package com.mfqan.creating.kurikulumtodolist.data

import androidx.room.TypeConverter

public class Converter {

    @TypeConverter
    fun fromPriority(priority: Priority) : String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String) : Priority{
        return Priority.valueOf(priority)
    }
}