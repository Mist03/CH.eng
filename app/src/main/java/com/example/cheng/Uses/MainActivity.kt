package com.example.cheng.Uses

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.example.cheng.*
import com.example.cheng.Data.DataClass
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(){
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var pref : SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        dataList = arrayListOf<DataClass>()
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        editor = pref.edit()

        val eng= pref.getString("enguser", "word")
        val rus= pref.getString("rususer", "слово")

        list1.clear()
        list2.clear()
        println(enguser)

        if (enguser.size == 0) {
            list1.addAll(eng!!.replace("[", "").replace("]", "")
                .replace(" ", "").split(",").toTypedArray())
            list2.addAll(rus!!.replace("[", "").replace("]", "")
                .replace(" ", "").split(",").toTypedArray())
            enguser.addAll(list1)
            rususer.addAll(list2)
        }else{
            editor.remove("enguser")
            editor.remove("rususer")
            editor.commit()
            editor.putString("enguser", enguser.toString())
            editor.putString("rususer", rususer.toString())
            editor.commit()
        }
    }
}