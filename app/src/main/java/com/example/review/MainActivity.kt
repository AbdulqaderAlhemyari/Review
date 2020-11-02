package com.example.review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private lateinit var redButton: Button
private lateinit var greenButton: Button
private lateinit var blueButton: Button
private lateinit var fTV: TextView

class MainActivity : AppCompatActivity() ,ColorFragment.Callbacks {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redButton= findViewById(R.id.btn_red)
        greenButton= findViewById(R.id.btn_green)
        blueButton= findViewById(R.id.btn_blue)
        fTV= findViewById(R.id.text_activity)

        redButton.setOnClickListener {
            sendColor("Red")
        }
        greenButton.setOnClickListener {
            sendColor("Green")
        }
        blueButton.setOnClickListener {
            sendColor("Blue")
        }
    }

    fun sendColor(color:String)
    {
        var currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_Container)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_Container,ColorFragment.newInstance(color))
            .commit()
    }

    override fun onButtonClick(fm: String) {
        fTV.setText(fm)
    }
}
