package com.mfqan.creating.kurikulumtodolist.fragment.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mfqan.creating.kurikulumtodolist.R
import com.mfqan.creating.kurikulumtodolist.data.Priority
import com.mfqan.creating.kurikulumtodolist.data.ToDoData
import kotlinx.android.synthetic.main.list_item.view.*

class LIstAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private var dataList = emptyList<ToDoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }


    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.txt_title.text = dataList[position].title
        holder.itemView.txt_description.text = dataList[position].description

        val priority = dataList[position].priority
        when(priority) {
            Priority.HIGH -> holder.itemView.priority_indicator.setCardBackgroundColor(
                    ContextCompat.getColor(holder.itemView.context, R.color.red)
            )
            Priority.MEDIUM -> holder.itemView.priority_indicator.setCardBackgroundColor(
                    ContextCompat.getColor(holder.itemView.context, R.color.yellow)
            )
            Priority.LOW -> holder.itemView.priority_indicator.setCardBackgroundColor(
                    ContextCompat.getColor(holder.itemView.context, R.color.green)
            )
        }
    }
    fun setData(toDoData : List<ToDoData>){
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}

class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}
