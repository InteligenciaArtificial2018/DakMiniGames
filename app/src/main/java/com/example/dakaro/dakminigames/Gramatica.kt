package com.example.dakaro.dakminigames

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.example.dakaro.dakminigames.data.DakMiniGamesDatabase
import com.example.dakaro.dakminigames.data.TGramatica
import kotlinx.android.synthetic.main.activity_gramatica.*
import java.util.Random

// no se pero me corrigio un error en "respuesta"
@Suppress("NAME_SHADOWING")
class Gramatica : AppCompatActivity() {
    private var dakDatabase: DakMiniGamesDatabase? = null
    var gramaticaList: List<TGramatica>? = ArrayList<TGramatica>()
    var gramaticaLocalList: List<TGramatica>? = ArrayList<TGramatica>()
    var otralista: List<TGramatica> = ArrayList<TGramatica>()
    var listarepetidas = mutableListOf<Int>()
    var ipuntaje = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gramatica)

        //Conexión con la base de datos
        dakDatabase = DakMiniGamesDatabase.getInstance(this)

        //tvPregunta.text = (dakDatabase?.getTGramaticaDao()?.getTGramaticaId(p1)).toString()

        val tvPregunta = findViewById<TextView>(R.id.tvPregunta)
        val tvPuntaje = findViewById<TextView>(R.id.tvPuntaje)
        val btnRespuesta1 = findViewById<Button>(R.id.btnRespuesta1)
        var respuestita: String
        val preguntasRepetiditas = mutableListOf<TGramatica>() // lista mutable que nos da la posibilidad de ir rellenando la lista a medida que lo necesitemos
        val successito = findViewById<LottieAnimationView>(R.id.successito)

        val pregunta1 = TGramatica( "Espero que lo ____ escrito bien", "haya", "alla", "haiga", "haya", true)
        val pregunta2 = TGramatica( "La tierra tiene muchas ____", "capas", "capaz", "capases", "capas", true)
        val pregunta3 = TGramatica( "___ no puedas mas, me llamas", "cuándo", "cuando", "quando", "cuando", true)
        val pregunta4 = TGramatica( "No se ____ así", "hiso", "izo", "hizo", "hizo", true)
        val pregunta5 = TGramatica("____ muchas quejas por el problema", "habían", "había", "abia", "había", true)
        val pregunta6 = TGramatica("___ muchos libros para que leas","alli", "hay", "ay", "hay", true)
        val pregunta7 = TGramatica("dibuja una __- con el lápiz","raya", "raia", "ralla", "raya", true)
        val pregunta8 = TGramatica("¡__ no!, ya es muy tarde", "o", "ho", "oh", "oh", true)
        val pregunta9 = TGramatica("no sé si ___ bebidas frías", "ahí", "ay", "hay", "hay", true)
        val pregunta10 = TGramatica("an reforzado el ___ del río","cause", "cauce", "cauze", "cauce", true)
        val pregunta11 = TGramatica("le otorgaron el título de ___", "varón", "barón", "Baron", "barón", true)
        val pregunta12 = TGramatica("te avisaé cuando ___ listo", "esté", "este", "estare", "esté", true)
        val pregunta13 = TGramatica("no entiendo el ___ de las cosas", "porqué", "por qué", "porque", "porqué", true)
        val pregunta14 = TGramatica("el agua corre en el ___", "arrollo", "arroyo", "arrullo", "arroyo", true)
        val pregunta15 = TGramatica("yo ___ que no dice la verdad", "sé", "se", "c", "sé", true)
        val pregunta16 = TGramatica("casi me ___ a llorar", "echo", "hecho", "écho", "echo", true)
        val pregunta17 = TGramatica("¿te ___ con ese dinero?", "basta", "básta", "vasta", "basta", true)
        val pregunta18 = TGramatica("el libro ___ sobre la cama", "cayo", "calló", "cayó", "cayó", true)
        val pregunta19 = TGramatica("le ___ dado una buena noticia", "haz", "as", "has", "has", true)
        val pregunta20 = TGramatica("estoy ___ de tanto trabajar", "desecho", "deshecho", "desesho", "deshecho", true)
        val pregunta21 = TGramatica("estoy ___ de tanto trabajar", "desecho", "deshecho", "desesho", "deshecho", true)

        otralista = listOf(pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10,
                                            pregunta11, pregunta12, pregunta13, pregunta14, pregunta15, pregunta16, pregunta17, pregunta18, pregunta19, pregunta20, pregunta21)

        listarepetidas.clear()

        val tamaño = otralista.count()
        //Toast.makeText(this, tamaño.toString(), Toast.LENGTH_SHORT).show()

        for (x in 0 until tamaño-1){
            otralista[x].id = x
            dakDatabase?.getTGramaticaDao()?.saveTGramatica(otralista[x])
            dakDatabase?.getTGramaticaDao()?.updateTGramatica(otralista[x])
        }



        val eliminado = TGramatica("hola", "hola1", "hola2", "hola3", "hola")
        /*
        eliminado.id = 0
        dakDatabase?.getTGramaticaDao()?.deleteTGramatica(eliminado)

        pregunta1.id = 1
        dakDatabase?.getTGramaticaDao()?.deleteTGramatica(pregunta1)
        dakDatabase?.getTGramaticaDao()?.updateTGramatica(pregunta1)

        pregunta2.id = 2
        dakDatabase?.getTGramaticaDao()?.saveTGramatica(pregunta2)
        dakDatabase?.getTGramaticaDao()?.updateTGramatica(pregunta2)

        pregunta3.id = 3
        dakDatabase?.getTGramaticaDao()?.saveTGramatica(pregunta3)
        dakDatabase?.getTGramaticaDao()?.updateTGramatica(pregunta3)

        pregunta4.id = 4
        dakDatabase?.getTGramaticaDao()?.saveTGramatica(pregunta4)
        dakDatabase?.getTGramaticaDao()?.updateTGramatica(pregunta4)

        pregunta5.id = 5
        dakDatabase?.getTGramaticaDao()?.saveTGramatica(pregunta5)
        dakDatabase?.getTGramaticaDao()?.updateTGramatica(pregunta5)
        */


        gramaticaList = dakDatabase?.getTGramaticaDao()?.getTGramaticaList()

        //Toast.makeText(this, gramaticaList?.get(tamanolista)?.id.toString(), Toast.LENGTH_SHORT).show()

        fun generarAleatorio(): Int {
            ipuntaje += 5
            if (ipuntaje == 100){
                ipuntaje = Integer.parseInt(tvPuntaje.text.toString())
                val intent = Intent(this, Puntaje::class.java)
                intent.putExtra("ganador", "Felicidades! contestaste todas las preguntas correctamente")
                // intent.putExtra()
                intent.putExtra("puntos", ipuntaje.toString())
                startActivity(intent)
            }
            val random = Random()

            val preguntaAleatoria = random.nextInt(20)
            val repetidas = listarepetidas.count { it != 100}
            for (x in 0 until repetidas){

                if(preguntaAleatoria == listarepetidas[x]){
                    return generarAleatorio()
                }
            }
            if (otralista[preguntaAleatoria].activo == false){
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
            tvPregunta.text = gramaticaList?.get(aleatorio)?.pregunta.toString()
            btnRespuesta1.text = gramaticaList?.get(aleatorio)?.respuesta1.toString()
            btnRespuesta2.text = gramaticaList?.get(aleatorio)?.respuesta2.toString()
            btnRespuesta3.text = gramaticaList?.get(aleatorio)?.respuesta3.toString()
        }

        tvPuntaje.text = 0.toString()

        fun evaluarRespuesta(respuesta: String){

            var myNum = 0
            var duration = Integer.parseInt(successito.duration.toString())
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
