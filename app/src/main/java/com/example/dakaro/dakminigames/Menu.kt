package com.example.dakaro.dakminigames

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnGramatica = findViewById<Button>(R.id.btnGramatica)

        btnGramatica.setOnClickListener {
            val intent = Intent(this, Gramatica::class.java)
            startActivity(intent)
        }
        btnTraduccion.setOnClickListener{
            val intent = Intent(this, Traduccion::class.java)
            startActivity(intent)
        }
    }
}
