package com.mfqan.creating.kurikulumtodolist.fragment.add

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mfqan.creating.kurikulumtodolist.R
import com.mfqan.creating.kurikulumtodolist.data.Priority
import com.mfqan.creating.kurikulumtodolist.data.ToDoData
import com.mfqan.creating.kurikulumtodolist.data.viewmodel.ToDoViewModel
import com.mfqan.creating.kurikulumtodolist.fragment.SharedViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private val myTodoViewModel: ToDoViewModel by viewModels()
    private val mySharedViewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewAdd =  inflater.inflate(R.layout.fragment_add, container, false)

        viewAdd.spinner_priority_add.onItemSelectedListener = mySharedViewModel.listenerSpinner
        setHasOptionsMenu(true)
        return viewAdd
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)

    }
    private fun insertDataDB() {
        val myTitle = edt_title_add.text.toString()
        val myPriority = spinner_priority_add.selectedItem.toString()
        val myDescription = edt_desc_add.text.toString()

        val validation = mySharedViewModel.verifyDataFromUser(myTitle, myDescription)
        if (validation) {
            val newData = ToDoData(
                    0,
                    myTitle,
                    mySharedViewModel.parsePriority(myPriority),
                    myDescription
            )
            myTodoViewModel.masukkinData(newData)
            Toast.makeText(context, "Success Added Data hehe", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Gagal guys", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            insertDataDB()
        }
        return super.onOptionsItemSelected(item)
    }


}