package com.example.cheng.Uses

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cheng.R
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth

class Log : AppCompatActivity() {
    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    lateinit var sp: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)
        etEmail = findViewById(R.id.editTextTextPersonName6)
        etPass = findViewById(R.id.editTextTextPersonName7)
        auth = FirebaseAuth.getInstance()
        sp = getSharedPreferences("email", Context.MODE_PRIVATE)
        editor = sp.edit()
        editor.remove("email")
        editor.commit()
        val btn = findViewById<Button>(R.id.buttonLog2)
        btn.setOnClickListener {
            login()
        }

        val btn2 = findViewById<Button>(R.id.buttonReg2)
        btn2.setOnClickListener {
            ClickbtnReturnRegistration()
        }
    }

    private fun login() {
        //get instance of firebase auth
        val firebaseAuth = FirebaseAuth.getInstance()
        //get current user
        val firebaseUser = firebaseAuth.currentUser

        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        val FL = email.replace(".","")
        editor.putString("email", FL)
        editor.apply()
        // check pass
        if (email.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Email и Пароль не заполнены", Toast.LENGTH_SHORT).show()
            return
        }
            auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
                if (firebaseUser?.isEmailVerified() == true) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Успешный вход", Toast.LENGTH_SHORT).show()

                    sp = getSharedPreferences("APP_SETTINGS", Context.MODE_PRIVATE)
                    editor = sp.edit()

                    editor.putBoolean("is_logged", true).commit()

                    val handler = Handler()
                    handler.postDelayed({ start() }, 1000)
                } else
                    Toast.makeText(this, "Ошибка входа", Toast.LENGTH_SHORT).show()
            }
                if (firebaseUser?.isEmailVerified() != true) {
                    Toast.makeText(this, "Пользователь не проверен...", Toast.LENGTH_SHORT).show()

                }

        }

    }

    fun start() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun ClickbtnReturnRegistration() {
        val intent = Intent(this, Reg::class.java)
        startActivity(intent)
        finish()
    }
}