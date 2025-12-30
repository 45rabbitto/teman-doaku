package com.temandoaku.models

data class GameQuestion(
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)
