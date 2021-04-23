package com.nkechinnaji.rxjavatutorial.chores.service

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.nkechinnaji.rxjavatutorial.R
import com.nkechinnaji.rxjavatutorial.data.Tasks
import kotlinx.android.synthetic.main.chores_list_items.view.*


/**
 * Created by Nkechi Nnaji on 4/22/21.
 * Description:
 */
class ChoresAdapter(val taskList : ArrayList<Tasks>) :
    RecyclerView.Adapter<ChoresAdapter.ChoresViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ChoresViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.chores_list_items, parent, false)
        return ChoresViewHolder(inflate)
    }

    override fun getItemCount() : Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder : ChoresViewHolder, position : Int) {
        val items = taskList[position]
        holder.listedTasks.text = items.dinner
        holder.title.text = items.bed
    }


    inner class ChoresViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var title : AppCompatTextView = view.tasks_title
        var listedTasks : AppCompatTextView = view.tasks_listed
    }


}