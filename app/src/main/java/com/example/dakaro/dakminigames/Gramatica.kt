package com.example.dakaro.dakminigames

import android.media.MediaPlayer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.example.dakaro.dakminigames.data.DakMiniGamesDatabase
import com.example.dakaro.dakminigames.data.TGramatica
import kotlinx.android.synthetic.main.activity_gramatica.*
import java.util.Random

// no se pero me corrigio un error en "respuesta"
@Suppress("NAME_SHADOWING")
class Gramatica : AppCompatActivity() {

    private var dakMiniGamesDatabase: DakMiniGamesDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gramatica)

        dakMiniGamesDatabase = DakMiniGamesDatabase.getInstance(this)

        val tvPregunta = findViewById<TextView>(R.id.tvPregunta)
        val tvPuntaje = findViewById<TextView>(R.id.tvPuntaje)
        val btnRespuesta1 = findViewById<Button>(R.id.btnRespuesta1)
        var respuestita: String
        val respuestitasRepetiditas = mutableListOf<Int>() // lista mutable que nos da la posibilidad de ir rellenando la lista a medida que lo necesitemos
        val respuestitasCorrectitas = mutableListOf<String>()
        val successito = findViewById<LottieAnimationView>(R.id.successito)

        val tarea = TGramatica("Espero que lo ____ escrito bien", "haya", "alla", "haiga", "haya")
        tarea.id = intent.getIntExtra("id", 0)
        dakMiniGamesDatabase?.getTGramaticaDao()?.saveTGramatica(tarea)

        dakMiniGamesDatabase?.getTGramaticaDao()?.updateTGramatica(tarea)
        val tarea2 = TGramatica("La tierra tiene muchas ____", "capas", "capaz", "capases", "capas")
        tarea2.id = intent.getIntExtra("id", 1)
        dakMiniGamesDatabase?.getTGramaticaDao()?.saveTGramatica(tarea2)
        dakMiniGamesDatabase?.getTGramaticaDao()?.updateTGramatica(tarea2)
        val tarea3 = TGramatica("___ no puedas mas, me llamas", "cuándo", "cuando", "quando", "cuando")
        tarea3.id = intent.getIntExtra("id", 2)
        dakMiniGamesDatabase?.getTGramaticaDao()?.saveTGramatica(tarea3)
        dakMiniGamesDatabase?.getTGramaticaDao()?.updateTGramatica(tarea3)


        val pregunta1 = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticaPregunta(0).toString()
        val pregunta2 = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticaPregunta(1).toString()
        val pregunta3 = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticaPregunta(2).toString()

        println("")
        println("")
        println(pregunta1)
        println("")
        println("")



        respuestitasCorrectitas.add(dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuestaCorrecta(0).toString())
        respuestitasCorrectitas.add(dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuestaCorrecta(1).toString())
        respuestitasCorrectitas.add(dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuestaCorrecta(2).toString())

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
                0 ->{
                    generarPregunta()
                }

                1 ->{
                    tvPregunta.text = pregunta1
                    btnRespuesta1.text = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuesta1(0).toString()
                    btnRespuesta2.text = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuesta2(0).toString()
                    btnRespuesta3.text = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuesta3(0).toString()
                }

                2 ->{
                    tvPregunta.text = pregunta2
                    btnRespuesta1.text = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuesta1(1).toString()
                    btnRespuesta2.text = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuesta2(1).toString()
                    btnRespuesta3.text = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuesta3(1).toString()
                }

                3 ->{
                    tvPregunta.text = pregunta3
                    btnRespuesta1.text = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuesta1(2).toString()
                    btnRespuesta2.text = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuesta2(2).toString()
                    btnRespuesta3.text = dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuesta3(2).toString()
                }

                // si el texto del boton presionado es igual al texto de la respuesta correcta
                // se sumara un puntaje y continuara jugando.
            }
        }

        tvPuntaje.text = 0.toString()

        fun evaluarRespuesta(respuesta: String){

            val respuesta = ""
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
            if(respuesta == dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuestaCorrecta(1).toString()){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2
                successito.visibility = View.VISIBLE
                successito.loop(true)
                successito.playAnimation()
                successito.loop(false)
                successito.duration
                for (x in 1..1000000)
                tvPuntaje.text = myNum.toString()
                generarPregunta()
                successito.visibility = View.GONE
            }else if (respuesta == dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuestaCorrecta(2).toString()){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2
                successito.visibility = View.VISIBLE
                successito.playAnimation()
                for (x in 1..1000000)
                tvPuntaje.text = myNum.toString()
                generarPregunta()
                successito.visibility = View.GONE
            }else if (respuesta == dakMiniGamesDatabase?.getTGramaticaDao()?.getTGramaticarespuestaCorrecta(3).toString()){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2
                successito.visibility = View.VISIBLE
                successito.playAnimation()
                for (x in 1..1000000)
                tvPuntaje.text = myNum.toString()
                generarPregunta()
                successito.visibility = View.GONE

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
