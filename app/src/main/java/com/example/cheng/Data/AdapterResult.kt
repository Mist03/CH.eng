package com.example.cheng.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cheng.*

class AdapterResult: RecyclerView.Adapter<AdapterResult.ViewHolder>() {
    val listText1 = mutableListOf<String>()
    val listText2 = mutableListOf<String>()
    val listText3 = mutableListOf<String>()


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
    fun setData3(list3: List<String>) {
        this.listText3.clear()
        this.listText3.addAll(list3)
        notifyDataSetChanged()
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textText1: TextView
        var textText2: TextView
        var textText3: TextView

        init {
            textText1 = itemView.findViewById(R.id.textText1)
            textText2 = itemView.findViewById(R.id.textText2)
            textText3 = itemView.findViewById(R.id.textText3)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textText1.text = (list3[position])
        holder.textText2.text = (list2[position]+" секунд")
        holder.textText3.text = (list1[position]+" секунд")
    }

    override fun getItemCount(): Int {
        return this.listText1.count()
    }
}