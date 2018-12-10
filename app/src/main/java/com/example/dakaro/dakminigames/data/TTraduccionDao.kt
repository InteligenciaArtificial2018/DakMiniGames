package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.*

@Dao
interface TTraduccionDao {
    /**
     * Retorna todos las tuplas de Todo en orden ascendente.
     */
    @Query("SELECT * FROM TGramatica ORDER BY id ASC")
    fun getTTraduccionList(): List<TGramatica>

    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT pregunta FROM TGramatica WHERE id = :id")
    fun getTTraduccionPregunta(id: Int): TGramatica

    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT respuesta1 FROM TGramatica WHERE id = :id")
    fun getTTraduccionrespuesta1(id: Int): TGramatica
    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT respuesta2 FROM TGramatica WHERE id = :id")
    fun getTTraduccionrespuesta2(id: Int): TGramatica
    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT respuesta3 FROM TGramatica WHERE id = :id")
    fun getTTraduccionrespuesta3(id: Int): TGramatica
    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT respuestaCorrecta FROM TGramatica WHERE id = :id")
    fun getTTraduccionrespuestaCorrecta(id: Int): TGramatica
    /**
     * Inserta una nueva tupla en la tabla todo.
     * @param tGramatica la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTTraduccion(tGramatica: TGramatica)

    /**
     * Actualiza una tupla en la tabla todo.
     * @param tGramatica el valor de la tupla a actualizar.
     */
    @Update
    fun updateTTraduccion(tGramatica: TGramatica)

    /**
     * Remueve una tupla de la tabla todo.
     * @param tGramatica el valor de la tupla a remover.
     */
    @Delete
    fun deleteTTraduccion(tGramatica: TGramatica)
}