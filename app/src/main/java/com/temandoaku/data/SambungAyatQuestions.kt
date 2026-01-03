package com.temandoaku.data

import com.temandoaku.models.GameQuestion

object SambungAyatQuestions {

    val questions = listOf(

        // 1. Masuk rumah (a)
        GameQuestion(
            question = "السَّلَامُ",
            options = listOf(
                "عَلَيْكُمْ",      // a ✅
                "اللَّهُ",
                "لِلَّهِ",
                "رَبِّ"
            ),
            correctAnswer = "عَلَيْكُمْ"
        ),

        // 2. Keluar rumah (d)
        GameQuestion(
            question = "بِسْمِ اللَّهِ",
            options = listOf(
                "الْحَمْدُ لِلَّهِ",
                "أَعُوذُ بِكَ",
                "اغْفِرْ لِي",
                "تَوَكَّلْتُ عَلَى اللَّهِ" // d ✅
            ),
            correctAnswer = "تَوَكَّلْتُ عَلَى اللَّهِ"
        ),

        // 3. Menjawab salam (b)
        GameQuestion(
            question = "وَعَلَيْكُمُ",
            options = listOf(
                "اللَّهُ",
                "السَّلَامُ",     // b ✅
                "الْحَمْدُ",
                "رَبِّ"
            ),
            correctAnswer = "السَّلَامُ"
        ),

        // 4. Sesudah makan (a)
        GameQuestion(
            question = "الْحَمْدُ لِلَّهِ",
            options = listOf(
                "الَّذِي أَطْعَمَنَا", // a ✅
                "رَبِّ الْعَالَمِينَ",
                "عَلَيْكُمْ",
                "إِلَّا اللَّهُ"
            ),
            correctAnswer = "الَّذِي أَطْعَمَنَا"
        ),

        // 5. Masuk WC (c)
        GameQuestion(
            question = "اللَّهُمَّ إِنِّي",
            options = listOf(
                "تَوَكَّلْتُ عَلَى اللَّهِ",
                "أَشْهَدُ أَنْ",
                "أَعُوذُ بِكَ",   // c ✅
                "اغْفِرْ لِي"
            ),
            correctAnswer = "أَعُوذُ بِكَ"
        ),

        // 6. Akan tidur (d)
        GameQuestion(
            question = "بِاسْمِكَ",
            options = listOf(
                "أَحْيَا",
                "أَنَامُ",
                "أَسْتَيْقِظُ",
                "أَمُوتُ"        // d ✅
            ),
            correctAnswer = "أَمُوتُ"
        ),

        // 7. Birrul walidain (a)
        GameQuestion(
            question = "رَبِّ اغْفِرْ",
            options = listOf(
                "لِي وَلِوَالِدَيَّ", // a ✅
                "لَنَا ذُنُوبَنَا",
                "لِي ذَنْبِي",
                "لِلْمُؤْمِنِينَ"
            ),
            correctAnswer = "لِي وَلِوَالِدَيَّ"
        ),

        // 8. Keluar masjid (b)
        GameQuestion(
            question = "اللَّهُمَّ إِنِّي",
            options = listOf(
                "اغْفِرْ لِي",
                "أَسْأَلُكَ مِنْ فَضْلِكَ", // b ✅
                "أَعُوذُ بِكَ",
                "تَوَكَّلْتُ"
            ),
            correctAnswer = "أَسْأَلُكَ مِنْ فَضْلِكَ"
        ),

        // 9. Bangun tidur (c)
        GameQuestion(
            question = "الْحَمْدُ لِلَّهِ",
            options = listOf(
                "رَبِّ الْعَالَمِينَ",
                "مِنْ فَضْلِكَ",
                "الَّذِي أَحْيَانَا", // c ✅
                "الَّذِي أَطْعَمَنَا"
            ),
            correctAnswer = "الَّذِي أَحْيَانَا"
        ),

        // 10. Jawaban ketika mendengar orang bersin (d)
        GameQuestion(
            question = "يَرْحَمُكَ",
            options = listOf(
                "الرَّحْمٰنُ",
                "رَبِّي",
                "إِلٰهِي",
                "اللَّهُ"        // d ✅
            ),
            correctAnswer = "اللَّهُ"
        )
    )
}