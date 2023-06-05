package com.example.cheng.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cheng.R
import com.example.cheng.Uses.MainActivity
import com.example.cheng.enguser


class UsersWordsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_userswords, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn1 = view.findViewById<Button>(R.id.addwords)
        btn1.setOnClickListener {
            val intent = Intent(view.context, AddWordsFragment::class.java)
            startActivity(intent)
        }
        val btn2 = view.findViewById<Button>(R.id.viewingwords)
        btn2.setOnClickListener {
            val intent = Intent(view.context, ViewingWordsFragment::class.java)
            startActivity(intent)
        }
        val btn3 = view.findViewById<Button>(R.id.shoosewords)
        btn3.setOnClickListener {
            if (enguser.size >= 4) {
                val intent = Intent(view.context, ShooseWordsFragment::class.java)
                startActivity (intent)
            } else {
                Toast.makeText(activity, "Мало слов для тестирования", Toast.LENGTH_SHORT).show()
            }
        }
        val btn4 = view.findViewById<Button>(R.id.writingwords)
        btn4.setOnClickListener {
            if(enguser.size >=4) {
                val intent = Intent(view.context, WritingWordsFragment::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(activity, "Мало слов для тестирования", Toast.LENGTH_SHORT).show()
            }
        }

    }

}