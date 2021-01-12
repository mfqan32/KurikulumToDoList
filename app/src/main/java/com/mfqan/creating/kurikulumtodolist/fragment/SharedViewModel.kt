package com.mfqan.creating.kurikulumtodolist.fragment

import android.app.Application
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.mfqan.creating.kurikulumtodolist.R
import com.mfqan.creating.kurikulumtodolist.data.Priority

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    //set Color Widget Spinner
    val listenerSpinner: AdapterView.OnItemSelectedListener =
        object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                application,
                                R.color.red
                            )
                        )
                    }
                    1 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                application,
                                R.color.yellow
                            )
                        )
                    }
                    2 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                application,
                                R.color.green
                            )
                        )
                    }
                }
            }
        }

    fun verifyDataFromUser(myTitle: String, myDescription: String): Boolean {
        return !(myTitle.isEmpty() || myDescription.isEmpty())
    }

    fun parsePriority(myPriority: String): Priority {
        return when (myPriority) {
            "High Priority" -> {
                Priority.HIGH
            }
            "Medium Priority" -> {
                Priority.MEDIUM
            }
            "LOW Priority" -> {
                Priority.LOW
            }
            else -> Priority.LOW
        }
    }
}