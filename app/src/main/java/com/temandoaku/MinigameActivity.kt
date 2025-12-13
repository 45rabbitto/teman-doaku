package com.temandoaku

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.databinding.ActivityMinigameBinding

class MinigameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMinigameBinding
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMinigameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefManager = SharedPrefManager(this)

        // Tombol kembali
        binding.ivBack.setOnClickListener {
            finish()
        }

        setupSimpleGame()
    }

    private fun setupSimpleGame() {
        // Game puzzle sederhana - tebak doa
        binding.tvQuestion.text = "Tebak doa sebelum makan:"
        binding.tvAyatTarget.text = "بِسْمِ اللهِ"

        val options = listOf("Dengan nama Allah", "Segala puji bagi Allah", "Ya Allah lindungi aku")
        val correctAnswer = "Dengan nama Allah"

        // Setup tombol pilihan
        binding.btnOption1.text = options[0]
        binding.btnOption2.text = options[1]
        binding.btnOption3.text = options[2]

        binding.btnOption1.setOnClickListener {
            checkAnswer(options[0], correctAnswer)
        }

        binding.btnOption2.setOnClickListener {
            checkAnswer(options[1], correctAnswer)
        }

        binding.btnOption3.setOnClickListener {
            checkAnswer(options[2], correctAnswer)
        }
    }

    private fun checkAnswer(selected: String, correct: String) {
        if (selected == correct) {
            Toast.makeText(this, "🎉 Benar! +10 Poin", Toast.LENGTH_SHORT).show()
            sharedPrefManager.incrementGamePlayed()
            sharedPrefManager.incrementGameWon()
        } else {
            Toast.makeText(this, "❌ Salah, coba lagi!", Toast.LENGTH_SHORT).show()
            sharedPrefManager.incrementGamePlayed()
        }
    }
}