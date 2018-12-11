package com.example.dakaro.dakminigames

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        var animatorX : ObjectAnimator
        val animatorY : ObjectAnimator
        val animatorSet : AnimatorSet
        val mp = MediaPlayer.create(this, R.raw.melodyloops_the_first_light)
        mp.start()

        /*
        val btnAcercaDe = findViewById<Button>(R.id.btnAcercaDe)
        val btnCompartir = findViewById<Button>(R.id.btnCompartir)
        */
        /*
        fun fadeIn(view: View, duration: Long): Completable {
            val animationSubject = CompletableSubject.create()
            return animationSubject.doOnSubscribe {
                ViewCompat.animate(view)
                    .setDuration(duration)
                    .alpha(1f)
                    .withEndAction {
                        animationSubject.onComplete()
                    }
            }
        }
        */
        btnIniciar.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}
