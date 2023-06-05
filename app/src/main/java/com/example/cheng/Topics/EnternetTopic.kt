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
import com.example.cheng.Words.EnternetWordActivity
import com.example.cheng.Words.PcWordActivity
import com.google.firebase.database.*


@Suppress("DEPRECATION")
class EnternetTopic : AppCompatActivity() {
    lateinit var databaseRef: DatabaseReference
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var textView4: TextView
    lateinit var textView5: TextView
    lateinit var textView6: TextView
    lateinit var textView7: TextView
    lateinit var Photo1: ImageView
    lateinit var Photo2: ImageView
    lateinit var Photo3: ImageView
    lateinit var Photo4: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enternet_topic)

        databaseRef = FirebaseDatabase.getInstance().getReference()
        textView1 = findViewById(R.id.textView2)
        textView2 = findViewById(R.id.Toc1)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7)
        textView7.text = "Source: printed edition of Infotech English by Santiago Remacha Esteras"
        Photo1 = findViewById(R.id.imageView4)
        Photo2 = findViewById(R.id.imageView1)
        Photo3 = findViewById(R.id.imageView2)
        Photo4 = findViewById(R.id.imageView3)
        val UrlImage1 = "https://firebasestorage.googleapis.com/v0/b/diplom-cf870.appspot.com/o/Pictures%2FSecond_topic_1.jpg?alt=media&token=e692ec48-1071-49b0-8a6f-2d3363053549"
        val UrlImage2 = "https://firebasestorage.googleapis.com/v0/b/diplom-cf870.appspot.com/o/Pictures%2FSecond_topic_2.jpg?alt=media&token=a4fd0b51-0203-4130-bb36-0c48215e9550"
        val UrlImage3 = "https://firebasestorage.googleapis.com/v0/b/diplom-cf870.appspot.com/o/Pictures%2FSecond_topic_3.jpg?alt=media&token=67fb5b95-0abf-43c8-ab24-b9dc89c8ba98"
        val UrlImage4 = "https://firebasestorage.googleapis.com/v0/b/diplom-cf870.appspot.com/o/Pictures%2FSecond_topic_4.jpg?alt=media&token=e49586a2-f8b2-4739-ae20-c1b902d6059d"

        databaseRef.child("Topic/Second_topic/Toc").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView2.text = ("${snapshot.value}")
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        databaseRef.child("Topic/Second_topic/Text").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView1.text = ("${snapshot.value}".replace(":", ":\n\n").replace("•", "\n\n •").replace("     ", "\n\n"))

            }
            override fun onCancelled(error: DatabaseError) {}
        })
        databaseRef.child("Topic/Second_topic/Text1").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView3.text = ("${snapshot.value}".replace(":", ":\n\n").replace("•", "\n\n •").replace("     ", "\n\n"))

            }
            override fun onCancelled(error: DatabaseError) {}
        })
        databaseRef.child("Topic/Second_topic/Text2").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView4.text = ("${snapshot.value}".replace(":", ":\n\n").replace("•", "\n\n •").replace("     ", "\n\n"))

            }
            override fun onCancelled(error: DatabaseError) {}
        })
        databaseRef.child("Topic/Second_topic/Text3").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView5.text = ("${snapshot.value}".replace(":", ":\n\n").replace("•", "\n\n •").replace("     ", "\n\n"))

            }
            override fun onCancelled(error: DatabaseError) {}
        })
        databaseRef.child("Topic/Second_topic/Text4").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView6.text = ("${snapshot.value}".replace(":", ":\n\n").replace("•", "\n\n •").replace("     ", "\n\n"))

            }
            override fun onCancelled(error: DatabaseError) {}
        })
        Glide.with(this).load(UrlImage1).into(Photo2)
        Glide.with(this).load(UrlImage2).into(Photo1)
        Glide.with(this).load(UrlImage3).into(Photo3)
        Glide.with(this).load(UrlImage4).into(Photo4)

        val btn = findViewById<Button>(R.id.buttonBack)
        btn.setOnClickListener {
            onBackPressed()
        }
        val btn1 = findViewById<Button>(R.id.btnSeeWords)
        btn1.setOnClickListener {
            val intent = Intent(this, EnternetWordActivity::class.java)
            startActivity(intent)
        }

    }
}