package com.temandoaku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.ui.ResultActivity

class TebakArtiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tebak_arti)

        val btnFinish = findViewById<Button>(R.id.btnFinish)

        btnFinish.setOnClickListener {
            val score = 80

            val intent = Intent(
                this@TebakArtiActivity,
                ResultActivity::class.java
            )
            intent.putExtra("SCORE", score)
            startActivity(intent)
        }
    }
}
