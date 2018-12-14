package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.*

@Dao
interface TAntonimosDao {
    /**
     * Retorna todos las tuplas de TAntonimos en orden ascendente.
     */
    @Query("SELECT * FROM TAntonimos ORDER BY id ASC")
    fun getTAntonimosList(): List<TAntonimos>

    /**
     * Retorna el id de la tabla TAntonimos
     */
    @Query("SELECT id FROM TAntonimos where pregunta = :pregunta")
    fun getTAntonimosId(pregunta:String): TAntonimos

    /**
     * Retorna la pregunta de la tabla TAntonimos
     */
    @Query("SELECT pregunta FROM TAntonimos WHERE id = :id")
    fun getTAntonimosPregunta(id: Int): TAntonimos

    /**
     * Retorna la respuesta 1 de la tabla TAntonimos
     */
    @Query("SELECT respuesta1 FROM TAntonimos WHERE id = :id")
    fun getTAntonimosrespuesta1(id: Int): TAntonimos
    /**
     * Retorna la respuesta 2 de la tabla TAntonimos
     */
    @Query("SELECT respuesta2 FROM TAntonimos WHERE id = :id")
    fun getTAntonimosrespuesta2(id: Int): TAntonimos
    /**
     * Retorna la respuesta 3 de la tabla TAntonimos
     */
    @Query("SELECT respuesta3 FROM TAntonimos WHERE id = :id")
    fun getTAntonimosrespuesta3(id: Int): TAntonimos
    /**
     * Retorna la respuesta correcta de la tabla TAntonimos
     */
    @Query("SELECT respuestaCorrecta FROM TAntonimos WHERE id = :id")
    fun getTAntonimosrespuestaCorrecta(id: Int): TAntonimos
    /**
     * Inserta una nueva tupla en la tabla TAntonimos.
     * @param tAntonimos la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTAntonimos(tAntonimos: TAntonimos)

    /**
     * Actualiza una tupla en la tabla TAntonimos.
     * @param tAntonimos el valor de la tupla a actualizar.
     */
    @Update
    fun updateTAntonimos(tAntonimos: TAntonimos)

    /**
     * Remueve una tupla de la tabla TAntonimos.
     * @param tAntonimos el valor de la tupla a remover.
     */
    @Delete
    fun deleteTAntonimos(tAntonimos: TAntonimos)
}