package com.example.dakaro.dakminigames

// librerias necesarias para el funcionamiento correcto de la app
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.example.dakaro.dakminigames.data.DakMiniGamesDatabase
import com.example.dakaro.dakminigames.data.TGramatica
import kotlinx.android.synthetic.main.activity_gramatica.*
import java.util.Random

// no se pero me corrigió un error en "respuesta"
@Suppress("NAME_SHADOWING")
class Gramatica : AppCompatActivity() {

    // variable de tipo base de datos la cual nos servirá para acceder a la misma.
    private var dakDatabase: DakMiniGamesDatabase? = null

    // Listas necesarias para la evaluación e inserción de preguntas.
    private var gramaticaList: List<TGramatica>? = ArrayList()
    private var otralista: List<TGramatica> = ArrayList()
    private var listarepetidas = mutableListOf<Int>()
    private var ipuntaje = -5


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

        // Almacenamos la lista de tipo TGramatica en una variable
        val pregunta1 = TGramatica( "Espero que lo ____ escrito bien", "haya", "alla", "haiga", "haya", true)
        val pregunta2 = TGramatica( "La tierra tiene muchas ____", "capas", "capaz", "capases", "capas", true)
        val pregunta3 = TGramatica( "___ no puedas mas, me llamas", "cuándo", "cuando", "quando", "cuando", true)
        val pregunta4 = TGramatica( "No se ____ así", "hiso", "izo", "hizo", "hizo", true)
        val pregunta5 = TGramatica("____ muchas quejas por el problema", "habían", "había", "abia", "había", true)
        val pregunta6 = TGramatica("___ muchos libros para que leas","alli", "hay", "ay", "hay", true)
        val pregunta7 = TGramatica("Dibuja una ___ con el lápiz","raya", "raia", "ralla", "raya", true)
        val pregunta8 = TGramatica("¡__ no!, ya es muy tarde", "o", "ho", "oh", "oh", true)
        val pregunta9 = TGramatica("No sé si ___ bebidas frías", "ahí", "ay", "hay", "hay", true)
        val pregunta10 = TGramatica("An reforzado el ___ del río","cause", "cauce", "cauze", "cauce", true)
        val pregunta11 = TGramatica("Le otorgaron el título de ___", "varón", "barón", "Baron", "barón", true)
        val pregunta12 = TGramatica("Te avisaré cuando ___ listo", "esté", "este", "estare", "esté", true)
        val pregunta13 = TGramatica("No entiendo el ___ de las cosas", "porqué", "por qué", "porque", "porqué", true)
        val pregunta14 = TGramatica("El agua corre en el ___", "arrollo", "arroyo", "arrullo", "arroyo", true)
        val pregunta15 = TGramatica("Yo ___ que no dice la verdad", "sé", "se", "c", "sé", true)
        val pregunta16 = TGramatica("Casi me ___ a llorar", "echo", "hecho", "écho", "echo", true)
        val pregunta17 = TGramatica("¿Te ___ con ese dinero?", "basta", "básta", "vasta", "basta", true)
        val pregunta18 = TGramatica("El libro ___ sobre la cama", "cayo", "calló", "cayó", "cayó", true)
        val pregunta19 = TGramatica("Le ___ dado una buena noticia", "haz", "as", "has", "has", true)
        val pregunta20 = TGramatica("Estoy ___ de tanto trabajar", "desecho", "deshecho", "desesho", "deshecho", true)
        val pregunta21 = TGramatica("Yo no ___ mi propia tumba", "cábo", "cabo", "cavo", "cavo", true)
        val pregunta22 = TGramatica("¿___ casa te gusta más?", "cual", "cuál", "cúal", "cuál", true)

        // Agregamos cada pregunta en una lista no mutable para una mejor evaluacion de los datos
        otralista = listOf(pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10,
                                            pregunta11, pregunta12, pregunta13, pregunta14, pregunta15, pregunta16, pregunta17, pregunta18,
                                            pregunta19, pregunta20, pregunta21, pregunta22)

        // Empezamos con una lista de preguntas repetidas vacía
        listarepetidas.clear()

        // Recorremos la lista desde 0 hasta la cantidad de datos dentro de la misma -1
        // le restamos 1 porque el indice de una lista empieza en 0
        for (x in 0 until otralista.count()-1){

            // Dentro de la lista almacenamos el id segun el indice, ejemplo:
            // indice 1 = Pregunta 1
            // luego lo guardamos en la base de datos y por ultimo la actualizamos
            otralista[x].id = x
            dakDatabase?.getTGramaticaDao()?.saveTGramatica(otralista[x])
            dakDatabase?.getTGramaticaDao()?.updateTGramatica(otralista[x])
        }

        // guardamos en una lista todos los campos de la Tabla ya que esto
        // nos facilita trabajarlos
        gramaticaList = dakDatabase?.getTGramaticaDao()?.getTGramaticaList()

        // Función generarAleatorio lo qe hace es generar un numero aleatoriamente entre el rango de 0 - 21
        fun generarAleatorio(): Int {

            // variable ipuntaje lleva un control de el puntaje del usuario sin la necesidad
            // de traerlo de otra función
            ipuntaje += 5

            // Cuando el puntaje sea 100 entonces el usuario habra ganado el minijuego
            if (ipuntaje == 100){
                val punt = tvPuntaje.text.toString()
                val intent = Intent(this, Puntaje::class.java)

                // enviamos un intent con un mensaje de ganador y la puntuación obtenida
                intent.putExtra("ganador", "Felicidades! contestaste todas las preguntas correctamente")
                intent.putExtra("puntos", punt)
                startActivity(intent)
            }

            // Generamos el numero aleatorio
            val random = Random()

            val preguntaAleatoria = random.nextInt(21)

            // Lambda, esto permitió contar una lista mutable
            // distinto a 100 para que siempre se cumpla
            val repetidas = listarepetidas.count { it != 100}
            for (x in 0 until repetidas){

                // Evalúa si la pregunta aleatoria es o no es repetida
                if(preguntaAleatoria == listarepetidas[x]){

                    // se resta 5 al puntaje ya que con recursividad llamaremos a la misma clase
                    // y esta sumará 5 aunque no haya contestado ninguna pregunta
                    ipuntaje -= 5
                    return generarAleatorio()
                }
            }

            // Otro metodo para la verificación de preguntas repetidas es mediante el campo "activo"
            // el cual se convierte en falso cuando la pregunta nunca ha salido al juego, cuando esa
            // pregunta regrese ahora su campo "activo" sera falso y por ende no se mostrará
            return if (otralista[preguntaAleatoria].activo == false){
                ipuntaje -= 5
                generarAleatorio()
            } else{
                otralista[preguntaAleatoria].activo = false
                listarepetidas.add(otralista[preguntaAleatoria].id!!)
                preguntaAleatoria
            }
        }

        // La función generarPregunta ingresa los campos de la pregunta aleatoria obtenida a los
        // TextView y Buttons de nuestro layout, estos los trae tabla.
        fun generarPregunta(){
            val aleatorio = generarAleatorio()
            tvPregunta.text = gramaticaList?.get(aleatorio)?.pregunta.toString()
            btnRespuesta1.text = gramaticaList?.get(aleatorio)?.respuesta1.toString()
            btnRespuesta2.text = gramaticaList?.get(aleatorio)?.respuesta2.toString()
            btnRespuesta3.text = gramaticaList?.get(aleatorio)?.respuesta3.toString()
        }

        // Inicializamos el puntaje en 0
        tvPuntaje.text = 0.toString()

        // La función evaluarRespuesta recibe como parametro la respuesta de el usuario
        // es la encargada de evaluar si la respuesta es correcta o no y de incrementar
        // el puntaje segun los aciertos.
        fun evaluarRespuesta(respuesta: String){

            var myNum: Int

            // recorremos la lista
            for (x in 0 until otralista.count() - 1){

                // si la respuesta escogida por el usuario concuerda con la respuesta
                // correcta de la pregunta entonces incrementara el puntaje y genera
                // una nueva pregunta
                if (respuesta == otralista[x].respuestaCorrecta){
                    myNum = Integer.parseInt(tvPuntaje.text.toString())
                    myNum += 5

                    // Succesito es nuestra animación de check la cual se inicia al
                    // acertar la respuesta
                    successito.playAnimation()
                    tvPuntaje.text = myNum.toString()
                    return generarPregunta()
                }
            }

            // si escoge la respuesta equivocada se le envará al layout de puntaje y
            // indicandole cual fue su puntaje total.
            myNum = Integer.parseInt(tvPuntaje.text.toString())
            val intent = Intent(this, Puntaje::class.java)
            intent.putExtra("puntos", myNum.toString())
            startActivity(intent)
        }

        // aqui viene lo chidooo! a corre nuestra aplicación ;)
        generarPregunta()


        // captamos cual fue la seleccion del usuario y la enviamos a evaluarRespuesta
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
