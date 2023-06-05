package com.example.cheng.Topics

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.cheng.R
import com.example.cheng.Words.PcWordActivity
import com.example.cheng.Words.VirusWordActivity
import com.google.firebase.database.*

@Suppress("DEPRECATION")
class VirusTopic : AppCompatActivity() {
    lateinit var databaseRef: DatabaseReference
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var Photo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_virus_topic)

        databaseRef = FirebaseDatabase.getInstance().getReference()
        textView1 = findViewById(R.id.textView2)
        textView2 = findViewById(R.id.Toc1)
        textView3 = findViewById(R.id.textView3)
        textView3.text = "Source: printed edition of Infotech English by Santiago Remacha Esteras"
        Photo = findViewById(R.id.imageView8)
        val UrlImage1 = "https://firebasestorage.googleapis.com/v0/b/diplom-cf870.appspot.com/o/Pictures%2FThird_topic_1.jpg?alt=media&token=17604f89-e1d8-46d2-9bb2-839c05d01f98"

        databaseRef.child("Topic/Third_topic/Toc").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView2.text = ("${snapshot.value}")
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        databaseRef.child("Topic/Third_topic/Text").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView1.text = ("${snapshot.value}".replace(":", ":\n").replace("•", "\n\n •").replace("      ", "\n\n"))
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        Glide.with(this).load(UrlImage1).into(Photo)

        val btn = findViewById<Button>(R.id.buttonBack)
        btn.setOnClickListener {
            onBackPressed()
        }
        val btn1 = findViewById<Button>(R.id.btnSeeWords)
        btn1.setOnClickListener {
            val intent = Intent(this, VirusWordActivity::class.java)
            startActivity(intent)
        }
    }
}