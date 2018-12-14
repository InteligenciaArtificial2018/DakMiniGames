package com.example.dakaro.dakminigames

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_puntaje.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val mp = MediaPlayer.create(this, R.raw.home1)
        // val roar = MediaPlayer.create(this, R.raw.sora_no_method_noel_roar)
        mp.start()
        btnIniciar.setOnClickListener {
            mp.stop()
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
        btnAcercaDe.setOnClickListener {
            mp.stop()
            val intent = Intent(this, AcercaDe::class.java)
            startActivity(intent)
        }
    }
}
