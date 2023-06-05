package com.example.cheng.Uses

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.example.cheng.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Prolog2 : AppCompatActivity() {
    lateinit var sp : SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prolog2)

        sp = getSharedPreferences("APP_SETTINGS", Context.MODE_PRIVATE)
        editor = sp.edit()
        val b = intent.getStringExtra("Exit")
        if (b=="1") {
            editor.remove("is_logged").commit()
        }

        val btn = findViewById<Button>(R.id.button2)
        btn.setOnClickListener {
            ClickPrologRegistration()
        }
        val btn2 = findViewById<Button>(R.id.button3)
        btn2.setOnClickListener {
            ClickPrologEnter()
        }
    }

    fun ClickPrologRegistration() {
        val intent = Intent(this, Reg::class.java)
        startActivity(intent)
    }

    fun ClickPrologEnter() {
        val intent = Intent(this, Log::class.java)
        startActivity(intent)
    }

}