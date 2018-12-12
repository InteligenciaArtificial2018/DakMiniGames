package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.*

@Dao
interface TGramaticaDao {
    /**
     * Retorna todos las tuplas de Todo en orden ascendente.
     */
    @Query("SELECT * FROM TGramatica ORDER BY id ASC")
    fun getTGramaticaList(): List<TGramatica>

    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT pregunta FROM TGramatica WHERE id = :id")
    fun getTGramaticaPregunta(id: Int): TGramatica

    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT respuesta1 FROM TGramatica WHERE id = :id")
    fun getTGramaticarespuesta1(id: Int): TGramatica
    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT respuesta2 FROM TGramatica WHERE id = :id")
    fun getTGramaticarespuesta2(id: Int): TGramatica
    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT respuesta3 FROM TGramatica WHERE id = :id")
    fun getTGramaticarespuesta3(id: Int): TGramatica
    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT respuestaCorrecta FROM TGramatica WHERE id = :id")
    fun getTGramaticarespuestaCorrecta(id: Int): TGramatica
    /**
     * Inserta una nueva tupla en la tabla todo.
     * @param tGramatica la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTGramatica(tGramatica: TGramatica)

    /**
     * Actualiza una tupla en la tabla todo.
     * @param tGramatica el valor de la tupla a actualizar.
     */
    @Update
    fun updateTGramatica(tGramatica: TGramatica)

    /**
     * Remueve una tupla de la tabla todo.
     * @param tGramatica el valor de la tupla a remover.
     */
    @Delete
    fun deleteTGramatica(tGramatica: TGramatica)
}