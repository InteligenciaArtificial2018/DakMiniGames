package com.example.dakaro.dakminigames

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
@Suppress("NAME_SHADOWING")
class Antonimos : AppCompatActivity() {
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



        val pregunta1 = PreguntasGramatica(1, "Espero que lo ____ escrito bien", "haya", "alla", "haiga", "haya")
        val pregunta2 = PreguntasGramatica(2, "La tierra tiene muchas ____", "capas", "capaz", "capases", "capas")
        val pregunta3 = PreguntasGramatica(3, "___ no puedas mas, me llamas", "cuándo", "cuando", "quando", "cuando")
        val pregunta4 =
            PreguntasGramatica(4, "No se ____ así", "hiso", "izo", "hizo", "hizo")
        val pregunta5 = PreguntasGramatica(5, "____ muchas quejas por el problema", "habían", "había", "abia", "había")

        respuestitasCorrectitas.add(pregunta1.respuestaCorrecta)
        respuestitasCorrectitas.add(pregunta2.respuestaCorrecta)
        respuestitasCorrectitas.add(pregunta3.respuestaCorrecta)
        respuestitasCorrectitas.add(pregunta4.respuestaCorrecta)
        respuestitasCorrectitas.add(pregunta5.respuestaCorrecta)

        preguntasRepetiditas.clear()

        fun generarAleatorio(): Int {

            val random = Random()
            val preguntaAleatoria = random.nextInt(4)
            if (preguntaAleatoria == 0){
                generarAleatorio()
            }else{
                // revisa cada item dentro de la lista y evalua: si no existe dentro de la lista entonces
                // esa pregunta no esta repetida y se mostrara en la app.
                when (preguntaAleatoria) {
                    0 -> generarAleatorio()

                    1 -> {
                        if (preguntasRepetiditas.none{it == pregunta1.pregunta}) {
                            preguntasRepetiditas.add(pregunta1.pregunta)
                            return preguntaAleatoria
                        }
                    }
                    2 -> {
                        if (preguntasRepetiditas.none{it == pregunta2.pregunta}) {
                            preguntasRepetiditas.add(pregunta2.pregunta)
                            return preguntaAleatoria
                        }
                    }
                    3 -> {
                        if (preguntasRepetiditas.none{it == pregunta3.pregunta}) {
                            preguntasRepetiditas.add(pregunta3.pregunta)
                            return preguntaAleatoria
                        }
                    }
                    4 -> {
                        if (preguntasRepetiditas.none{it == pregunta4.pregunta}) {
                            preguntasRepetiditas.add(pregunta4.pregunta)
                            return preguntaAleatoria
                        }
                    }
                    5 -> {
                        if (preguntasRepetiditas.none{it == pregunta5.pregunta}) {
                            preguntasRepetiditas.add(pregunta5.pregunta)
                            return preguntaAleatoria
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

                // si el texto del boton presionado es igual al texto de la respuesta correcta
                // se sumara un puntaje y continuara jugando.
            }
        }

        tvPuntaje.text = 0.toString()

        fun evaluarRespuesta(respuesta: String){

            var myNum = 0

            var duration = Integer.parseInt(successito.duration.toString())
            var i = 0
            if(respuesta == pregunta1.respuestaCorrecta){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2
                successito.visibility = View.VISIBLE
                successito.playAnimation()
                TimeUnit.MILLISECONDS.sleep(1466L)

                tvPuntaje.text = myNum.toString()
                generarPregunta()
            }else if (respuesta == pregunta2.respuestaCorrecta){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2
                successito.visibility = View.VISIBLE
                successito.playAnimation()
                TimeUnit.MILLISECONDS.sleep(1466L)


                tvPuntaje.text = myNum.toString()
                generarPregunta()

            }else if (respuesta == pregunta3.respuestaCorrecta){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2
                successito.visibility = View.VISIBLE
                successito.playAnimation()
                TimeUnit.MILLISECONDS.sleep(1466L)

                tvPuntaje.text = myNum.toString()
                
                generarPregunta()

            }else{
                preguntasRepetiditas.clear()
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                val intent = Intent(this, Puntaje::class.java)
                intent.putExtra("puntos", myNum.toString())
                startActivity(intent)
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
