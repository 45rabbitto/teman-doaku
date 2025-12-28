package com.temandoaku.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DoaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(doaList: List<DoaEntity>)

    @Query("SELECT * FROM doa")
    fun getAllDoa(): LiveData<List<DoaEntity>>
}
