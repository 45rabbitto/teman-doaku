package com.temandoaku.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.MainActivity
import com.temandoaku.R
import com.temandoaku.SharedPrefManager
import com.temandoaku.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil skor dari intent
        val score = intent.getIntExtra("SCORE", 0)

        // Shared Preference Manager
        val sharedPrefManager = SharedPrefManager(this)

        // Game dianggap sudah dimainkan
        sharedPrefManager.incrementGamePlayed()

        // Jika skor menang (>= 80) → game menang
        if (score >= 80) {
            sharedPrefManager.incrementGameWon()
        }

        // Tampilkan skor
        binding.tvScore.text = "Skor: $score"

        // Tentukan pesan & icon berdasarkan skor
        when {
            score >= 80 -> {
                binding.tvMessage.text = "MasyaAllah! Hebat sekali 🌟"
                binding.ivResult.setImageResource(R.drawable.trophy_image)
            }
            score >= 50 -> {
                binding.tvMessage.text = "Bagus! Terus tingkatkan 👍"
                binding.ivResult.setImageResource(R.drawable.medal_image)
            }
            else -> {
                binding.tvMessage.text = "Ayo belajar lagi 💪"
                binding.ivResult.setImageResource(R.drawable.try_again_image)
            }
        }

        // Tombol Main Lagi
        binding.btnPlayAgain.setOnClickListener {
            finish() // kembali ke game sebelumnya
        }

        // Tombol Kembali ke Menu Utama
        binding.btnBackToMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
