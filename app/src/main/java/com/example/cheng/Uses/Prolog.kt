package com.example.cheng.Uses

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.cheng.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Prolog : AppCompatActivity() {
    lateinit var sp : SharedPreferences
    lateinit var databaseRef: DatabaseReference
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prolog)
        databaseRef = FirebaseDatabase.getInstance().getReference()

        sp = getSharedPreferences("APP_SETTINGS", Context.MODE_PRIVATE)
        editor = sp.edit()

        if (sp.getBoolean("is_logged", false)) {
            val handler = Handler()
            handler.postDelayed({ info() }, 2000)
        } else {
            val handler = Handler()
            handler.postDelayed({ start() }, 2000)
        }
    }
    fun start() {
        val intent = Intent(this, Prolog2::class.java)
        startActivity(intent)
        finish()
    }
    fun info() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
