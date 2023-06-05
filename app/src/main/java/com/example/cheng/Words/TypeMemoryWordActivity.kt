package com.example.cheng.Words

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cheng.*
import com.example.cheng.Data.AdapterWords
import com.example.cheng.Uses.MainActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TypeMemoryWordActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_memory_word)
        val btn1 = findViewById<Button>(R.id.backTopicMemory)
        val view = findViewById<RecyclerView>(R.id.recyclerView)
        view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = AdapterWords()
        view.adapter = adapter
        val ref = FirebaseDatabase.getInstance().reference.child("Words/Sixth_topic")
        ref.addValueEventListener(object :   //addListenerForSingleValueEvent//addValueEventListener
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list1.clear()
                list2.clear()
                for (dsp in dataSnapshot.children) {
                    val Date = (java.lang.String.valueOf(dsp.getValue()))
                    val Datelist: List<String> = Date.split(",").map { it -> it.trim() }

                    list1.add(Datelist[0].replace("{", "").replace("RUS=", ""))
                    list2.add(Datelist[1].replace("}", "").replace("ENG=", ""))

                }

                adapter.setData1(list1)
                adapter.setData2(list2)
            }

            override fun onCancelled(error: DatabaseError) {}
        })

        btn1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}