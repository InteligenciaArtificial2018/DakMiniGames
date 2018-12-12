package com.example.dakaro.dakminigames

class PreguntasSinonimos(numeroPregunta: Int, pregunta: String, respuesta1: String, respuesta2: String, respuesta3: String, respuestaCorrecta: String, activa:Boolean ) {
    var numeroPregunta = 0
    var pregunta = ""
    var respuesta1 = ""
    var respuesta2 = ""
    var respuesta3 = ""
    var respuestaCorrecta = ""
    var activa = true

    init {
        this.numeroPregunta = numeroPregunta
        this.pregunta = pregunta
        this.respuesta1 = respuesta1
        this.respuesta2 = respuesta2
        this.respuesta3 = respuesta3
        this.respuestaCorrecta = respuestaCorrecta
        this.activa = activa
    }
}