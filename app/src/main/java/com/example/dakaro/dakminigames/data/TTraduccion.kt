package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

// Tabla TTraduccion en donde se guardarán los campos necesarios
// para el correcto funcionamiento de el minijuego "Traducción"
@Entity(tableName = "TTraduccion")
class TTraduccion(
    // Columna "Pregunta"
    @ColumnInfo(name = "pregunta")
    var pregunta: String? = "",

    // Columna "respuesta 1"
    @ColumnInfo(name = "respuesta1")
    var respuesta1: String? = "",

    // Columna "respuesta 2"
    @ColumnInfo(name = "respuesta2")
    var respuesta2: String? = "",

    // Columna "respuesta 3"
    @ColumnInfo(name = "respuesta3")
    var respuesta3: String? = "",

    // Columna "respuestaCorrecta"
    @ColumnInfo(name = "respuestaCorrecta")
    var respuestaCorrecta: String? = "",

    // Columna "activo"
    @ColumnInfo(name = "activo")
    var activo: Boolean? = true)
    {
        // llave primaria "id"
        @PrimaryKey(autoGenerate = true)
        var id: Int? = 0
}

