package com.temandoaku.data

import com.temandoaku.models.GameQuestion

object SambungAyatQuestions {

    val questions = listOf(

        // 1. Masuk rumah
        GameQuestion(
            question = "السَّلَامُ",
            options = listOf(
                "عَلَيْكُمْ",
                "اللَّهُ",
                "لِلَّهِ",
                "رَبِّ"
            ),
            correctAnswer = "عَلَيْكُمْ"
        ),

        // 2. Keluar rumah
        GameQuestion(
            question = "بِسْمِ اللَّهِ",
            options = listOf(
                "تَوَكَّلْتُ عَلَى اللَّهِ",
                "الْحَمْدُ لِلَّهِ",
                "أَعُوذُ بِكَ",
                "اغْفِرْ لِي"
            ),
            correctAnswer = "تَوَكَّلْتُ عَلَى اللَّهِ"
        ),

        // 3. Menjawab salam
        GameQuestion(
            question = "وَعَلَيْكُمُ",
            options = listOf(
                "السَّلَامُ",
                "اللَّهُ",
                "الْحَمْدُ",
                "رَبِّ"
            ),
            correctAnswer = "السَّلَامُ"
        ),

        // 4. Sesudah makan
        GameQuestion(
            question = "الْحَمْدُ لِلَّهِ",
            options = listOf(
                "الَّذِي أَطْعَمَنَا",
                "رَبِّ الْعَالَمِينَ",
                "عَلَيْكُمْ",
                "إِلَّا اللَّهُ"
            ),
            correctAnswer = "الَّذِي أَطْعَمَنَا"
        ),

        // 5. Masuk WC
        GameQuestion(
            question = "اللَّهُمَّ إِنِّي",
            options = listOf(
                "أَعُوذُ بِكَ",
                "تَوَكَّلْتُ عَلَى اللَّهِ",
                "اغْفِرْ لِي",
                "أَشْهَدُ أَنْ"
            ),
            correctAnswer = "أَعُوذُ بِكَ"
        ),

        // 6. Akan tidur
        GameQuestion(
            question = "بِاسْمِكَ",
            options = listOf(
                "أَمُوتُ",
                "أَحْيَا",
                "أَنَامُ",
                "أَسْتَيْقِظُ"
            ),
            correctAnswer = "أَمُوتُ"
        ),

        // 7. Birrul walidain
        GameQuestion(
            question = "رَبِّ اغْفِرْ",
            options = listOf(
                "لِي وَلِوَالِدَيَّ",
                "لَنَا ذُنُوبَنَا",
                "لِي ذَنْبِي",
                "لِلْمُؤْمِنِينَ"
            ),
            correctAnswer = "لِي وَلِوَالِدَيَّ"
        ),

        // 8. Keluar masjid
        GameQuestion(
            question = "اللَّهُمَّ إِنِّي",
            options = listOf(
                "أَسْأَلُكَ مِنْ فَضْلِكَ",
                "أَعُوذُ بِكَ",
                "اغْفِرْ لِي",
                "تَوَكَّلْتُ"
            ),
            correctAnswer = "أَسْأَلُكَ مِنْ فَضْلِكَ"
        ),

        // 9. Bangun tidur
        GameQuestion(
            question = "الْحَمْدُ لِلَّهِ",
            options = listOf(
                "الَّذِي أَحْيَانَا",
                "رَبِّ الْعَالَمِينَ",
                "الَّذِي أَطْعَمَنَا",
                "مِنْ فَضْلِكَ"
            ),
            correctAnswer = "الَّذِي أَحْيَانَا"
        ),

        // 10. Jawaban ketika mendengar orang bersin
        GameQuestion(
            question = "يَرْحَمُكَ",
            options = listOf(
                "اللَّهُ",
                "الرَّحْمٰنُ",
                "رَبِّي",
                "إِلٰهِي"
        ),
        correctAnswer = "اللَّهُ"
    )
    )
}
