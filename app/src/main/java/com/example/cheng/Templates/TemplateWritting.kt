package com.example.cheng

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.SystemClock
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import java.util.*

class TemplateWritting : AppCompatActivity() {
    lateinit var databaseRef: DatabaseReference

    lateinit var pref : SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    lateinit var Rus: TextView
    lateinit var Eng: EditText
    var Eng1 = ""
    var Way = ""
    private lateinit var chronometer: Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_template_writting)
        pref = getSharedPreferences("email", Context.MODE_PRIVATE)
        editor = pref.edit()
        databaseRef = FirebaseDatabase.getInstance().getReference()

        if (baf == 1){
            listText1.clear()
            listText2.clear()
            Way = "First_topic"

        }else if(baf == 2){
            listText1.clear()
            listText2.clear()
            Way = "Second_topic"

        }else if(baf == 3){
            listText1.clear()
            listText2.clear()
            Way = "Third_topic"

        }
        else if(baf == 4){
            listText1.clear()
            listText2.clear()
            Way = "Fourth_topic"

        }
        else if(baf == 5){
            listText1.clear()
            listText2.clear()
            Way = "Fifth_topic"

        }
        else if(baf == 6){
            listText1.clear()
            listText2.clear()
            Way = "Sixth_topic"

        }
        chronometer = findViewById(R.id.textView10)
        chronometer.start()

        val ref = FirebaseDatabase.getInstance().reference.child("Words/${Way}")
        ref.addValueEventListener(object :   //addListenerForSingleValueEvent//addValueEventListener
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list1.clear()
                list2.clear()
                for (dsp in dataSnapshot.children) {
                    list1.clear()
                    list2.clear()
                    val Date = (java.lang.String.valueOf(dsp.getValue()))
                    val Datelist: List<String> = Date.split(",").map { it -> it.trim() }

                    list1.add(Datelist[0].replace("{", "").replace("RUS=", ""))
                    list2.add(Datelist[1].replace("}", "").replace("ENG=", ""))
                    listText1.addAll(list1)
                    listText2.addAll(list2)
                }

                fun Randomm() {
                    val rand = Rand(listText1.size)
                    val RandResult = rand.roll()

                    Rus.text = listText1[RandResult]
                    Eng1 = listText2[RandResult]
                }
                Rus = findViewById(R.id.Eng)
                Eng = findViewById(R.id.Rus)
                Randomm()
                val CheckButton = findViewById<Button>(R.id.button)
                CheckButton.setOnClickListener {
                    val r_true = Rand3(list_True.size)
                    val rand_true = r_true.roll2()
                    if (Eng.text.toString().lowercase().replace("  "," ").trimEnd() == Eng1) {
                        if(rand_true == 0){
                            Toast.makeText(this@TemplateWritting, "Well done", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 1){
                            Toast.makeText(this@TemplateWritting, "Great", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 2){
                            Toast.makeText(this@TemplateWritting, "Cool", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 3){
                            Toast.makeText(this@TemplateWritting, "Perfect", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 4){
                            Toast.makeText(this@TemplateWritting, "Keep it up", Toast.LENGTH_SHORT).show()
                        }
                    }
                    if (Eng.text.toString().lowercase().replace("  "," ").trimEnd() != Eng1) {
                        Toast.makeText(this@TemplateWritting, "Try again", Toast.LENGTH_SHORT).show()
                    }
                    Randomm()
                    Eng.text.clear()
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })

        val btn = findViewById<Button>(R.id.buttonBack)
        btn.setOnClickListener {
            onBackPressed()
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val email= pref.getString("email", "")
        var count2 = " "
        elapsedTime = (SystemClock.elapsedRealtime() - chronometer.base) / 1000
        chronometer.stop()
        databaseRef = FirebaseDatabase.getInstance().getReference()
        databaseRef.child("Result/${email}/write").addListenerForSingleValueEvent(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.value != null){count2 = ("${snapshot.value}")}
                elapsedTime = ((elapsedTime.toInt() + count2.toInt()).toLong())
                databaseRef.child("Result/${email}/write")
                    .setValue(elapsedTime)
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        println(elapsedTime)
        // To execute back press
        super.onBackPressed()
    }

}
class Rand(private val numSides: Int) {
    fun roll(): Int {
        return (0..numSides-1).random()
    }
}
class Rand3(private val numSides2: Int) {
    fun roll2(): Int {
        return (0..numSides2-1).random()
    }

}