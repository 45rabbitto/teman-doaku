package com.temandoaku

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.databinding.ActivityMinigameBinding

class MinigameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMinigameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMinigameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol kembali
        binding.ivBack.setOnClickListener {
            finish()
        }

        // Pilihan Game 1: Tebak Arti
        binding.btnTebakArti.setOnClickListener {
            startActivity(Intent(this, TebakArtiActivity::class.java))
        }

        // Pilihan Game 2: Sambung Ayat
        binding.btnSambungAyat.setOnClickListener {
            startActivity(Intent(this, SambungAyatActivity::class.java))
        }
    }
}
