package com.example.cheng.Data


import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cheng.*
import com.example.cheng.Fragments.ViewingWordsFragment

class AdapterUsersWords: RecyclerView.Adapter<AdapterUsersWords.ViewHolder>() {


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
//    fun removeItem(position: Int) {
//        list1.removeAt(position)
//        list2.removeAt(position)
//        notifyDataSetChanged()
//    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textId: TextView
        var textText1: TextView
        var textText2: TextView
        var dropbutton: ImageButton
        init {

            textId = itemView.findViewById(R.id.textId)
            textText1 = itemView.findViewById(R.id.textText1)
            textText2 = itemView.findViewById(R.id.textText2)
            dropbutton = itemView.findViewById(R.id.dropbutton)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_item2, parent, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textId.text = (position).toString()
        holder.textText1.text = list1[position]
        holder.textText2.text = list2[position]

        holder.dropbutton.setOnClickListener {
            var a = holder.getAdapterPosition()
            list1.removeAt(a)
            enguser.removeAt(a)
            list2.removeAt(a)
            rususer.removeAt(a)

            //Перезагрузка активити
            val int = Intent(holder.itemView.context, ViewingWordsFragment::class.java)
            holder.itemView.context.startActivity(int)
            (holder.itemView.context as ViewingWordsFragment).finish()

        }
    }

    override fun getItemCount(): Int {
        return this.listText1.count()

    }
}