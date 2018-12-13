package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.*

@Dao
interface TTraduccionDao {
    /**
     * Retorna todos las tuplas de TTraduccion en orden ascendente.
     */
    @Query("SELECT * FROM TTraduccion ORDER BY id ASC")
    fun getTTraduccionList(): List<TTraduccion>

    /**
     * Retorna la pregunta de la tabla TTraduccion
     */
    @Query("SELECT pregunta FROM TTraduccion WHERE id = :id")
    fun getTTraduccionPregunta(id: Int): TTraduccion

    /**
     * Retorna la pregunta de la tabla TTraduccion
     */
    @Query("SELECT respuesta1 FROM TTraduccion WHERE id = :id")
    fun getTTraduccionrespuesta1(id: Int): TTraduccion
    /**
     * Retorna la pregunta de la tabla TTraduccion
     */
    @Query("SELECT respuesta2 FROM TTraduccion WHERE id = :id")
    fun getTTraduccionrespuesta2(id: Int): TTraduccion
    /**
     * Retorna la pregunta de la tabla TTraduccion
     */
    @Query("SELECT respuesta3 FROM TGramatica WHERE id = :id")
    fun getTTraduccionrespuesta3(id: Int): TTraduccion
    /**
     * Retorna la pregunta de la tabla TTraduccion
     */
    @Query("SELECT respuestaCorrecta FROM TTraduccion WHERE id = :id")
    fun getTTraduccionrespuestaCorrecta(id: Int): TTraduccion
    /**
     * Inserta una nueva tupla en la tabla TTraduccion.
     * @param tTraduccion la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTTraduccion(tTraduccion: TTraduccion)
    /**
     * Actualiza una tupla en la tabla TTraduccion.
     * @param tTraduccion el valor de la tupla a actualizar.
     */
    @Update
    fun updateTTraduccion(tTraduccion: TTraduccion)

    /**
     * Remueve una tupla de la tabla TTraduccion.
     * @param tTraduccion el valor de la tupla a remover.
     */
    @Delete
    fun deleteTTraduccion(tTraduccion: TTraduccion)
}