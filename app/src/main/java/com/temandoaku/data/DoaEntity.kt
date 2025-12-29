package com.temandoaku.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doa")
data class DoaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val judul: String,
    val arab: String,
    val latin: String,
    val arti: String,
    val imageRes: Int,

    @ColumnInfo(defaultValue = "0")
val isFavorite: Boolean = false
)
