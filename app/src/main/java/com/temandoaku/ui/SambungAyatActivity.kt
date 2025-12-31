package com.temandoaku.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.databinding.ActivitySambungAyatBinding
import com.temandoaku.data.SambungAyatQuestions
import com.temandoaku.ui.ResultActivity

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

        binding.btnOption1.setOnClickListener { checkAnswer(binding.btnOption1.text.toString()) }
        binding.btnOption2.setOnClickListener { checkAnswer(binding.btnOption2.text.toString()) }
        binding.btnOption3.setOnClickListener { checkAnswer(binding.btnOption3.text.toString()) }
        binding.btnOption4.setOnClickListener { checkAnswer(binding.btnOption4.text.toString()) }

        binding.ivBack.setOnClickListener { finish() }
    }

    private fun showQuestion() {
        val q = questions[index]

        binding.tvProgress.text = "${index + 1} / ${questions.size}"
        binding.tvAyatSoal.text = q.question

        binding.btnOption1.text = q.options[0]
        binding.btnOption2.text = q.options[1]
        binding.btnOption3.text = q.options[2]
        binding.btnOption4.text = q.options[3]
    }

    private fun checkAnswer(answer: String) {
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
