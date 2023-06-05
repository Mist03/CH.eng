package com.example.cheng.Fragments

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cheng.*

class WritingWordsFragment: AppCompatActivity() {
    lateinit var rus: TextView
    lateinit var eng: EditText
    var eng1 = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writingwords)

        val btn = findViewById<Button>(R.id.buttonBack5)
        btn.setOnClickListener {
            onBackPressed()
        }
        fun Randomm() {
            val rand = Rand(enguser.size)
            val RandResult = rand.roll()

            rus.text = rususer[RandResult]
            eng1 = enguser[RandResult]
        }
        rus = findViewById(R.id.eng)
        eng = findViewById(R.id.rus)
        Randomm()
        val CheckButton = findViewById<Button>(R.id.button4)
        CheckButton.setOnClickListener {
            val r_true = Rand3(list_True.size)
            val rand_true = r_true.roll2()
            if (eng.text.toString().lowercase().replace("  "," ").trimEnd() == eng1) {
                if(rand_true == 0){
                    Toast.makeText(this@WritingWordsFragment, "Well done", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 1){
                    Toast.makeText(this@WritingWordsFragment, "Great", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 2){
                    Toast.makeText(this@WritingWordsFragment, "Cool", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 3){
                    Toast.makeText(this@WritingWordsFragment, "Perfect", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 4){
                    Toast.makeText(this@WritingWordsFragment, "Keep it up", Toast.LENGTH_SHORT).show()
                }
            }
            if (eng.text.toString().lowercase().replace("  "," ").trimEnd() != eng1) {
                Toast.makeText(this@WritingWordsFragment, "Try again", Toast.LENGTH_SHORT).show()
            }
            Randomm()
            eng.text.clear()
        }

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