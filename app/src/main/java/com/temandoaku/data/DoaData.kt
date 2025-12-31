package com.temandoaku.data

import com.temandoaku.R

object DoaData {

    fun getAll(): List<DoaEntity> {
        return listOf(

            // 1. Masuk Rumah
            DoaEntity(
                judul = "Masuk Rumah",
                arab = "بِسْمِ اللَّهِ وَلَجْنَا، وَبِسْمِ اللَّهِ خَرَجْنَا، وَعَلَى رَبِّنَا تَوَكَّلْنَا",
                latin = "Bismillāhi walajnā, wa bismillāhi kharajnā, wa ‘alā rabbinā tawakkalnā",
                arti = "Dengan nama Allah kami masuk, dengan nama Allah kami keluar, dan kepada Allah Tuhan kami, kami bertawakal.",
                imageRes = R.drawable.doa_masuk_rumah
            ),

            // 2. Keluar Rumah
            DoaEntity(
                judul = "Keluar Rumah",
                arab = "بِسْمِ اللَّهِ، تَوَكَّلْتُ عَلَى اللَّهِ، لَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّهِ",
                latin = "Bismillāh, tawakkaltu ‘alallāh, lā ḥaula wa lā quwwata illā billāh",
                arti = "Dengan nama Allah, aku bertawakal kepada Allah. Tidak ada daya dan kekuatan kecuali dengan pertolongan Allah.",
                imageRes = R.drawable.doa_keluar_rumah
            ),

            // 3. Sebelum Makan
            DoaEntity(
                judul = "Sebelum Makan",
                arab = "اللَّهُمَّ بَارِكْ لَنَا فِيمَا رَزَقْتَنَا وَقِنَا عَذَابَ النَّارِ",
                latin = "Allāhumma bārik lanā fīmā razaqtanā wa qinā ‘adzāban-nār",
                arti = "Ya Allah, berkahilah kami dalam rezeki yang Engkau berikan dan lindungilah kami dari azab neraka.",
                imageRes = R.drawable.doa_makan
            ),

            // 4. Sesudah Makan
            DoaEntity(
                judul = "Sesudah Makan",
                arab = "الْحَمْدُ لِلَّهِ الَّذِي أَطْعَمَنَا وَسَقَانَا وَجَعَلَنَا مُسْلِمِينَ",
                latin = "Alḥamdulillāhilladzī aṭ‘amanā wa saqānā wa ja‘alanā muslimīn",
                arti = "Segala puji bagi Allah yang telah memberi kami makan dan minum serta menjadikan kami orang-orang muslim.",
                imageRes = R.drawable.doa_sesudah_makan
            ),

            // 5. Salam
            DoaEntity(
                judul = "Salam",
                arab = "السَّلَامُ عَلَيْكُمْ وَرَحْمَةُ اللَّهِ وَبَرَكَاتُهُ",
                latin = "Assalāmu‘alaikum wa raḥmatullāhi wa barakātuh",
                arti = "Semoga keselamatan, rahmat, dan berkah Allah tercurah kepada kalian.",
                imageRes = R.drawable.doa_salam
            ),

            // 6. Menjawab Salam
            DoaEntity(
                judul = "Menjawab Salam",
                arab = "وَعَلَيْكُمُ السَّلَامُ وَرَحْمَةُ اللَّهِ وَبَرَكَاتُهُ",
                latin = "Wa‘alaikumussalām wa raḥmatullāhi wa barakātuh",
                arti = "Dan semoga keselamatan, rahmat, dan berkah Allah juga tercurah kepada kalian.",
                imageRes = R.drawable.doa_menjawab_salam
            ),

            // 7. Birrul Walidain
            DoaEntity(
                judul = "Birrul Walidain",
                arab = "رَبِّ اغْفِرْ لِي وَلِوَالِدَيَّ وَارْحَمْهُمَا كَمَا رَبَّيَانِي صَغِيرًا",
                latin = "Rabbighfir lī wa liwālidayya warḥamhumā kamā rabbayānī ṣaghīrā",
                arti = "Ya Tuhanku, ampunilah aku dan kedua orang tuaku, dan sayangilah mereka sebagaimana mereka menyayangiku di waktu kecil.",
                imageRes = R.drawable.doa_birrul_walidain
            ),

            // 8. Masuk WC
            DoaEntity(
                judul = "Masuk WC",
                arab = "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْخُبُثِ وَالْخَبَائِثِ",
                latin = "Allāhumma innī a‘ūdzu bika minal khubutsi wal khabā’its",
                arti = "Ya Allah, aku berlindung kepada-Mu dari godaan setan laki-laki dan perempuan.",
                imageRes = R.drawable.doa_masuk_wc
            ),

            // 9. Bersuci
            DoaEntity(
                judul = "Bersuci",
                arab = "اللَّهُمَّ اجْعَلْنِي مِنَ التَّوَّابِينَ وَاجْعَلْنِي مِنَ الْمُتَطَهِّرِينَ",
                latin = "Allāhummaj‘alnī minat tawwābīn waj‘alnī minal mutaṭahhirīn",
                arti = "Ya Allah, jadikanlah aku termasuk orang-orang yang bertaubat dan bersuci.",
                imageRes = R.drawable.doa_bersuci
            ),

            // 10. Keluar WC
            DoaEntity(
                judul = "Keluar WC",
                arab = "غُفْرَانَكَ",
                latin = "Ghufrānak",
                arti = "Aku memohon ampunan-Mu, ya Allah.",
                imageRes = R.drawable.doa_masuk_wc
            ),

            // 11. Masuk Masjid
            DoaEntity(
                judul = "Masuk Masjid",
                arab = "اللَّهُمَّ افْتَحْ لِي أَبْوَابَ رَحْمَتِكَ",
                latin = "Allāhummaftaḥ lī abwāba raḥmatik",
                arti = "Ya Allah, bukakanlah bagiku pintu-pintu rahmat-Mu.",
                imageRes = R.drawable.doa_masuk_masjid
            ),

            // 12. Keluar Masjid
            DoaEntity(
                judul = "Keluar Masjid",
                arab = "اللَّهُمَّ إِنِّي أَسْأَلُكَ مِنْ فَضْلِكَ",
                latin = "Allāhumma innī as’aluka min faḍlik",
                arti = "Ya Allah, aku memohon karunia dari-Mu.",
                imageRes = R.drawable.doa_keluar_masjid
            ),

            // 13. Doa Berjanji
            DoaEntity(
                judul = "Doa Berjanji",
                arab = "اللَّهُمَّ إِنِّي أُعَاهِدُكَ عَلَى طَاعَتِكَ مَا اسْتَطَعْتُ",
                latin = "Allāhumma innī u‘āhiduka ‘alā ṭā‘atika mā istaṭa‘tu",
                arti = "Ya Allah, aku berjanji kepada-Mu untuk taat kepada-Mu semampuku.",
                imageRes = R.drawable.doa_berjanji
            ),

            // 14. Doa Bersin
            DoaEntity(
                judul = "Doa Bersin",
                arab = "الْحَمْدُ لِلَّهِ",
                latin = "Alḥamdulillāh",
                arti = "Segala puji bagi Allah.",
                imageRes = R.drawable.doa_bersin
            ),

            // 15. Mendengar Bersin
            DoaEntity(
                judul = "Mendengar Bersin",
                arab = "يَرْحَمُكَ اللَّهُ",
                latin = "Yarḥamukallāh",
                arti = "Semoga Allah merahmatimu.",
                imageRes = R.drawable.doa_mendengar_bersin
            ),

            // 16. Jawab Bersin
            DoaEntity(
                judul = "Jawab Bersin",
                arab = "يَهْدِيكُمُ اللَّهُ وَيُصْلِحُ بَالَكُمْ",
                latin = "Yahdīkumullāh wa yuṣliḥu bālakum",
                arti = "Semoga Allah memberi petunjuk kepadamu dan memperbaiki keadaanmu.",
                imageRes = R.drawable.doa_jawab_bersin
            ),

            // 17. Bercermin
            DoaEntity(
                judul = "Bercermin",
                arab = "اللَّهُمَّ كَمَا حَسَّنْتَ خَلْقِي فَحَسِّنْ خُلُقِي",
                latin = "Allāhumma kamā ḥassanta khalqī faḥassin khuluqī",
                arti = "Ya Allah, sebagaimana Engkau memperindah rupaku, maka perindahlah akhlakku.",
                imageRes = R.drawable.doa_bercermin
            ),

            // 18. Akan Tidur
            DoaEntity(
                judul = "Akan Tidur",
                arab = "بِاسْمِكَ اللَّهُمَّ أَحْيَا وَأَمُوتُ",
                latin = "Bismikallāhumma aḥyā wa amūt",
                arti = "Dengan nama-Mu ya Allah aku hidup dan aku mati.",
                imageRes = R.drawable.doa_akan_tidur
            ),

            // 19. Bangun Tidur
            DoaEntity(
                judul = "Bangun Tidur",
                arab = "الْحَمْدُ لِلَّهِ الَّذِي أَحْيَانَا بَعْدَ مَا أَمَاتَنَا",
                latin = "Alḥamdulillāhilladzī aḥyānā ba‘da mā amātanā",
                arti = "Segala puji bagi Allah yang menghidupkan kami setelah mematikan kami.",
                imageRes = R.drawable.doa_bangun_tidur
            ),

            // 20. Naik Kendaraan
            DoaEntity(
                judul = "Naik Kendaraan",
                arab = "سُبْحَانَ الَّذِي سَخَّرَ لَنَا هَذَا وَمَا كُنَّا لَهُ مُقْرِنِينَ",
                latin = "Subḥānalladzī sakhkhara lanā hādzā wa mā kunnā lahu muqrinīn",
                arti = "Maha suci Allah yang telah menundukkan kendaraan ini bagi kami.",
                imageRes = R.drawable.doa_naik_kendaraan
            )
        )
    }
}
