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
    private val questions = SambungAyatQuestions.questions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySambungAyatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showQuestion()

        binding.btnOption1.setOnClickListener { checkAnswer(binding.btnOption1.text.toString()) }
        binding.btnOption2.setOnClickListener { checkAnswer(binding.btnOption2.text.toString()) }
        binding.btnOption3.setOnClickListener { checkAnswer(binding.btnOption3.text.toString()) }
        binding.btnOption4.setOnClickListener { checkAnswer(binding.btnOption4.text.toString()) }

         binding.btnFinish.setOnClickListener {
            goToResult()
        }

        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun showQuestion() {
        val q = questions[index]

        binding.tvProgress.text = "Soal ${index + 1} / ${questions.size}"
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
            goToResult()
        }
    }

    private fun goToResult() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("SCORE", score)
        startActivity(intent)
    }
}
