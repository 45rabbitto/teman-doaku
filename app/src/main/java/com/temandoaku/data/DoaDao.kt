package com.temandoaku.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface DoaDao {

    @Query("SELECT * FROM doa")
    suspend fun getAll(): List<DoaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<DoaEntity>)

    @Update
    suspend fun update(doa: DoaEntity)
}



