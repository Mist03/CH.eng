package com.example.cheng.Topics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.cheng.*
import com.example.cheng.R
import com.example.cheng.Words.TypePCWordActivity
import com.google.firebase.database.*


@Suppress("DEPRECATION")
class TypePCTopic : AppCompatActivity() {
    lateinit var databaseRef: DatabaseReference
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_pctopic)

        databaseRef = FirebaseDatabase.getInstance().getReference()
        textView1 = findViewById(R.id.textView2)
        textView2 = findViewById(R.id.Toc1)
        textView3 = findViewById(R.id.textView3)
        textView3.text = "Source: printed edition of Infotech English by Santiago Remacha Esteras"
        databaseRef.child("Topic/Fourth_topic/Toc").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView2.text = ("${snapshot.value}")
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        databaseRef.child("Topic/Fourth_topic/Text").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView1.text = ("${snapshot.value}".replace(":", ":\n").replace("•", "\n •").replace("     ", "\n\n"))
            }
            override fun onCancelled(error: DatabaseError) {}
        })
//        Glide.with(this).load(UrlImage1).into(Photo)

        val btn = findViewById<Button>(R.id.buttonBack)
        btn.setOnClickListener {
            onBackPressed()
        }
        val btn1 = findViewById<Button>(R.id.btnSeeWords)
        btn1.setOnClickListener {
            val intent = Intent(this, TypePCWordActivity::class.java)
            startActivity(intent)
        }
    }
}