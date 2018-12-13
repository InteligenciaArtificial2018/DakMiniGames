package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.*

@Dao
interface TGramaticaDao {
    /**
     * Retorna todos las tuplas de TGramatica en orden ascendente.
     */
    @Query("SELECT * FROM TGramatica ORDER BY id ASC")
    fun getTGramaticaList(): List<TGramatica>

    /**
     * Retorna el id de la tabla TGramatica
     */
    @Query("SELECT id FROM TGramatica where pregunta = :pregunta")
    fun getTGramaticaId(pregunta:String): TGramatica

    /**
     * Retorna la pregunta de la tabla TGramatica
     */
    @Query("SELECT pregunta FROM TGramatica WHERE id = :id")
    fun getTGramaticaPregunta(id: Int): TGramatica

    /**
     * Retorna la respuesta 1 de la tabla TGramatica
     */
    @Query("SELECT respuesta1 FROM TGramatica WHERE id = :id")
    fun getTGramaticarespuesta1(id: Int): TGramatica
    /**
     * Retorna la respuesta 2 de la tabla TGramatica
     */
    @Query("SELECT respuesta2 FROM TGramatica WHERE id = :id")
    fun getTGramaticarespuesta2(id: Int): TGramatica
    /**
     * Retorna la respuesta 3 de la tabla TGramatica
     */
    @Query("SELECT respuesta3 FROM TGramatica WHERE id = :id")
    fun getTGramaticarespuesta3(id: Int): TGramatica
    /**
     * Retorna la respuesta correcta de la tabla TGramatica
     */
    @Query("SELECT respuestaCorrecta FROM TGramatica WHERE id = :id")
    fun getTGramaticarespuestaCorrecta(id: Int): TGramatica
    /**
     * Inserta una nueva tupla en la tabla TGramatica.
     * @param TGramatica la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTGramatica(TGramatica: TGramatica)

    /**
     * Actualiza una tupla en la tabla TGramatica.
     * @param TGramatica el valor de la tupla a actualizar.
     */
    @Update
    fun updateTGramatica(TGramatica: TGramatica)

    /**
     * Remueve una tupla de la tabla TGramatica.
     * @param tGramatica el valor de la tupla a remover.
     */
    @Delete
    fun deleteTGramatica(tGramatica: TGramatica)
}