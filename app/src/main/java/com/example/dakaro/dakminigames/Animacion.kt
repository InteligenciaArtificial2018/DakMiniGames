package com.example.dakaro.dakminigames

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint

class Animacion(animacion: ObjectAnimator, private var objetito: String) {

    private var animacioncita = animacion
    val animatorSet : AnimatorSet? = null
    @SuppressLint("ObjectAnimatorBinding")
    fun animacion(){
        when(animacioncita.toString()){
            "x" -> {
                animacioncita = ObjectAnimator.ofFloat(objetito, "x", 500f)
                animacioncita.duration = 1000
                if (animatorSet != null) {
                    animatorSet.play(animacioncita)
                    animatorSet.start()
                }
            }
        }
    }
}