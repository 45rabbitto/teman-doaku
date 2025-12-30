package com.temandoaku.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.data.SambungAyatQuestions
import com.temandoaku.databinding.ActivitySambungAyatBinding

class SambungAyatActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySambungAyatBinding
    private var index = 0
    private var score = 0

    private val questions = SambungAyatQuestions.questionsSambungAyat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySambungAyatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showQuestion()

        binding.btnA.setOnClickListener {
            onAnswerClicked(binding.btnA.text.toString())
        }

        binding.btnB.setOnClickListener {
            onAnswerClicked(binding.btnB.text.toString())
        }

        binding.btnC.setOnClickListener {
            onAnswerClicked(binding.btnC.text.toString())
        }

        binding.btnD.setOnClickListener {
            onAnswerClicked(binding.btnD.text.toString())
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun showQuestion() {
        val question = questions[index]

        binding.tvProgressSoal.text = "${index + 1} / ${questions.size}"
        binding.tvSoalAyat.text = question.question

        binding.btnA.text = question.options[0]
        binding.btnB.text = question.options[1]
        binding.btnC.text = question.options[2]
        binding.btnD.text = question.options[3]
    }

    private fun onAnswerClicked(answer: String) {
        if (answer == questions[index].correctAnswer) {
            score += 10
        }

        index++

        if (index < questions.size) {
            showQuestion()
        } else {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
            finish()
        }
    }
}
