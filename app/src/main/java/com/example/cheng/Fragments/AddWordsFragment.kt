package com.example.cheng.Fragments



import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cheng.*


class AddWordsFragment : AppCompatActivity() {
    lateinit var Rususer: EditText
    lateinit var Enguser: EditText
    lateinit var pref : SharedPreferences
    lateinit var editor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addwords)

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
        Rususer = findViewById(R.id.Rususer1)
        Enguser = findViewById(R.id.Enguser1)

        val btn = findViewById<Button>(R.id.buttonBack2)
        btn.setOnClickListener {
            onBackPressed()
        }
        val btn1 = findViewById<Button>(R.id.buttonaddword)
        btn1.setOnClickListener{
            val editor = pref?.edit()

            enguser.add(Enguser.text.toString().lowercase())
            rususer.add(Rususer.text.toString().lowercase())
            editor?.putString("enguser", enguser.toString())
            editor?.putString("rususer", rususer.toString())
            editor?.apply()
            Toast.makeText(this@AddWordsFragment, "Save", Toast.LENGTH_SHORT).show()
            Enguser.text.clear()
            Rususer.text.clear()
//            println(enguser.toString())
//            println(rususer.toString())

        }
    }


}
