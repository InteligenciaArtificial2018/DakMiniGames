package com.example.dakaro.dakminigames

// librerias necesarias para el funcionamiento correcto de la app
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.example.dakaro.dakminigames.data.DakMiniGamesDatabase
import com.example.dakaro.dakminigames.data.TSinonimos
import java.util.Random

// no se pero me corrigio un error en "respuesta"
@Suppress("NAME_SHADOWING")
class Sinonimos : AppCompatActivity() {

    // variable de tipo base de datos la cual nos servirá para acceder a la misma.
    private var dakDatabase: DakMiniGamesDatabase? = null

    // Listas necesarias para la evaluación e inserción de preguntas.
    private var gramaticaList: List<TSinonimos>? = ArrayList()
    private var otralista: List<TSinonimos> = ArrayList()
    private var listarepetidas = mutableListOf<Int>()
    private var ipuntaje = -5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sinonimos)

        //Conexión con la base de datos
        dakDatabase = DakMiniGamesDatabase.getInstance(this)

        val tvPregunta = findViewById<TextView>(R.id.tvPregunta)
        val tvPuntaje = findViewById<TextView>(R.id.tvPuntaje)
        val btnRespuesta1 = findViewById<Button>(R.id.btnRespuesta1)
        val btnRespuesta2 = findViewById<Button>(R.id.btnRespuesta2)
        val btnRespuesta3 = findViewById<Button>(R.id.btnRespuesta3)
        var respuestita: String
        val successito = findViewById<LottieAnimationView>(R.id.successito)

        // Almacenamos la lista de tipo TGramatica en una variable
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
        val pregunta16 = TSinonimos("Repartir", "exclui", "dosificar", "atribuir", "dosificar", true)
        val pregunta17 = TSinonimos("Insulto", "agravio", "escrúpulo", "adulación", "agravio", true)
        val pregunta18 = TSinonimos("Sosegado", "colmado", "plácido", "inactivo", "plácido", true)
        val pregunta19 = TSinonimos("Educar", "ejercer", "enseñar", "profesar", "enseñar", true)
        val pregunta20 = TSinonimos("Fluctuar", "presistir", "oscilar", "arraigar", "oscilar", true)
        val pregunta21 = TSinonimos("Irónico", "incisivo", "apenado", "obtudo", "incisivo", true)
        val pregunta22 = TSinonimos("Desconocer", "ignorar", "recabar", "asistir", "ignorar", true)

        // Agregamos cada pregunta en una lista no mutable para una mejor evaluacion de los datos
        otralista = listOf(pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10,
            pregunta11, pregunta12, pregunta13, pregunta14, pregunta15, pregunta16, pregunta17, pregunta18, pregunta19, pregunta20, pregunta21, pregunta22)

        // Empezamos con una lista de preguntas repetidas vacía
        listarepetidas.clear()

        // Recorremos la lista desde 0 hasta la cantidad de datos dentro de la misma -1
        // le restamos 1 porque el indice de una lista empieza en 0
        for (x in 0 until otralista.count() - 1){

            // Dentro de la lista almacenamos el id segun el indice, ejemplo:
            // indice 1 = Pregunta 1
            // luego lo guardamos en la base de datos y por ultimo la actualizamos
            otralista[x].id = x
            dakDatabase?.getTSinonimosDao()?.saveTSinonimos(otralista[x])
            dakDatabase?.getTSinonimosDao()?.updateTSinonimos(otralista[x])
        }

        // guardamos en una lista todos los campos de la Tabla ya que esto
        // nos facilita trabajarlos
        gramaticaList = dakDatabase?.getTSinonimosDao()?.getTSinonimosList()

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

            var myNum:Int

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
