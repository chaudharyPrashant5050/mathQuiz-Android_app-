package com.example.mathquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var num1: Int = 0
    var num2: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setQuestion()
    }

    fun getRandomValue() {
        num1 = (1..100).random()
        num2 = (1..100).random()

    }

    fun setQuestion() {

        getRandomValue()
        var question = num1.toString() + " + " + num2.toString() + " = ?"

        questionID.text = question


    }

    fun operation(view: View) {

        if (view is Button) {
            if (view.text == "AC") {
                answerID.text = ""
            } else if (view.text == "◀") {




                val length = answerID.length()
                if (length > 0)
                    answerID.text = answerID.text.subSequence(0, length - 1)
            }else if(view.text == "SUBMIT"){
                if(answerID.text != ""){
                var ans:Int =  answerID.text.toString().toInt()
                var realAns:Int = num1+num2
                if(ans == realAns){
                    crossId.visibility = View.INVISIBLE
                    answerID.text = ""
                    setQuestion()

                }else{
                    crossId.visibility = View.VISIBLE

                }
                }else{

                    Toast.makeText(this,"Enter Number",Toast.LENGTH_SHORT).show()

                }
            }


        }
    }




        fun numberOperation(view: View) {

            if(view is Button) {

                answerID.append(view.text)
            }


        }




    }
