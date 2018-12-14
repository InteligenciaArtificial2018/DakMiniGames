package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.*

@Dao
interface TDiccionarioDao {
    /**
     * Retorna todos las tuplas de TDiccionario en orden ascendente.
     */
    @Query("SELECT * FROM TDiccionario ORDER BY id ASC")
    fun getTDiccionarioList(): List<TDiccionario>

    /**
     * Retorna el id de la tabla TDiccionario
     */
    @Query("SELECT id FROM TDiccionario where pregunta = :pregunta")
    fun getTDiccionarioId(pregunta:String): TDiccionario

    /**
     * Retorna la pregunta de la tabla TDiccionario
     */
    @Query("SELECT pregunta FROM TDiccionario WHERE id = :id")
    fun getTDiccionarioPregunta(id: Int): TDiccionario

    /**
     * Retorna la respuesta 1 de la tabla TDiccionario
     */
    @Query("SELECT respuesta1 FROM TDiccionario WHERE id = :id")
    fun getTDiccionariorespuesta1(id: Int): TDiccionario
    /**
     * Retorna la respuesta 2 de la tabla TDiccionario
     */
    @Query("SELECT respuesta2 FROM TDiccionario WHERE id = :id")
    fun getTDiccionariorespuesta2(id: Int): TDiccionario
    /**
     * Retorna la respuesta 3 de la tabla TDiccionario
     */
    @Query("SELECT respuesta3 FROM TDiccionario WHERE id = :id")
    fun getTDiccionariorespuesta3(id: Int): TDiccionario
    /**
     * Retorna la respuesta correcta de la tabla TDiccionario
     */
    @Query("SELECT respuestaCorrecta FROM TDiccionario WHERE id = :id")
    fun getTDiccionariorespuestaCorrecta(id: Int): TDiccionario
    /**
     * Inserta una nueva tupla en la tabla TDiccionario.
     * @param tDiccionario la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTDiccionario(tDiccionario: TDiccionario)

    /**
     * Actualiza una tupla en la tabla TDiccionario.
     * @param tdiccionario el valor de la tupla a actualizar.
     */
    @Update
    fun updateTDiccionario(tDiccionario: TDiccionario)

    /**
     * Remueve una tupla de la tabla TDiccionario.
     * @param tDiccionario el valor de la tupla a remover.
     */
    @Delete
    fun deleteTDiccionario(tDiccionario: TDiccionario)
}