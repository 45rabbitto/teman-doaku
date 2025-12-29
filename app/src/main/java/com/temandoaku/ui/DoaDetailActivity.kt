package com.temandoaku.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.R

class DoaDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doa_detail)

        findViewById<TextView>(R.id.tvDoaTitle).text =
            intent.getStringExtra("DOA_TITLE")


        findViewById<TextView>(R.id.tvArabic).text =
            intent.getStringExtra("DOA_ARABIC")

        findViewById<TextView>(R.id.tvLatin).text =
            intent.getStringExtra("DOA_LATIN")

        findViewById<TextView>(R.id.tvTranslation).text =
            intent.getStringExtra("DOA_TRANSLATION")

        val imageRes = intent.getIntExtra("DOA_IMAGE", 0)
        if (imageRes != 0) {
            findViewById<ImageView>(R.id.ivDoaImage)
                .setImageResource(imageRes)
        }

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }
    }
}
