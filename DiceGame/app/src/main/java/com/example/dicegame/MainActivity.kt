package com.example.dicegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var diceText : TextView
    lateinit var diceButton : Button
    lateinit var diceImage : ImageView
    lateinit var sendButton : Button
    lateinit var sendText : EditText

    var randomNumber : Number ?= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceText = findViewById(R.id.diceText)
        diceButton = findViewById(R.id.diceButton)
        diceImage = findViewById(R.id.diceImage)
        sendButton = findViewById(R.id.sendButton)
        sendText = findViewById(R.id.sendText)

        diceText.text = "Dice: "

        diceButton.setOnClickListener {
            dice()
        }

        sendButton.setOnClickListener {
            sendText()
        }
    }

    private fun dice(){
        randomNumber = (1..6).random()
        val drawableResource = when(randomNumber){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            else -> R.drawable.cat
        }

        diceImage.setImageResource(drawableResource)
        diceText.text = "Dice: " + randomNumber

        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

    }

    private fun sendText(){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("yourName", sendText.text.toString())
        intent.putExtra("dice", randomNumber.toString())
        startActivity(intent)
    }
}