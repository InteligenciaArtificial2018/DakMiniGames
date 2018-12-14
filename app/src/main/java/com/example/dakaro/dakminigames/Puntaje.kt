package com.example.dakaro.dakminigames

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_puntaje.*

class Puntaje: AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_puntaje)

        val tvPuntaje2 = findViewById<TextView>(R.id.tvPuntos)
        val succesito = findViewById<LottieAnimationView>(R.id.successito)
        val mp2 = MediaPlayer.create(this, R.raw.home1)

        val bundle = intent.extras
        val puntos = bundle?.getString("puntos")!!
        val ganador = bundle?.getString("ganador")

        if (puntos == 100.toString()){
            mp2.start()
            tvPuntaje2.text = puntos
            tvRecord.text = ganador
            succesito.visibility = View.VISIBLE
            succesito.loop(true)
            succesito.playAnimation()
        }else{
            tvPuntaje2.text = puntos
            succesito.visibility = View.INVISIBLE
            when {
                Integer.parseInt(puntos) == 0 -> tvRecord.text = "¡Que bárbaro!"
                Integer.parseInt(puntos) in 1..29 -> tvRecord.text = "¡Practica un poco mas!"
                Integer.parseInt(puntos) in 29..51 -> tvRecord.text = "¡Nada mal!"
                Integer.parseInt(puntos) in 52..76 -> tvRecord.text = "¡Muy bien!"
                Integer.parseInt(puntos) in 77..99 -> tvRecord.text = "¡Caaaasi!"
            }
        }

        btnSalir.setOnClickListener {
            mp2.stop()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnRegresar.setOnClickListener {
            mp2.stop()
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}
