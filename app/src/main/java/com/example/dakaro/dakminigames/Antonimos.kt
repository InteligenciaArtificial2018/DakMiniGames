package com.example.dakaro.dakminigames

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.example.dakaro.dakminigames.data.DakMiniGamesDatabase
import com.example.dakaro.dakminigames.data.TAntonimos
import com.example.dakaro.dakminigames.data.TGramatica
import kotlinx.android.synthetic.main.activity_antonimos.*
import kotlinx.android.synthetic.main.activity_gramatica.*
import java.util.Random
import java.util.concurrent.TimeUnit

// no se que pedo pero me corrigio un error en "respuesta"
@Suppress("NAME_SHADOWING")
class Antonimos : AppCompatActivity() {
    private var dakDatabase: DakMiniGamesDatabase? = null
    var gramaticaList: List<TAntonimos>? = ArrayList()
    var gramaticaLocalList: List<TAntonimos>? = ArrayList()
    var otralista: List<TAntonimos> = ArrayList()
    var listarepetidas = mutableListOf<Int>()
    var ipuntaje = -5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gramatica)

        //Conexión con la base de datos
        dakDatabase = DakMiniGamesDatabase.getInstance(this)

        //tvPregunta.text = (dakDatabase?.getTGramaticaDao()?.getTGramaticaId(p1)).toString()

        val tvPregunta = findViewById<TextView>(R.id.tvPregunta)
        val tvPuntaje = findViewById<TextView>(R.id.tvPuntaje)
        val btnRespuesta1 = findViewById<Button>(R.id.btnRespuesta1)
        val btnRespuesta2 = findViewById<Button>(R.id.btnRespuesta2)
        val btnRespuesta3 = findViewById<Button>(R.id.btnRespuesta3)
        var respuestita: String
        val preguntasRepetiditas = mutableListOf<TGramatica>() // lista mutable que nos da la posibilidad de ir rellenando la lista a medida que lo necesitemos
        val successito = findViewById<LottieAnimationView>(R.id.successito)

        val pregunta1 = TAntonimos( "Echar", "atraer", "destruir", "enlazar", "atraer", true)
        val pregunta2 = TAntonimos( "Limpio", "inútil", "completo", "sucio", "sucio", true)
        val pregunta3 = TAntonimos( "Indemne", "dañado", "limpio", "débil", "dañado", true)
        val pregunta4 = TAntonimos( "Arcaico", "contemporáneo", "vacío", "difuso", "contemporáneo", true)
        val pregunta5 = TAntonimos("Fulgor", "brillo", "energía", "opacidad", "opacidad", true)
        val pregunta6 = TAntonimos("Perseverar","deslumbrar", "indagar", "desistir", "desistir", true)
        val pregunta7 = TAntonimos("Adversario","similar", "esporádico", "aliado", "aliado", true)
        val pregunta8 = TAntonimos("Vasto", "pequeño", "deterrado", "absoluto", "pequeño", true)
        val pregunta9 = TAntonimos("Armonioso", "perenme", "discordiante", "variable", "discordiante", true)
        val pregunta10 = TAntonimos("Disuadir","animar", "complicar", "divagar", "animar", true)
        val pregunta11 = TAntonimos("Expirar", "omitir", "mentir", "iniciar", "iniciar", true)
        val pregunta12 = TAntonimos("Benéfico", "elemental", "perpetuo", "perjudicial", "perjudicial", true)
        val pregunta13 = TAntonimos("Lúgubre", "alargado", "alegre", "humilde", "alegre", true)
        val pregunta14 = TAntonimos("Entusiasmo", "apatía", "auge", "delirio", "apatía", true)
        val pregunta15 = TAntonimos("Infringir", "acatar", "culpar", "copiar", "acatar", true)
        val pregunta16 = TAntonimos("Nefasto", "completo", "dichoso", "idéntico", "dichoso", true)
        val pregunta17 = TAntonimos("Opuesto", "equivalente", "extenso", "incapaz", "equivalente", true)
        val pregunta18 = TAntonimos("Indeciso", "dubitativo", "decidido", "indemne", "decidido", true)
        val pregunta19 = TAntonimos("Escatimar", "colocar", "inventar", "derrochar", "derrochar", true)
        val pregunta20 = TAntonimos("Alto", "ancho", "bajo", "angosto", "bajo", true)
        val pregunta21 = TAntonimos("Macizo", "intrincado", "evidente", "débil", "débil", true)
        val pregunta22 = TAntonimos("Impedir", "facilitar", "reprender", "trazar", "facilitar", true)

        otralista = listOf(pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10,
            pregunta11, pregunta12, pregunta13, pregunta14, pregunta15, pregunta16, pregunta17, pregunta18, pregunta19, pregunta20, pregunta21, pregunta22)

        listarepetidas.clear()

        //Toast.makeText(this, tamaño.toString(), Toast.LENGTH_SHORT).show()

        for (x in 0 until otralista.count() - 1){
            otralista[x].id = x
            dakDatabase?.getTantonimosDao()?.saveTAntonimos(otralista[x])
            dakDatabase?.getTantonimosDao()?.updateTAntonimos(otralista[x])
        }



        val eliminado = TGramatica("hola", "hola1", "hola2", "hola3", "hola")


        gramaticaList = dakDatabase?.getTantonimosDao()?.getTAntonimosList()

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

            val preguntaAleatoria = random.nextInt(21)
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
            tvPregunta.text = gramaticaList?.get(aleatorio)?.pregunta.toString()
            btnRespuesta1.text = gramaticaList?.get(aleatorio)?.respuesta1.toString()
            btnRespuesta2.text = gramaticaList?.get(aleatorio)?.respuesta2.toString()
            btnRespuesta3.text = gramaticaList?.get(aleatorio)?.respuesta3.toString()
        }

        tvPuntaje.text = 0.toString()

        fun evaluarRespuesta(respuesta: String){

            var myNum: Int
            for (x in 0 until otralista.count() - 1){
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
