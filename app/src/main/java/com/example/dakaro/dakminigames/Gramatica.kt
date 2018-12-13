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

// no se que pedo pero me corrigio un error en "respuesta"
@Suppress("NAME_SHADOWING")
class Gramatica : AppCompatActivity() {
    private var dakDatabase: DakMiniGamesDatabase? = null
    var gramaticaList: List<TGramatica>? = ArrayList<TGramatica>()
    var gramaticaLocalList: MutableList<String>? = ArrayList<String>()

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
        val preguntasRepetiditas = mutableListOf<String>() // lista mutable que nos da la posibilidad de ir rellenando la lista a medida que lo necesitemos
        val respuestitasCorrectitas = mutableListOf<String>()
        val successito = findViewById<LottieAnimationView>(R.id.successito)



        val pregunta1 = TGramatica( "Espero que lo ____ escrito bien", "haya", "alla", "haiga", "haya")
        val pregunta2 = TGramatica( "La tierra tiene muchas ____", "capas", "capaz", "capases", "capas")
        val pregunta3 = TGramatica( "___ no puedas mas, me llamas", "cuándo", "cuando", "quando", "cuando")
        val pregunta4 = TGramatica( "No se ____ así", "hiso", "izo", "hizo", "hizo")
        val pregunta5 = TGramatica("____ muchas quejas por el problema", "habían", "había", "abia", "había")
        val pregunta6 = TGramatica("___ muchos libros para que leas","alli", "hay", "ay", "hay")
        val pregunta7 = TGramatica("dibuja una __- con el lápiz","raya", "raia", "ralla", "raya")
        val pregunta8 = TGramatica("¡__ no!, ya es muy tarde", "o", "ho", "oh", "oh")
        val pregunta9 = TGramatica("no sé si ___ bebidas frías", "ahí", "ay", "hay", "hay")
        val pregunta10 = TGramatica("an reforzado el ___ del río","cause", "cauce", "cauze", "cauce")
        var pregunta11 = TGramatica("le otorgaron el título de ___", "varón", "barón", "Baron", "Barón")
        var pregunta12 = TGramatica("te avisaé cuando ___ listo", "esté", "este", "estare", "esté")
        var pregunta13 = TGramatica("no entiendo el ___ de las cosas", "porqué", "por qué", "porque", "porqué")
        var pregunta14 = TGramatica("el agua corre en el ___", "arrollo", "arroyo", "arrullo", "arroyo")
        var pregunta15 = TGramatica("yo ___ que no dice la verdad", "sé", "se", "c", "sé")
        var pregunta16 = TGramatica("casi me ___ a llorar", "echo", "hecho", "écho", "echo")
        var pregunta17 = TGramatica("¿te ___ con ese dinero?", "basta", "básta", "vasta", "basta")
        var pregunta18 = TGramatica("el libro ___ sobre la cama", "cayo", "calló", "cayó", "cayó")
        var pregunta19 = TGramatica("le ___ dado una buena noticia", "haz", "as", "has", "has")
        var pregunta20 = TGramatica("estoy ___ de tanto trabajar", "desecho", "deshecho", "desesho", "deshecho")


        val eliminado = TGramatica("hola", "hola1", "hola2", "hola3", "hola")
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


        gramaticaList = dakDatabase?.getTGramaticaDao()?.getTGramaticaList()
        val listarepetidas = mutableListOf<Int>()
        //Toast.makeText(this, gramaticaList?.get(tamanolista)?.id.toString(), Toast.LENGTH_SHORT).show()

        fun generarAleatorio(): Int {

            val random = Random()

            val preguntaAleatoria = random.nextInt(5)
            if (preguntaAleatoria == 0){
                generarAleatorio()
            }else if (listarepetidas.none{it != preguntaAleatoria}){
                listarepetidas.add(gramaticaList?.get(preguntaAleatoria)?.id!!)
                return preguntaAleatoria
            }
            else{

                // revisa cada item dentro de la lista y evalua: si no existe dentro de la lista entonces
                // esa pregunta no esta repetida y se mostrara en la app.
                /*
                if (preguntasRepetiditas.none{it == gramaticaList?.get(preguntaAleatoria)?.pregunta.toString()}) {
                    preguntasRepetiditas.add(gramaticaList?.get(preguntaAleatoria)?.pregunta.toString())
                    return preguntaAleatoria
                }else{
                    generarAleatorio()
                }*/
            }
            return preguntaAleatoria
        }

        fun generarPregunta(){
            var aleatorio = generarAleatorio()
            tvPregunta.text = gramaticaList?.get(aleatorio)?.pregunta.toString()
            btnRespuesta1.text = gramaticaList?.get(aleatorio)?.respuesta1.toString()
            btnRespuesta2.text = gramaticaList?.get(aleatorio)?.respuesta2.toString()
            btnRespuesta3.text = gramaticaList?.get(aleatorio)?.respuesta3.toString()
            //Toast.makeText(this, gramaticaList?.get(aleatorio)?.id.toString(), Toast.LENGTH_SHORT).show()
        }

        tvPuntaje.text = 0.toString()

        fun evaluarRespuesta(respuesta: String){

            var myNum = 0

            var duration = Integer.parseInt(successito.duration.toString())
            var i = 0
            if(respuesta == gramaticaList?.get(1)?.respuestaCorrecta.toString()){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2

                successito.playAnimation()


                tvPuntaje.text = myNum.toString()
                generarPregunta()
            }else if (respuesta == gramaticaList?.get(2)?.respuestaCorrecta.toString()){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2

                successito.playAnimation()



                tvPuntaje.text = myNum.toString()
                generarPregunta()

            }else if (respuesta == gramaticaList?.get(3)?.respuestaCorrecta.toString()){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2

                successito.playAnimation()


                tvPuntaje.text = myNum.toString()
                
                generarPregunta()

            }else if (respuesta == gramaticaList?.get(4)?.respuestaCorrecta.toString()){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2

                successito.playAnimation()


                tvPuntaje.text = myNum.toString()

                generarPregunta()

            }else if (respuesta == gramaticaList?.get(5)?.respuestaCorrecta.toString()){
                myNum = Integer.parseInt(tvPuntaje.text.toString())
                myNum += 2

                successito.playAnimation()


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
