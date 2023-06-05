package com.example.cheng.Data

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cheng.*
import com.example.cheng.Topics.*


class AdapterClass(private val dataList: ArrayList<DataClass>,
                   private val typeFragment: Int): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle


        holder.itemView.setOnClickListener {
            when(typeFragment) {
                1 -> {
                    if(position == 0){
                        var a = Intent(holder.itemView.context, EnternetTopic::class.java)
                        holder.itemView.context.startActivity(a)
                    }else if (position == 1){
                        var a = Intent(holder.itemView.context, PcTopic::class.java)
                        holder.itemView.context.startActivity(a)
                    }else if (position == 2){
                        var a = Intent(holder.itemView.context, VirusTopic::class.java)
                        holder.itemView.context.startActivity(a)
                    }else if (position == 3){
                        var a = Intent(holder.itemView.context, TypePCTopic::class.java)
                        holder.itemView.context.startActivity(a)
                    }else if (position == 4){
                        var a = Intent(holder.itemView.context, CPUTopic::class.java)
                        holder.itemView.context.startActivity(a)
                    }else if (position == 5){
                        var a = Intent(holder.itemView.context, TypeMemoryTopic::class.java)
                        holder.itemView.context.startActivity(a)
                    }
                }
                2 -> {
                    if(position == 0){
                        var a = Intent(holder.itemView.context, TemplateTesting::class.java)
                        baf = 1
                        holder.itemView.context.startActivity(a)
                    }else if (position == 1){
                        var a = Intent(holder.itemView.context, TemplateTesting::class.java)
                        baf = 2
                        holder.itemView.context.startActivity(a)
                    }else if (position == 2){
                        var a = Intent(holder.itemView.context, TemplateTesting::class.java)
                        baf = 3
                        holder.itemView.context.startActivity(a)
                    }else if (position == 3){
                        var a = Intent(holder.itemView.context, TemplateTesting::class.java)
                        baf = 4
                        holder.itemView.context.startActivity(a)
                    }else if (position == 4){
                        var a = Intent(holder.itemView.context, TemplateTesting::class.java)
                        baf = 5
                        holder.itemView.context.startActivity(a)
                    }else if (position == 5){
                        var a = Intent(holder.itemView.context, TemplateTesting::class.java)
                        baf = 6
                        holder.itemView.context.startActivity(a)
                    }

                }

                3 -> {
                    if(position == 0){
                        var a = Intent(holder.itemView.context, TemplateWritting::class.java)
                        baf = 1
                        holder.itemView.context.startActivity(a)
                    }else if (position == 1){
                        var a = Intent(holder.itemView.context, TemplateWritting::class.java)
                        baf = 2
                        holder.itemView.context.startActivity(a)
                    }else if (position == 2){
                        var a = Intent(holder.itemView.context, TemplateWritting::class.java)
                        baf = 3
                        holder.itemView.context.startActivity(a)
                    }else if (position == 3){
                        var a = Intent(holder.itemView.context, TemplateWritting::class.java)
                        baf = 4
                        holder.itemView.context.startActivity(a)
                    }else if (position == 4){
                        var a = Intent(holder.itemView.context, TemplateWritting::class.java)
                        baf = 5
                        holder.itemView.context.startActivity(a)
                    }else if (position == 5){
                        var a = Intent(holder.itemView.context, TemplateWritting::class.java)
                        baf = 6
                        holder.itemView.context.startActivity(a)
                    }
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }



    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {

        val rvImage: ImageView = itemView.findViewById(R.id.image)
        val rvTitle: TextView = itemView.findViewById(R.id.title)

    }

}