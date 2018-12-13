package com.example.dakaro.dakminigames

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_puntaje.*

class Puntaje: AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_puntaje)

        var tvPuntaje2 = findViewById<TextView>(R.id.tvPuntos)

        val bundle = intent.extras
        val puntos = bundle.getString("puntos")!!
        val ganador = bundle.getString("ganador")!!

        if (puntos == 100.toString()){
            tvPuntaje2.text = puntos
            tvRecord.text = ganador
        }else{
            tvPuntaje2.text = puntos
            if (Integer.parseInt(puntos) == 0){
                tvRecord.text = "¡Que bárbaro!"
            }else if (Integer.parseInt(puntos) in 1..29){

            }

        }


        btnSalir.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnRegresar.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}
