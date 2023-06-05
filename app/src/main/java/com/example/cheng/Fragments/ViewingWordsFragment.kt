package com.example.cheng.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cheng.*
import com.example.cheng.Data.AdapterUsersWords


class ViewingWordsFragment: AppCompatActivity() {
    var i = 0
    lateinit var pref : SharedPreferences
    lateinit var editor: SharedPreferences.Editor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viiewingwords)

        val btn = findViewById<Button>(R.id.buttonBack3)
        btn.setOnClickListener {
            onBackPressed()
        }
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        editor = pref.edit()

        val eng= pref.getString("enguser", "word")
        val rus= pref.getString("rususer", "слово")

        list1.clear()
        list2.clear()
        println(enguser)

        if (enguser.size == 0) {
            list1.addAll(eng!!.replace("[", "").replace("]", "")
                .replace(" ", "").split(",").toTypedArray())
            list2.addAll(rus!!.replace("[", "").replace("]", "")
                .replace(" ", "").split(",").toTypedArray())
            enguser.addAll(list1)
            rususer.addAll(list2)
        }else{
            editor.remove("enguser")
            editor.remove("rususer")
            editor.commit()
            editor.putString("enguser", enguser.toString())
            editor.putString("rususer", rususer.toString())
            editor.commit()

        }
        val view = findViewById<RecyclerView>(R.id.recyclerView)
        view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = AdapterUsersWords()
        view.adapter = adapter
        println(enguser.size)
        val size1 = enguser.size
//        println(size1)
        list1.clear()
        list2.clear()
        while(size1 != i){
            list1.add(enguser[i])
            list2.add(rususer[i])
            println(i)
            i++
            println(list1)
            println(list2)

            adapter.setData1(list1)
            adapter.setData2(list2)
        }

    }

}