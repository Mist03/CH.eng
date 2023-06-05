package com.example.cheng.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cheng.R
import com.example.cheng.list1
import com.example.cheng.list2


class AdapterWords: RecyclerView.Adapter<AdapterWords.ViewHolder>() {


    val listText1 = mutableListOf<String>()
    val listText2 = mutableListOf<String>()

    fun setData1(list1: List<String>) {
        this.listText1.clear()
        this.listText1.addAll(list1)
        notifyDataSetChanged()
    }
    fun setData2(list2: List<String>) {
        this.listText2.clear()
        this.listText2.addAll(list2)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textId: TextView
        var textText1: TextView
        var textText2: TextView

        init {
            textId = itemView.findViewById(R.id.textId)
            textText1 = itemView.findViewById(R.id.textText1)
            textText2 = itemView.findViewById(R.id.textText2)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textId.text = position.toString()
        holder.textText1.text = list1[position]
        holder.textText2.text = list2[position]

        }


    override fun getItemCount(): Int {
        return this.listText1.count()

    }
}