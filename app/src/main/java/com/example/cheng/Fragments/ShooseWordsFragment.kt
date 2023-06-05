package com.example.cheng.Fragments

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cheng.*

class ShooseWordsFragment: AppCompatActivity() {
    lateinit var eng1: Button
    lateinit var rus1: Button
    lateinit var rus2: Button
    lateinit var rus3: Button
    lateinit var rus4: Button
    var rus0 = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoosewords)

        val btn = findViewById<Button>(R.id.buttonBack4)
        btn.setOnClickListener {
            onBackPressed()
        }
        fun Randomm() {
            val rand = Rand1(enguser.size)
            val RandResult = rand.roll()
            val R288 = rand.roll288()

            eng1.text = enguser[RandResult]
            rus0 = rususer[RandResult]

            rus1.text = rususer[rand.roll()]

            rus2.text = rususer[rand.roll()]

            rus3.text = rususer[rand.roll()]

            rus4.text = rususer[rand.roll()]

            if(R288 == 1){
                rus1.text = rususer[RandResult]

            }else if(R288 == 2){
                rus2.text = rususer[RandResult]

            }else if(R288 == 3){
                rus3.text = rususer[RandResult]

            }else if(R288 == 4){
                rus4.text = rususer[RandResult]

            }
            if(rus1.text == rus3.text|| rus1.text == rus2.text || rus1.text == rus4.text){
                rus1.text = rususer[rand.roll()]
                rus1.text = rususer[rand.roll()]
                rus1.text = rususer[rand.roll()]
                rus1.text = rususer[rand.roll()]

            }
            if(rus2 == rus1|| rus2.text == rus3.text || rus2.text == rus4.text){
                rus2.text = rususer[rand.roll()]
                rus2.text = rususer[rand.roll()]
                rus2.text = rususer[rand.roll()]
                rus2.text = rususer[rand.roll()]

            }
            if(rus3.text == rus1.text || rus3.text == rus2.text || rus3.text == rus4.text){
                rus3.text = rususer[rand.roll()]
                rus3.text = rususer[rand.roll()]
                rus3.text = rususer[rand.roll()]
                rus3.text = rususer[rand.roll()]

            }
            if(rus4.text == rus1.text || rus4.text == rus2.text || rus4.text == rus3.text){
                rus4.text = rususer[rand.roll()]
                rus4.text = rususer[rand.roll()]
                rus4.text = rususer[rand.roll()]
                rus4.text = rususer[rand.roll()]
            }

        }

        eng1 = findViewById(R.id.eng1)
        rus1 = findViewById(R.id.rus1)
        rus2 = findViewById(R.id.rus2)
        rus3 = findViewById(R.id.rus3)
        rus4 = findViewById(R.id.rus4)

        Randomm()

        rus1.setOnClickListener{
            val r_true = Rand2(list_True.size)
            val rand_true = r_true.roll2()
            if(rus1.text.toString() == rus0){
                if(rand_true == 0){
                    Toast.makeText(this@ShooseWordsFragment, "Well done", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 1){
                    Toast.makeText(this@ShooseWordsFragment, "Great", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 2){
                    Toast.makeText(this@ShooseWordsFragment, "Cool", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 3){
                    Toast.makeText(this@ShooseWordsFragment, "Perfect", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 4){
                    Toast.makeText(this@ShooseWordsFragment, "Keep it up", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@ShooseWordsFragment, "Try again", Toast.LENGTH_SHORT).show()
            }
            Thread.sleep(700)
            Randomm()
        }
        rus2.setOnClickListener{
            val r_true = Rand2(list_True.size)
            val rand_true = r_true.roll2()
            if(rus2.text.toString() == rus0){
                if(rand_true == 0){
                    Toast.makeText(this@ShooseWordsFragment, "Well done", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 1){
                    Toast.makeText(this@ShooseWordsFragment, "Great", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 2){
                    Toast.makeText(this@ShooseWordsFragment, "Cool", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 3){
                    Toast.makeText(this@ShooseWordsFragment, "Perfect", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 4){
                    Toast.makeText(this@ShooseWordsFragment, "Keep it up", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@ShooseWordsFragment, "Try again", Toast.LENGTH_SHORT).show()
            }
            Thread.sleep(700)
            Randomm()
        }
        rus3.setOnClickListener{
            val r_true = Rand2(list_True.size)
            val rand_true = r_true.roll2()
            if(rus3.text.toString() == rus0){
                if(rand_true == 0){
                    Toast.makeText(this@ShooseWordsFragment, "Well done", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 1){
                    Toast.makeText(this@ShooseWordsFragment, "Great", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 2){
                    Toast.makeText(this@ShooseWordsFragment, "Cool", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 3){
                    Toast.makeText(this@ShooseWordsFragment, "Perfect", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 4){
                    Toast.makeText(this@ShooseWordsFragment, "Keep it up", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@ShooseWordsFragment, "Try again", Toast.LENGTH_SHORT).show()
            }
            Thread.sleep(700)
            Randomm()
        }
        rus4.setOnClickListener{
            val r_true = Rand2(list_True.size)
            val rand_true = r_true.roll2()
            if(rus4.text.toString() == rus0){
                if(rand_true == 0){
                    Toast.makeText(this@ShooseWordsFragment, "Well done", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 1){
                    Toast.makeText(this@ShooseWordsFragment, "Great", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 2){
                    Toast.makeText(this@ShooseWordsFragment, "Cool", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 3){
                    Toast.makeText(this@ShooseWordsFragment, "Perfect", Toast.LENGTH_SHORT).show()
                }
                if(rand_true == 4){
                    Toast.makeText(this@ShooseWordsFragment, "Keep it up", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@ShooseWordsFragment, "Try again", Toast.LENGTH_SHORT).show()
            }
            Thread.sleep(700)
            Randomm()
        }
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