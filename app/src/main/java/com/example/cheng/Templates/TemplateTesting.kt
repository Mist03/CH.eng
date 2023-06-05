package com.example.cheng

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import java.util.*


class TemplateTesting : AppCompatActivity() {
    lateinit var databaseRef: DatabaseReference

    lateinit var pref : SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    lateinit var textView : TextView
    lateinit var Eng: Button
    lateinit var Rus1: Button
    lateinit var Rus2: Button
    lateinit var Rus3: Button
    lateinit var Rus4: Button
    var Rus0 = ""
    var Way = ""
    private lateinit var chronometer: Chronometer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_template_testing)
        pref = getSharedPreferences("email", Context.MODE_PRIVATE)
        editor = pref.edit()
        databaseRef = FirebaseDatabase.getInstance().getReference()
        val btn = findViewById<Button>(R.id.buttonBack)

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
        chronometer = findViewById(R.id.textView9)
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
                    val rand = Rand1(listText1.size)
                    val RandResult = rand.roll()
                    val R288 = rand.roll288()

                    Eng.text = listText2[RandResult]
                    Rus0 = listText1[RandResult]

                        Rus1.text = listText1[rand.roll()]

                        Rus2.text = listText1[rand.roll()]

                        Rus3.text = listText1[rand.roll()]

                        Rus4.text = listText1[rand.roll()]

                    if(R288 == 1){
                        Rus1.text =listText1[RandResult]

                    }else if(R288 == 2){
                        Rus2.text =listText1[RandResult]

                    }else if(R288 == 3){
                        Rus3.text =listText1[RandResult]

                    }else if(R288 == 4){
                        Rus4.text =listText1[RandResult]

                    }
                    if(Rus1.text == Rus3.text|| Rus1.text == Rus2.text || Rus1.text == Rus4.text){
                        Rus1.text = listText1[rand.roll()]
                        Rus1.text = listText1[rand.roll()]
                        Rus1.text = listText1[rand.roll()]
                        Rus1.text = listText1[rand.roll()]

                    }
                    if(Rus2 == Rus1|| Rus2.text == Rus3.text || Rus2.text == Rus4.text){
                        Rus2.text = listText1[rand.roll()]
                        Rus2.text = listText1[rand.roll()]
                        Rus2.text = listText1[rand.roll()]
                        Rus2.text = listText1[rand.roll()]

                    }
                    if(Rus3.text == Rus1.text || Rus3.text == Rus2.text || Rus3.text == Rus4.text){
                        Rus3.text = listText1[rand.roll()]
                        Rus3.text = listText1[rand.roll()]
                        Rus3.text = listText1[rand.roll()]
                        Rus3.text = listText1[rand.roll()]

                    }
                    if(Rus4.text == Rus1.text || Rus4.text == Rus2.text || Rus4.text == Rus3.text){
                        Rus4.text = listText1[rand.roll()]
                        Rus4.text = listText1[rand.roll()]
                        Rus4.text = listText1[rand.roll()]
                        Rus4.text = listText1[rand.roll()]
                    }

                }

                Eng = findViewById(R.id.ENG)
                Rus1 = findViewById(R.id.Rus1)
                Rus2 = findViewById(R.id.Rus2)
                Rus3 = findViewById(R.id.Rus3)
                Rus4 = findViewById(R.id.Rus4)

                Randomm()

                Rus1.setOnClickListener{

                    val r_true = Rand2(list_True.size)
                    val rand_true = r_true.roll2()
                    if(Rus1.text.toString() == Rus0){
                        if(rand_true == 0){
                            Toast.makeText(this@TemplateTesting, "Well done", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 1){
                            Toast.makeText(this@TemplateTesting, "Great", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 2){
                            Toast.makeText(this@TemplateTesting, "Cool", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 3){
                            Toast.makeText(this@TemplateTesting, "Perfect", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 4){
                            Toast.makeText(this@TemplateTesting, "Keep it up", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this@TemplateTesting, "Try again", Toast.LENGTH_SHORT).show()
                    }
                    Thread.sleep(700)
                    Randomm()
                }
                Rus2.setOnClickListener{
                    val r_true = Rand2(list_True.size)
                    val rand_true = r_true.roll2()
                    if(Rus2.text.toString() == Rus0){
                        if(rand_true == 0){
                            Toast.makeText(this@TemplateTesting, "Well done", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 1){
                            Toast.makeText(this@TemplateTesting, "Great", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 2){
                            Toast.makeText(this@TemplateTesting, "Cool", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 3){
                            Toast.makeText(this@TemplateTesting, "Perfect", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 4){
                            Toast.makeText(this@TemplateTesting, "Keep it up", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this@TemplateTesting, "Try again", Toast.LENGTH_SHORT).show()
                    }
                    Thread.sleep(700)
                    Randomm()
                }
                Rus3.setOnClickListener{
                    val r_true = Rand2(list_True.size)
                    val rand_true = r_true.roll2()
                    if(Rus3.text.toString() == Rus0){
                        if(rand_true == 0){
                            Toast.makeText(this@TemplateTesting, "Well done", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 1){
                            Toast.makeText(this@TemplateTesting, "Great", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 2){
                            Toast.makeText(this@TemplateTesting, "Cool", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 3){
                            Toast.makeText(this@TemplateTesting, "Perfect", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 4){
                            Toast.makeText(this@TemplateTesting, "Keep it up", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this@TemplateTesting, "Try again", Toast.LENGTH_SHORT).show()
                    }
                    Thread.sleep(700)
                    Randomm()
                }
                Rus4.setOnClickListener{
                    val r_true = Rand2(list_True.size)
                    val rand_true = r_true.roll2()
                    if(Rus4.text.toString() == Rus0){
                        if(rand_true == 0){
                            Toast.makeText(this@TemplateTesting, "Well done", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 1){
                            Toast.makeText(this@TemplateTesting, "Great", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 2){
                            Toast.makeText(this@TemplateTesting, "Cool", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 3){
                            Toast.makeText(this@TemplateTesting, "Perfect", Toast.LENGTH_SHORT).show()
                        }
                        if(rand_true == 4){
                            Toast.makeText(this@TemplateTesting, "Keep it up", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this@TemplateTesting, "Try again", Toast.LENGTH_SHORT).show()
                    }
                    Thread.sleep(700)
                    Randomm()
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
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
        databaseRef.child("Result/${email}/test").addListenerForSingleValueEvent(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.value != null){count2 = ("${snapshot.value}")}
                elapsedTime = ((elapsedTime.toInt() + count2.toInt()).toLong())
                databaseRef.child("Result/${email}/test")
                    .setValue(elapsedTime)
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        println(elapsedTime)
        // To execute back press
        super.onBackPressed()
    }
}
class Rand1(private val numSides1: Int) {
    fun roll(): Int {
        return (0..numSides1-1).random()
    }
    fun roll288(): Int {
        return (1..4).random()
    }
}
class Rand2(private val numSides2: Int) {
    fun roll2(): Int {
        return (0..numSides2-1).random()
    }
}