package com.temandoaku.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.data.TebakArtiQuestions
import com.temandoaku.databinding.ActivityGameBinding

class TebakArtiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private var index = 0
    private var score = 0
    private val questions = TebakArtiQuestions.questions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showQuestion()

        binding.btnOption1.setOnClickListener { checkAnswer(it as String) }
        binding.btnOption2.setOnClickListener { checkAnswer(it as String) }
        binding.btnOption3.setOnClickListener { checkAnswer(it as String) }
    }

    private fun showQuestion() {
        val q = questions[index]
        binding.tvQuestionNumber.text = "Soal ${index + 1} / ${questions.size}"
        binding.tvQuestion.text = q.question
        binding.btnOption1.text = q.options[0]
        binding.btnOption2.text = q.options[1]
        binding.btnOption3.text = q.options[2]
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
