package com.example.cheng.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cheng.Data.ActivityResult
import com.example.cheng.R
import com.example.cheng.Uses.Prolog2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class ProfileFragment : Fragment() {
    lateinit var databaseRef: DatabaseReference
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    var t1 =""
    var t2 =""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentUser = FirebaseAuth.getInstance().getCurrentUser()?.getUid()
        textView1 = view.findViewById(R.id.textView7)
        textView2 = view.findViewById(R.id.textView8)

        databaseRef = FirebaseDatabase.getInstance().getReference()
        databaseRef.child("Profile/${currentUser}/firstname").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView1.text = ("${snapshot.value}")
                t1 = ("${snapshot.value}")
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        databaseRef.child("Profile/${currentUser}/lastname").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView2.text = ("${snapshot.value}")
                t2 = ("${snapshot.value}")
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        if(t1 == "null" && t2 == "null"){
            val intent = Intent(view.context, Prolog2::class.java)
            intent.putExtra("Exit", "1")
            startActivity(intent)
        }
        val btn = view.findViewById<Button>(R.id.buttonBack)
        btn.setOnClickListener {
            val intent = Intent(view.context, Prolog2::class.java)
            intent.putExtra("Exit", "1")
            startActivity(intent)
        }
        val btnres = view.findViewById<Button>(R.id.buttonres)
        btnres.setOnClickListener {
            val intent = Intent(view.context, ActivityResult::class.java)
            startActivity(intent)
        }

    }
}