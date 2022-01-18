package com.example.mathquiz

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var num1: Int = 0
    var num2: Int = 0
    var num3: Int = 0
    var num4: Int = 0

    var quizLevel = 1
    var noOfQuestions = 10
    var currentNoOfQuestoins = 9

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        crossId.visibility = View.INVISIBLE
        quizLevel = intent.getIntExtra("EXTRA_LEVEL",1)
        setQuestion()

    }

    fun getRandomValue() {
        if(quizLevel == 1) {

            num1 = (1..100).random()
            num2 = (1..100).random()

        }else if(quizLevel == 2){

            num1 = (10..150).random()
            num2 = (10..200).random()
            num3 = (10..200).random()

        }else{

            num1 = (1..15).random()
            num2 = (1..15).random()
            num3 = (10..200).random()
            num4 = (10..200).random()

        }


    }

    fun setQuestion() {
        getRandomValue()

        if(quizLevel == 1) {



            var question = num1.toString() + " + " + num2.toString() + " = ?"

            questionID.text = question

        }else if(quizLevel == 2){

            var question = num1.toString() + " + " + num2.toString() + " + "+num3.toString()+" = ?"
            questionID.text = question



        }else {

            var question = "( "+num1.toString() + " x " + num2.toString()+" ) + " +num3.toString()+ " + "+num3.toString()+" = ?"
            questionID.text = question

        }

    }

    fun operation(view: View) {

        var realAns:Int = 0

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
                    if(quizLevel == 1){
                          realAns = num1+num2
                    }else if( quizLevel == 2){
                        realAns = num1+num2+num3
                    }else {
                        realAns = (num1*num2)+num3+num4
                    }
                if(ans == realAns){

                    answerID.text = ""
                    if(currentNoOfQuestoins<noOfQuestions) {
                        currentNoOfQuestoins++
                        setQuestion()
                    }else{
                        var homeIntent = Intent(this@MainActivity,Result::class.java)
                        startActivity(homeIntent)
                        finish()

                    }

                }else{
                    crossId.visibility = View.VISIBLE
                    MediaPlayer.create(this,R.raw.wronganssound).start()

                    val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    vibratorService.vibrate(200)


                    Handler().postDelayed({
                        crossId.visibility = View.INVISIBLE

                    }, 2000)





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
