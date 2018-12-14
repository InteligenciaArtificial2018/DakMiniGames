package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.*

@Dao
interface TSinonimosDao {
    /**
     * Retorna todos las tuplas de TSinonimos en orden ascendente.
     */
    @Query("SELECT * FROM TSinonimos ORDER BY id ASC")
    fun getTSinonimosList(): List<TSinonimos>

    /**
     * Retorna el id de la tabla TSinonimos
     */
    @Query("SELECT id FROM TSinonimos where pregunta = :pregunta")
    fun getTSinonimosId(pregunta:String): TSinonimos

    /**
     * Retorna la pregunta de la tabla TSinonimos
     */
    @Query("SELECT pregunta FROM TSinonimos WHERE id = :id")
    fun getTSinonimosPregunta(id: Int): TSinonimos

    /**
     * Retorna la respuesta 1 de la tabla TSinonimos
     */
    @Query("SELECT respuesta1 FROM TSinonimos WHERE id = :id")
    fun getTSinonimosrespuesta1(id: Int): TSinonimos
    /**
     * Retorna la respuesta 2 de la tabla TSinonimos
     */
    @Query("SELECT respuesta2 FROM TSinonimos WHERE id = :id")
    fun getSinonimosrespuesta2(id: Int): TSinonimos
    /**
     * Retorna la respuesta 3 de la tabla TSinonimos
     */
    @Query("SELECT respuesta3 FROM TSinonimos WHERE id = :id")
    fun getTSinonimosrespuesta3(id: Int): TSinonimos
    /**
     * Retorna la respuesta correcta de la tabla TSinonimos
     */
    @Query("SELECT respuestaCorrecta FROM TSinonimos WHERE id = :id")
    fun getTSinonimosrespuestaCorrecta(id: Int): TSinonimos
    /**
     * Inserta una nueva tupla en la tabla TSinonimos.
     * @param TSinonimos la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTSinonimos(TSinonimos: TSinonimos)

    /**
     * Actualiza una tupla en la tabla TSinonimos.
     * @param tSinonimos el valor de la tupla a actualizar.
     */
    @Update
    fun updateTSinonimos(tSinonimos: TSinonimos)

    /**
     * Remueve una tupla de la tabla TSinonimos.
     * @param tSinonimos el valor de la tupla a remover.
     */
    @Delete
    fun deleteTSinonimos(tSinonimos: TSinonimos)
}