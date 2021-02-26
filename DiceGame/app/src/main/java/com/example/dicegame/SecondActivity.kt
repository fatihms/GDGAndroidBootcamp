package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var helloText : TextView
    lateinit var yourDiceText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        helloText = findViewById(R.id.helloText)
        yourDiceText = findViewById(R.id.yourDiceText)

        val getYourName = intent.getStringExtra("yourName")
        var getDice = intent.getStringExtra("dice")

        helloText.setText("Hello, " + getYourName)
        yourDiceText.setText("Your number: " + getDice)
    }


}