package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "TTraduccion")
class TTraduccion(
    @ColumnInfo(name = "pregunta")
    var pregunta: String? = "",
    @ColumnInfo(name = "respuesta1")
    var respuesta1: String? = "",
    @ColumnInfo(name = "respuesta2")
    var respuesta2: String? = "",
    @ColumnInfo(name = "respuesta3")
    var respuesta3: String? = "",
    @ColumnInfo(name = "respuestaCorrecta")
    var respuestaCorrecta: String? = "")
    {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0
}