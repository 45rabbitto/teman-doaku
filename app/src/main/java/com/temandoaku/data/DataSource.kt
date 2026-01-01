package com.temandoaku.data

import com.temandoaku.R

object DataSource {

    // TOTAL DOA (sesuaikan dengan Room Database)
    val doaList = listOf(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    )

    val achievements = listOf(

        // Achievement 1
        Achievement(
            id = 1,
            title = "Awal yang Baik",
            description = "Membaca 5 doa",
            iconResId = R.drawable.ic_achievement_read,
            type = "DOA"
        ),

        // Achievement 3
        Achievement(
            id = 3,
            title = "Pemain Aktif",
            description = "Memainkan game 3 kali",
            iconResId = R.drawable.ic_achievement_game,
            type = "GAME"
        ),

        // Achievement 4
        Achievement(
            id = 4,
            title = "Istiqomah",
            description = "Login streak 7 hari",
            iconResId = R.drawable.ic_achievement_streak,
            type = "STREAK"
        ),

        // Achievement 5
        Achievement(
            id = 5,
            title = "Ahli Doa",
            description = "Membaca semua doa",
            iconResId = R.drawable.ic_achievement_all,
            type = "DOA"
        )
    )
}
