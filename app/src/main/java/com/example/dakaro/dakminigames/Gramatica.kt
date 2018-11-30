package com.example.dakaro.dakminigames

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_gramatica.*
import java.util.Random

// no se que pedo pero me corrigio un error en "respuesta"
@Suppress("NAME_SHADOWING")
class Gramatica : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gramatica)

        val tvPregunta = findViewById<TextView>(R.id.tvPregunta)
        val tvPuntaje = findViewById<TextView>(R.id.tvPuntaje)
        val btnRespuesta1 = findViewById<Button>(R.id.btnRespuesta1)
        var respuestita: String
        val respuestitasRepetiditas = mutableListOf<Int>() // lista mutable que nos da la posibilidad de ir rellenando la lista a medida que lo necesitemos
        val respuestitasCorrectitas = mutableListOf<String>()


        val pregunta1 = PreguntasGramatica(1, "Espero que lo ____ escrito bien", "haya", "alla", "haiga", "haya")
        val pregunta2 = PreguntasGramatica(2, "La tierra tiene muchas ____", "capas", "capaz", "capases", "capas")
        val pregunta3 = PreguntasGramatica(3, "___ no puedas mas, me llamas", "cuándo", "cuando", "quando", "cuando")

        respuestitasCorrectitas.add(pregunta1.respuestaCorrecta)
        respuestitasCorrectitas.add(pregunta2.respuestaCorrecta)
        respuestitasCorrectitas.add(pregunta3.respuestaCorrecta)

        respuestitasRepetiditas.clear()

        fun generarAleatorio(): Int {
            val random = Random()
            val preguntaAleatoria = random.nextInt(4)
            if (preguntaAleatoria == 0){
                generarAleatorio()
            }
            println("")
            println("")
            println(preguntaAleatoria)
            println("")
            println("")

            // revisa cada item dentro de la lista y evalua: si no existe dentro de la lista entonces
            // esa pregunta no esta repetida y se mostrara en la app.
            for (item in respuestitasRepetiditas) {
                if (item != preguntaAleatoria){
                    println("")
                    println("")
                    println("repetideichon")
                    println("")
                    println("")
                    respuestitasRepetiditas.add(preguntaAleatoria)
                    return preguntaAleatoria
                }else{
                    println("ni maiz xD")
                    generarAleatorio()
                }
            }

            return preguntaAleatoria
        }

        fun generarPregunta(){

            when(generarAleatorio()){
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

                // si el texto del boton presionado es igual al texto de la respuesta correcta
                // se sumara un puntaje y continuara jugando.
            }
        }

        tvPuntaje.text = 0.toString()

        fun evaluarRespuesta(respuesta: String){

            val respuesta = respuesta
            var myNum = 0
            /*
            for (item in respuestitasCorrectitas) {
                if (item == respuesta){
                    try {
                        myNum = Integer.parseInt(tvPuntaje.text.toString())
                        myNum += 2
                        tvPuntaje.text = myNum.toString()
                        generarPregunta()
                    } catch (nfe: NumberFormatException) {
                        println("no se pudo convertir $nfe")
                    }
                }
            }
            val intent = Intent(this, Puntaje::class.java)
            startActivity(intent)
            */
            if(respuesta == pregunta1.respuestaCorrecta){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2
                tvPuntaje.text = "puntaje: $myNum "
                generarPregunta()
            }else if (respuesta == pregunta2.respuestaCorrecta){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2
                tvPuntaje.text = "puntaje: $myNum "
                generarPregunta()
            }else if (respuesta == pregunta3.respuestaCorrecta){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2
                tvPuntaje.text = "puntaje: $myNum "
                generarPregunta()
            }else{
                tvPuntaje.text = 0.toString()
                respuestitasRepetiditas.clear()
                val intent = Intent(this, Puntaje::class.java)
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
