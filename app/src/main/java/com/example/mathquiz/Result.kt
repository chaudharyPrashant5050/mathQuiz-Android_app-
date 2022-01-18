package com.example.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlin.system.exitProcess

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }

    fun playAgain(view:View){
        var homeIntent = Intent(this@Result,MainActivity::class.java)
        startActivity(homeIntent)
        finish()
    }

    fun setLevel(view:View){

        startActivity(Intent(this@Result,SetLevel::class.java))
        finish()
    }


    fun quitApp(view:View){

        val exitDialog = AlertDialog.Builder(this).setTitle(
            "Exit"
        ).setMessage("Do you want to Exit?"
        ).setPositiveButton("Yes"){ _,_ ->
            this@Result.finish()
            exitProcess(0)

        }.setNegativeButton("No"){_,_ ->

            // do nothing
        }.create()



        exitDialog.show()




    }

}