package com.mfqan.creating.kurikulumtodolist.fragment.list

import android.os.Bundle
import android.view.*
import android.widget.ListAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mfqan.creating.kurikulumtodolist.R
import com.mfqan.creating.kurikulumtodolist.data.viewmodel.ToDoViewModel
import com.mfqan.creating.kurikulumtodolist.fragment.list.adapter.LIstAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private val mToDoViewModel: ToDoViewModel by viewModels()
    private val listAdapter : LIstAdapter by lazy { LIstAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewList = inflater.inflate(R.layout.fragment_list, container, false)

        val rvTodo = viewList.rv_todo
        rvTodo.apply {
            layoutManager = StaggeredGridLayoutManager(2,GridLayoutManager.VERTICAL)
            adapter = listAdapter
        }
        mToDoViewModel.getAllData.observe(viewLifecycleOwner, Observer {data ->
            listAdapter.setData(data)
        })

//        viewList.list_layout.setOnClickListener {
//            findNavController().navigate(R.id.action_listFragment_to_updateFragment)
//        }
        viewList.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu, menu)
    }
}