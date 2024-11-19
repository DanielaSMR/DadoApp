package com.example.dadoapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var viewBoton : AppCompatButton
    private lateinit var viewNumero : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()

    }

    private fun initListeners(){
        viewBoton.setOnClickListener{
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        viewNumero.text = diceRoll.toString()
    }

    private fun initComponents(){
        viewBoton = findViewById(R.id.boton)
        viewNumero = findViewById(R.id.numeroRoll)
    }

}

class Dice(val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}