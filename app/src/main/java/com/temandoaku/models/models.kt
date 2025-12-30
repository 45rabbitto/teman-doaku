package com.temandoaku

// Model Doa
data class Doa(
    val id: Int,
    val title: String,
    val arabic: String,
    val latin: String,
    val translation: String,
    val imageResId: Int,
    val category: String
)

// Model Achievement
data class Achievement(
    val id: Int,
    val title: String,
    val description: String,
    val iconResId: Int,
    var isUnlocked: Boolean = false,
    val type: String
)
