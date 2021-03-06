package com.example.dakaro.dakminigames.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [TGramatica::class, TTraduccion::class, TSinonimos::class, TAntonimos::class, TDiccionario::class], version = 14, exportSchema = false)
abstract class DakMiniGamesDatabase: RoomDatabase() {
    /**
     * Este es un método abstracto que retorna el DAO para la base de datos.
     */
    abstract fun getTGramaticaDao(): TGramaticaDao
    abstract fun getTTraduccionDao(): TTraduccionDao
    abstract fun getTDiccionarioDao(): TDiccionarioDao
    abstract fun getTSinonimosDao(): TSinonimosDao
    abstract fun getTantonimosDao():TAntonimosDao

    /**
     * Un patrón de diseño Singleton es utilizado para asegurarnos que
     * solamente se cree una instancia de la base de datos.
     */
    companion object {
        val databaseName = "dakminigamesdatabase"
        var dakMiniGamesDatabase: DakMiniGamesDatabase? = null

        fun getInstance(context: Context): DakMiniGamesDatabase? {
            if (dakMiniGamesDatabase == null) {
                dakMiniGamesDatabase = Room.databaseBuilder(context,
                    DakMiniGamesDatabase::class.java,
                    DakMiniGamesDatabase.databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return dakMiniGamesDatabase
        }
    }
}