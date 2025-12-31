package com.temandoaku.data

data class Achievement(
    val id: Int,
    val title: String,
    val description: String,
    val iconResId: Int,
    val isUnlocked: Boolean = false,
    val type: String
)
