package com.example.dakaro.dakminigames

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.example.dakaro.dakminigames.data.DakMiniGamesDatabase
import com.example.dakaro.dakminigames.data.TTraduccion
import kotlinx.android.synthetic.main.activity_gramatica.*
import java.util.*
import kotlin.collections.ArrayList

class traduccion : AppCompatActivity() {
    private var dakDatabase: DakMiniGamesDatabase? = null
    var traduccionList: List<TTraduccion>? = ArrayList()
    var otralista: List<TTraduccion> = ArrayList()
    var listarepetidas = mutableListOf<Int>()
    var ipuntaje = -5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gramatica)

        //Conexión con la base de datos
        dakDatabase = DakMiniGamesDatabase.getInstance(this)


        val tvPregunta = findViewById<TextView>(R.id.tvPregunta)
        val tvPuntaje = findViewById<TextView>(R.id.tvPuntaje)
        val btnRespuesta1 = findViewById<Button>(R.id.btnRespuesta1)
        var respuestita: String
        val successito = findViewById<LottieAnimationView>(R.id.successito)

        val pregunta1 = TTraduccion("Repeat", "Repetir", "Respetar", "Esperar", "Repetir", true)
        val pregunta2 = TTraduccion("Wrong", "Directo", "Usual", "Equivocado", "Equivocado", true)
        val pregunta3 = TTraduccion("Show", "Ocultar", "Mostrar", "Visitar", "Mostrar", true)
        val pregunta4 = TTraduccion("Giggle", "Risa nerviosa", "Correr rapido", "Caerse", "Risa nerviosa", true)
        val pregunta5 = TTraduccion("Soon", "Pronto", "Soleado", "Sol", "Pronto", true)
        val pregunta6 = TTraduccion("Agree","Estar de acuerdo", "Tener envidia", "Llegar tarde", "Estar de acuerdo", true)
        val pregunta7 = TTraduccion("Align","Internar", "Alinear", "Temblar", "Alinear", true)
        val pregunta8 = TTraduccion("Niece", "Sobrina", "Ave", "Collar", "Sobrina", true)
        val pregunta9 = TTraduccion("Parents", "Padres", "Familiares", "Primos", "Padres", true)
        val pregunta10 = TTraduccion("Course","Daño", "Curso", "Maldición", "Curso", true)
        val pregunta11 = TTraduccion("Flag", "Cortnia", "Alfombra", "Bandera", "Bandera", true)
        val pregunta12 = TTraduccion("Hunter", "Muy profundo", "Popular", "Cazador", "Cazador", true)
        val pregunta13 = TTraduccion("Priority", "prioridad", "descanso", "Escasez", "prioridad", true)
        val pregunta14 = TTraduccion("Sequel", "sirena", "secuela", "serenata", "secuela", true)
        val pregunta15 = TTraduccion("chain", "siglo", "cadena", "canción", "cadena", true)
        val pregunta16 = TTraduccion("apologize", "apocalipsis", "discutir", "disculparse", "disculparse", true)
        val pregunta17 = TTraduccion("recycle", "repeler", "reciclar", "revisar", "reciclar", true)
        val pregunta18 = TTraduccion("inhibit", "reprimir", "lastimar", "mostrar", "reprimir", true)
        val pregunta19 = TTraduccion("remove", "renovar", "rellenar", "quitar", "quitar", true)
        val pregunta20 = TTraduccion("remote", "invisible", "lejano", "cercano", "lejano", true)
        val pregunta21 = TTraduccion("shallow", "superficial", "oculto", "allegre", "superficial", true)

        otralista = listOf(pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10,
            pregunta11, pregunta12, pregunta13, pregunta14, pregunta15, pregunta16, pregunta17, pregunta18, pregunta19, pregunta20, pregunta21)

        listarepetidas.clear()

        val tamaño = otralista.count()
        //Toast.makeText(this, tamaño.toString(), Toast.LENGTH_SHORT).show()

        for (x in 0 until tamaño-1){
            otralista[x].id = x
            dakDatabase?.getTTraduccionDao()?.saveTTraduccion(otralista[x])
            dakDatabase?.getTTraduccionDao()?.updateTTraduccion(otralista[x])
        }

        traduccionList = dakDatabase?.getTTraduccionDao()?.getTTraduccionList()

        //Toast.makeText(this, gramaticaList?.get(tamanolista)?.id.toString(), Toast.LENGTH_SHORT).show()

        fun generarAleatorio(): Int {
            ipuntaje += 5
            if (ipuntaje == 100){
                var punt = tvPuntaje.text.toString()
                val intent = Intent(this, Puntaje::class.java)
                intent.putExtra("ganador", "Felicidades! contestaste todas las preguntas correctamente")
                // intent.putExtra()
                intent.putExtra("puntos", punt)
                startActivity(intent)
            }
            val random = Random()

            val preguntaAleatoria = random.nextInt(20)
            val repetidas = listarepetidas.count { it != 100}
            for (x in 0 until repetidas){

                if(preguntaAleatoria == listarepetidas[x]){
                    ipuntaje -= 5
                    return generarAleatorio()
                }
            }
            if (otralista[preguntaAleatoria].activo == false){
                ipuntaje -= 5
                return generarAleatorio()
            }
            else{
                otralista[preguntaAleatoria].activo = false
                listarepetidas.add(otralista[preguntaAleatoria].id!!)
                return preguntaAleatoria
            }
        }

        fun generarPregunta(){
            val aleatorio = generarAleatorio()
            tvPregunta.text = traduccionList?.get(aleatorio)?.pregunta.toString()
            btnRespuesta1.text = traduccionList?.get(aleatorio)?.respuesta1.toString()
            btnRespuesta2.text = traduccionList?.get(aleatorio)?.respuesta2.toString()
            btnRespuesta3.text = traduccionList?.get(aleatorio)?.respuesta3.toString()
        }

        tvPuntaje.text = 0.toString()

        fun evaluarRespuesta(respuesta: String){

            var myNum: Int
            for (x in 0 until tamaño - 1){
                if (respuesta == otralista[x].respuestaCorrecta){
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 5
                    successito.playAnimation()
                    tvPuntaje.text = myNum.toString()
                    return generarPregunta()
                }
            }

            myNum = Integer.parseInt(tvPuntaje.text.toString())
            val intent = Intent(this, Puntaje::class.java)
            intent.putExtra("puntos", myNum.toString())
            startActivity(intent)
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
