package com.temandoaku

object DataSource {

    // Daftar semua doa disimpan di memori
    val doaList = listOf(
        Doa(
            id = 1,
            title = "Doa Sebelum Makan",
            arabic = "بِسْمِ اللهِ",
            latin = "Bismillah",
            translation = "Dengan nama Allah",
            imageResId = android.R.drawable.ic_menu_help,
            category = "Harian"
        ),
        Doa(
            id = 2,
            title = "Doa Sesudah Makan",
            arabic = "اَلْحَمْدُ لِلّٰهِ الَّذِىْ اَطْعَمَنَا وَسَقَانَا وَجَعَلَنَا مِنَ الْمُسْلِمِيْنَ",
            latin = "Alhamdulillaahil ladzii ath'amanaa wa saqoonaa wa ja'alnaa muslimiin",
            translation = "Segala puji bagi Allah yang telah memberi kami makan dan minum serta menjadikan kami termasuk golongan orang muslim",
            imageResId = android.R.drawable.ic_menu_help,
            category = "Harian"
        )
    )

    // Data Achievement
    val achievements = listOf(
        Achievement(
            id = 1,
            title = "Pembaca Pemula",
            description = "Baca 5 doa berbeda",
            iconResId = android.R.drawable.ic_menu_help,
            type = "doa"
        ),
        Achievement(
            id = 2,
            title = "Ahli Doa",
            description = "Baca semua doa harian",
            iconResId = android.R.drawable.ic_menu_help,
            type = "doa"
        ),
        Achievement(
            id = 3,
            title = "Pemain Hebat",
            description = "Selesaikan 3 game puzzle",
            iconResId = android.R.drawable.ic_menu_help,
            type = "game"
        ),
        Achievement(
            id = 4,
            title = "Rajin Berdoa",
            description = "Buka aplikasi 7 hari berturut-turut",
            iconResId = android.R.drawable.ic_menu_help,
            type = "daily"
        )
    )

    // Data Puzzle untuk game
    data class GameQuestion(
        val question: String,
        val options: List<String>,
        val correctAnswer: String
    )
}