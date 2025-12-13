package com.temandoaku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.databinding.ActivityDoaDetailBinding

class DoaDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoaDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol kembali
        binding.ivBack.setOnClickListener {
            finish()
        }

        // Ambil data dari intent
        val title = intent.getStringExtra("DOA_TITLE") ?: "Doa"
        val arabic = intent.getStringExtra("DOA_ARABIC") ?: ""
        val latin = intent.getStringExtra("DOA_LATIN") ?: ""
        val translation = intent.getStringExtra("DOA_TRANSLATION") ?: ""
        val imageResId = intent.getIntExtra("DOA_IMAGE", android.R.drawable.ic_menu_help)

        // Tampilkan data
        binding.ivDoaImage.setImageResource(imageResId)
        binding.tvDoaTitle.text = title
        binding.tvArabic.text = arabic
        binding.tvLatin.text = latin
        binding.tvTranslation.text = translation
    }
}