package com.example.cheng.Data

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cheng.*
import com.example.cheng.Uses.MainActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ActivityResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val view = findViewById<RecyclerView>(R.id.recyclerView)
        view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = AdapterResult()
        view.adapter = adapter
        val ref = FirebaseDatabase.getInstance().reference.child("Result")
        ref.addValueEventListener(object :   //addListenerForSingleValueEvent//addValueEventListener
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list1.clear()
                list2.clear()
                list3.clear()
                for (dsp in dataSnapshot.children) {
                    val Date = (java.lang.String.valueOf(dsp.getValue()))
                    val Datelist: List<String> = Date.split(",").map { it -> it.trim() }
                    list1.add(Datelist[0].replace("{", "").replace("test=", ""))
                    list2.add(Datelist[1].replace("write=", ""))
                    list3.add(Datelist[2].replace("}", "").replace("email=", ""))

                }
                adapter.setData1(list1)
                adapter.setData2(list2)
                adapter.setData3(list3)
            }

            override fun onCancelled(error: DatabaseError) {}
        })
        val btn1 = findViewById<Button>(R.id.buttonBack6)
        btn1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}