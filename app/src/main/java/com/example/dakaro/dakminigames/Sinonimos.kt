package com.example.dakaro.dakminigames

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_gramatica.*
import java.util.Random
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

// no se que pedo pero me corrigio un error en "respuesta"
@SuppressLint("Registered")
@Suppress("NAME_SHADOWING")
class Sinonimos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gramatica)

        val tvPregunta = findViewById<TextView>(R.id.tvPregunta)
        val tvPuntaje = findViewById<TextView>(R.id.tvPuntaje)
        val btnRespuesta1 = findViewById<Button>(R.id.btnRespuesta1)
        var respuestita: String
        val preguntasRepetiditas = mutableListOf<String>() // lista mutable que nos da la posibilidad de ir rellenando la lista a medida que lo necesitemos
        val respuestitasCorrectitas = mutableListOf<String>()
        val successito = findViewById<LottieAnimationView>(R.id.successito)



        val pregunta1 = PreguntasSinonimos(1, "Concurrir", "Apreciar", "Asistir", "Despegar", "Asistir", true)
        val pregunta2 = PreguntasSinonimos(2, "Caminar", "Avisar", "Deambular", "Descansar", "Deambular", true)
        val pregunta3 = PreguntasSinonimos(3, "Causa", "Procedimiento", "Motivo", "Meta", "Motivo", true)
        val pregunta4 = PreguntasSinonimos(4, "Corpóreo", "Físico", "Falaz", "Abstracto", "Físico", true)
        val pregunta5 = PreguntasSinonimos(5, "Amparar", "Repetir", "Proteger", "Incluir", "Proteger", true)
        val pregunta6 = PreguntasSinonimos(6, "Fugitivo", "Desertor", "Moderado", "Confiado", "Desertor", true)
        val pregunta7 = PreguntasSinonimos(7, "Impune", "Insensato", "Imprevisto", "Excento", "Excento", true)
        val pregunta8 = PreguntasSinonimos(8, "Opulento", "Patético", "Lujoso", "Estridente", "Lujoso", true)
        val pregunta9 = PreguntasSinonimos(9, "Afectuoso", "Efusivo", "Útil", "Prosaico", "Efusivo", true)
        val pregunta10 = PreguntasSinonimos(10, "Lúgubre", "Sombrío", "Alborozado", "Delirante", "Sombrío", true)


        preguntasRepetiditas.clear()
        var preguntaAleatoria = 0
        val random = Random()
        fun generarAleatorio(): Int {
            preguntaAleatoria = random.nextInt(10)
            if (preguntaAleatoria == 0){
                generarAleatorio()
            }else{
                // revisa cada item dentro de la lista y evalua: si no existe dentro de la lista entonces
                // esa pregunta no esta repetida y se mostrara en la app.
                when (preguntaAleatoria) {
                    0 -> generarAleatorio()

                    1 -> {
                        if (pregunta1.activa == true) {
                            pregunta1.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                    2 -> {
                        if (pregunta2.activa == true) {
                            pregunta2.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                    3 -> {
                        if (pregunta3.activa == true) {
                            pregunta3.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                    4 -> {
                        if (pregunta4.activa == true) {
                            pregunta4.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                    5 -> {
                        if (pregunta5.activa == true) {
                            pregunta5.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                    6 -> {
                        if (pregunta6.activa == true) {
                            pregunta6.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                    7 -> {
                        if (pregunta7.activa == true) {
                            pregunta7.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                    8 -> {
                        if (pregunta8.activa == true) {
                            pregunta8.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                    9 -> {
                        if (pregunta9.activa == true) {
                            pregunta9.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                    10 -> {
                        if (pregunta10.activa == true) {
                            pregunta10.activa = false
                            return preguntaAleatoria
                        }
                        else{
                            generarAleatorio()
                        }
                    }
                }
            }
            return preguntaAleatoria
        }

        fun generarPregunta(){

            when(generarAleatorio()){
                0 ->{
                    generarPregunta()
                }

                1 ->{
                    tvPregunta.text = pregunta1.pregunta
                    btnRespuesta1.text = pregunta1.respuesta1
                    btnRespuesta2.text = pregunta1.respuesta2
                    btnRespuesta3.text = pregunta1.respuesta3
                }

                2 ->{
                    tvPregunta.text = pregunta2.pregunta
                    btnRespuesta1.text = pregunta2.respuesta1
                    btnRespuesta2.text = pregunta2.respuesta2
                    btnRespuesta3.text = pregunta2.respuesta3
                }

                3 ->{
                    tvPregunta.text = pregunta3.pregunta
                    btnRespuesta1.text = pregunta3.respuesta1
                    btnRespuesta2.text = pregunta3.respuesta2
                    btnRespuesta3.text = pregunta3.respuesta3
                }

                4 ->{
                    tvPregunta.text = pregunta4.pregunta
                    btnRespuesta1.text = pregunta4.respuesta1
                    btnRespuesta2.text = pregunta4.respuesta2
                    btnRespuesta3.text = pregunta4.respuesta3
                }

                5 ->{
                    tvPregunta.text = pregunta5.pregunta
                    btnRespuesta1.text = pregunta5.respuesta1
                    btnRespuesta2.text = pregunta5.respuesta2
                    btnRespuesta3.text = pregunta5.respuesta3
                }
                6 ->{
                    tvPregunta.text = pregunta6.pregunta
                    btnRespuesta1.text = pregunta6.respuesta1
                    btnRespuesta2.text = pregunta6.respuesta2
                    btnRespuesta3.text = pregunta6.respuesta3
                }
                7 ->{
                    tvPregunta.text = pregunta7.pregunta
                    btnRespuesta1.text = pregunta7.respuesta1
                    btnRespuesta2.text = pregunta7.respuesta2
                    btnRespuesta3.text = pregunta7.respuesta3
                }
                8 ->{
                    tvPregunta.text = pregunta8.pregunta
                    btnRespuesta1.text = pregunta8.respuesta1
                    btnRespuesta2.text = pregunta8.respuesta2
                    btnRespuesta3.text = pregunta8.respuesta3
                }
                9 ->{
                    tvPregunta.text = pregunta9.pregunta
                    btnRespuesta1.text = pregunta9.respuesta1
                    btnRespuesta2.text = pregunta9.respuesta2
                    btnRespuesta3.text = pregunta9.respuesta3
                }
                10 ->{
                    tvPregunta.text = pregunta10.pregunta
                    btnRespuesta1.text = pregunta10.respuesta1
                    btnRespuesta2.text = pregunta10.respuesta2
                    btnRespuesta3.text = pregunta10.respuesta3
                }

                // si el texto del boton presionado es igual al texto de la respuesta correcta
                // se sumara un puntaje y continuara jugando.
            }
        }

        tvPuntaje.text = 0.toString()

        fun evaluarRespuesta(respuesta: String){

            var myNum = 0

            var duration = Integer.parseInt(successito.duration.toString())
            var i = 0
            when (respuesta) {
                pregunta1.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()

                    tvPuntaje.text = myNum.toString()
                    generarPregunta()
                }
                pregunta2.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()


                    tvPuntaje.text = myNum.toString()
                    generarPregunta()

                }
                pregunta3.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()

                    tvPuntaje.text = myNum.toString()

                    generarPregunta()

                }
                pregunta4.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()

                    tvPuntaje.text = myNum.toString()

                    generarPregunta()

                }
                pregunta5.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()

                    tvPuntaje.text = myNum.toString()

                    generarPregunta()

                }
                pregunta6.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()

                    tvPuntaje.text = myNum.toString()

                    generarPregunta()

                }
                pregunta7.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()

                    tvPuntaje.text = myNum.toString()

                    generarPregunta()

                }
                pregunta8.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()

                    tvPuntaje.text = myNum.toString()

                    generarPregunta()

                }
                pregunta9.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()

                    tvPuntaje.text = myNum.toString()

                    generarPregunta()

                }
                pregunta10.respuestaCorrecta -> {
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 2
                    successito.playAnimation()

                    tvPuntaje.text = myNum.toString()

                    generarPregunta()

                }
                else -> {
                    preguntasRepetiditas.clear()
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    val intent = Intent(this, Puntaje::class.java)
                    intent.putExtra("puntos", myNum.toString())
                    startActivity(intent)
                }
            }
        }

        // aqui viene lo chidooo!
        generarPregunta()

        btnRespuesta1.setOnClickListener {
            respuestita = btnRespuesta1.text.toString()
            evaluarRespuesta(respuestita)
        }
        btnRespuesta2.setOnClickListener {
            respuestita = btnRespuesta2.text.toString()
            evaluarRespuesta(respuestita)
        }
        btnRespuesta3.setOnClickListener {
            respuestita = btnRespuesta3.text.toString()
            evaluarRespuesta(respuestita)
        }
    }

}
