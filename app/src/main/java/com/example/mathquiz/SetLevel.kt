package com.example.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_set_level.*

class SetLevel : AppCompatActivity() {
    var level:Int = 1
    var noOfQuestions:Int = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_level)


       levelSeekBar.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress:Int, fromUser: Boolean){
                level = progress
            }

           override fun onStartTrackingTouch(p0: SeekBar?) {

           }

           override fun onStopTrackingTouch(p0: SeekBar?) {

           }


        }
       )




    }



    fun buttonClick(view:View){

        val homeIntent = Intent(this@SetLevel,MainActivity::class.java)
         homeIntent.putExtra("EXTRA_LEVEL",level)

        startActivity(homeIntent)
        finish()
    }
}