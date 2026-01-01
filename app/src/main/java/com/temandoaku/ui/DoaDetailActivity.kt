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

        val title = intent.getStringExtra("DOA_TITLE")
        val arabic = intent.getStringExtra("DOA_ARABIC")
        val latin = intent.getStringExtra("DOA_LATIN")
        val translation = intent.getStringExtra("DOA_TRANSLATION")
        val imageRes = intent.getIntExtra("DOA_IMAGE", 0)

        findViewById<TextView>(R.id.tvDoaTitle).text = title
        findViewById<TextView>(R.id.tvArabic).text = arabic
        findViewById<TextView>(R.id.tvLatin).text = latin
        findViewById<TextView>(R.id.tvTranslation).text = translation

        val ivDoa = findViewById<ImageView>(R.id.ivDoaImage)

        if (imageRes != 0) {
            ivDoa.setImageResource(imageRes)

        } else {
            ivDoa.setImageResource(android.R.drawable.ic_menu_help)
        }

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }
    }
}
