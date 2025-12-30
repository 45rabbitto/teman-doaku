package com.temandoaku.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.databinding.ActivityResultBinding
import com.temandoaku.MainActivity
import com.temandoaku.R

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil skor dari intent
        val score = intent.getIntExtra("SCORE", 0)

        // Tampilkan skor
        binding.tvScore.text = "Skor: $score"

        // Tentukan pesan & icon berdasarkan skor
        when {
            score >= 80 -> {
                binding.tvMessage.text = "MasyaAllah! Hebat sekali 🌟"
                binding.ivResult.setImageResource(R.drawable.trophy)
            }
            score >= 50 -> {
                binding.tvMessage.text = "Bagus! Terus tingkatkan 👍"
                binding.ivResult.setImageResource(R.drawable.medal)
            }
            else -> {
                binding.tvMessage.text = "Ayo belajar lagi 💪"
                binding.ivResult.setImageResource(R.drawable.try_again)
            }
        }

        // Tombol Main Lagi
        binding.btnPlayAgain.setOnClickListener {
            finish() // balik ke game sebelumnya
        }

        // Tombol Kembali ke Menu
        binding.btnBackToMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
