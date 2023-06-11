package com.example.cheng.Uses

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cheng.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Reg : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    lateinit var firstname: EditText
    lateinit var lastname: EditText

    lateinit var sp: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    private lateinit var auth: FirebaseAuth
    var databaseReference1: DatabaseReference? = null
    var databaseReference2: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        sp = getSharedPreferences("email", Context.MODE_PRIVATE)
        editor = sp.edit()
        editor.remove("email")
        editor.commit()

        firstname = findViewById(R.id.editTextTextPersonName)
        lastname = findViewById(R.id.editTextTextPersonName2)
        etEmail = findViewById(R.id.editTextTextPersonName3)
        etConfPass = findViewById(R.id.editTextTextPersonName5)
        etPass = findViewById(R.id.editTextTextPersonName4)

        auth = Firebase.auth
        databaseRef = FirebaseDatabase.getInstance().getReference()
        database = FirebaseDatabase.getInstance()
        databaseReference1 = database?.reference!!.child("Profile")
        databaseReference2 = database?.reference!!.child("Result")


        val btn = findViewById<Button>(R.id.buttonReg)
        btn.setOnClickListener {
            signUpUser()
        }
        val btn2 = findViewById<Button>(R.id.buttonLog)
        btn2.setOnClickListener {
            ClickLogIn()
        }
    }
    private fun sendEmailVerification() {
        //get instance of firebase auth
        val firebaseAuth = FirebaseAuth.getInstance()
        //get current user
        val firebaseUser = firebaseAuth.currentUser

        //send email verification
        firebaseUser!!.sendEmailVerification()
            .addOnSuccessListener {
                Toast.makeText(this, "Ссылка отправлена на почту", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to send due to " + e.message, Toast.LENGTH_SHORT).show()
            }


    }
    private fun signUpUser() {
        val firstName = firstname.text.toString()
        val lastName = lastname.text.toString()
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        val confirmPassword = etConfPass.text.toString()
        val FL = email.replace(".","")
        editor.putString("email", FL)
        editor.apply()

        // check pass
        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank() || firstName.isBlank() || lastName.isBlank()) {
            Toast.makeText(this, "Поля не должны быть пустыми", Toast.LENGTH_SHORT).show()
            return
        }
        if (pass != confirmPassword) {
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT)
                .show()
            return
        }
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener() {
            if (it.isSuccessful) {
                sendEmailVerification()
                val currentUser = auth.currentUser
                val currentUSerDB1 = databaseReference1?.child(currentUser?.uid!!)
                currentUSerDB1?.child("email")?.setValue(email)
                currentUSerDB1?.child("password")?.setValue(pass)
                currentUSerDB1?.child("firstname")?.setValue(firstname.text.toString())
                currentUSerDB1?.child("lastname")?.setValue(lastname.text.toString())
                databaseRef.child("Result/${FL}/email")
                    .setValue(FL)
                databaseRef.child("Result/${FL}/write")
                    .setValue(0)
                databaseRef.child("Result/${FL}/test")
                    .setValue(0)
                Toast.makeText(this, "Подтвердите почту!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Log::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Ошибка регистрации!", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun ClickLogIn() {
        val intent = Intent(this, Log::class.java)
        startActivity(intent)
        finish()
    }

}
