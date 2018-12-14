package com.example.dakaro.dakminigames

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.example.dakaro.dakminigames.data.DakMiniGamesDatabase
import com.example.dakaro.dakminigames.data.TSinonimos
import java.util.Random

// no se que pedo pero me corrigio un error en "respuesta"
@SuppressLint("Registered")
@Suppress("NAME_SHADOWING")
class Sinonimos : AppCompatActivity() {
    private var dakDatabase: DakMiniGamesDatabase? = null
    var gramaticaList: List<TSinonimos>? = ArrayList<TSinonimos>()
    var otralista: List<TSinonimos> = ArrayList<TSinonimos>()
    var listarepetidas = mutableListOf<Int>()
    var ipuntaje = -5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sinonimos)

        val tvPregunta = findViewById<TextView>(R.id.tvPregunta)
        val tvPuntaje = findViewById<TextView>(R.id.tvPuntaje)
        val btnRespuesta1 = findViewById<Button>(R.id.btnRespuesta1)
        val btnRespuesta2 = findViewById<Button>(R.id.btnRespuesta2)
        val btnRespuesta3 = findViewById<Button>(R.id.btnRespuesta3)
        var respuestita: String
        val successito = findViewById<LottieAnimationView>(R.id.successito)

        val pregunta1 = TSinonimos( "Concurrir", "Apreciar", "Asistir", "Despegar", "Asistir", true)
        val pregunta2 = TSinonimos( "Caminar", "Avisar", "Deambular", "Descansar", "Deambular", true)
        val pregunta3 = TSinonimos( "Causa", "Procedimiento", "Motivo", "Meta", "Motivo", true)
        val pregunta4 = TSinonimos( "Corpóreo", "Físico", "Falaz", "Abstracto", "Físico", true)
        val pregunta5 = TSinonimos( "Amparar", "Repetir", "Proteger", "Incluir", "Proteger", true)
        val pregunta6 = TSinonimos( "Fugitivo", "Desertor", "Moderado", "Confiado", "Desertor", true)
        val pregunta7 = TSinonimos( "Impune", "Insensato", "Imprevisto", "Excento", "Excento", true)
        val pregunta8 = TSinonimos( "Opulento", "Patético", "Lujoso", "Estridente", "Lujoso", true)
        val pregunta9 = TSinonimos( "Afectuoso", "Efusivo", "Útil", "Prosaico", "Efusivo", true)
        val pregunta10 = TSinonimos("Lúgubre", "Sombrío", "Alborozado", "Delirante", "Sombrío", true)
        val pregunta11 = TSinonimos("Nefasto", "oportuno", "fatidico", "propicio", "fatidico", true)
        val pregunta12 = TSinonimos("Mácula", "mancha", "catencia", "mezcla", "mancha", true)
        val pregunta13 = TSinonimos("Amonestar", "reprender", "ostentar", "incluir", "reprender", true)
        val pregunta14 = TSinonimos("Colocar", "recortar", "derribar", "situar", "situar", true)
        val pregunta15 = TSinonimos("Intolerante", "condescendiente", "indulgente", "intransigente", "intransigente", true)
        val pregunta16 = TSinonimos("Repartir", "exclui", "dosifcar", "atribuir", "dosificar", true)
        val pregunta17 = TSinonimos("Insulto", "agravio", "escrúpulo", "adulación", "agravio", true)
        val pregunta18 = TSinonimos("Sosegado", "colmado", "plácido", "inactivo", "plácido", true)
        val pregunta19 = TSinonimos("Educar", "ejercer", "enseñar", "profesar", "enseñar", true)
        val pregunta20 = TSinonimos("Fluctuar", "presistir", "oscilar", "arraigar", "oscilar", true)
        val pregunta21 = TSinonimos("Irónico", "incisivo", "apenado", "obtudo", "incisivo", true)

        otralista = listOf(pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10,
            pregunta11, pregunta12, pregunta13, pregunta14, pregunta15, pregunta16, pregunta17, pregunta18, pregunta19, pregunta20, pregunta21)

        listarepetidas.clear()

        val tamaño = otralista.count()
        //Toast.makeText(this, tamaño.toString(), Toast.LENGTH_SHORT).show()

        for (x in 0 until tamaño-1){
            otralista[x].id = x
            dakDatabase?.getTSinonimosDao()?.saveTSinonimos(otralista[x])
            dakDatabase?.getTSinonimosDao()?.updateTSinonimos(otralista[x])
        }

        val eliminado = TSinonimos("hola", "hola1", "hola2", "hola3", "hola")


        gramaticaList = dakDatabase?.getTSinonimosDao()?.getTSinonimosList()

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
            tvPregunta.text = gramaticaList?.get(aleatorio)?.pregunta.toString()
            btnRespuesta1.text = gramaticaList?.get(aleatorio)?.respuesta1.toString()
            btnRespuesta2.text = gramaticaList?.get(aleatorio)?.respuesta2.toString()
            btnRespuesta3.text = gramaticaList?.get(aleatorio)?.respuesta3.toString()
        }

        tvPuntaje.text = 0.toString()

        fun evaluarRespuesta(respuesta: String){

            var myNum:Int
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
