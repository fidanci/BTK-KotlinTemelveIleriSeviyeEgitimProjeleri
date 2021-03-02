package com.fidansoft.besinlerkitabi.servis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fidansoft.besinlerkitabi.model.Besin

@Dao
interface BesinDAO {

    // Data acces object -> DAO
    @Insert
    suspend fun insertAll(vararg besin : Besin) : List<Long>

    //Insert -> Room, insert to
    // suspend -> coroutine scope
    //vararg -> birden fazla ve istediğimiz sayıda besin
    //List<Long> ->long, id'ler

    @Query("SELECT * FROM besin")
    suspend fun getAllBesin() : List<Besin>

    @Query("SELECT * FROM besin WHERE uuid = :besinId")
    suspend fun getBesin(besinId : Int) :Besin

    @Query("DELETE FROM besin")
    suspend fun deleteAllBesin()
}