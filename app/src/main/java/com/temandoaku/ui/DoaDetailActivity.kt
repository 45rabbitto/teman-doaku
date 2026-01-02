package com.temandoaku.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.temandoaku.R
import com.temandoaku.SharedPrefManager
import com.temandoaku.data.AppDatabase
import kotlinx.coroutines.launch

class DoaDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doa_detail)

        val doaId = intent.getIntExtra("DOA_ID", -1)

        // ================= BACK HANDLER (GESTURE + BUTTON) =================
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val dao = AppDatabase.getDatabase(this@DoaDetailActivity).doaDao()
                    val sharedPref = SharedPrefManager(this@DoaDetailActivity)

                    lifecycleScope.launch {
                        if (doaId != -1) {
                            // ✅ ROOM
                            dao.markAsRead(doaId)

                            // ✅ SHAREDPREF (UNTUK ACHIEVEMENT)
                            sharedPref.markDoaAsRead(doaId)
                        }

                        val unreadCount = dao.getUnreadCount()

                        if (unreadCount == 0) {
                            startActivity(
                                Intent(
                                    this@DoaDetailActivity,
                                    AchievementActivity::class.java
                                )
                            )
                            finish()
                        } else {
                            finish()
                        }
                    }
                }

            }
        )

        // ================= ISI DATA =================
        findViewById<TextView>(R.id.tvDoaTitle).text =
            intent.getStringExtra("DOA_TITLE")

        findViewById<TextView>(R.id.tvArabic).text =
            intent.getStringExtra("DOA_ARABIC")

        findViewById<TextView>(R.id.tvLatin).text =
            intent.getStringExtra("DOA_LATIN")

        findViewById<TextView>(R.id.tvTranslation).text =
            intent.getStringExtra("DOA_TRANSLATION")

        val imageRes = intent.getIntExtra("DOA_IMAGE", 0)
        val ivDoa = findViewById<ImageView>(R.id.ivDoaImage)

        if (imageRes != 0) {
            ivDoa.setImageResource(imageRes)
        } else {
            ivDoa.setImageResource(android.R.drawable.ic_menu_help)
        }

        // Tombol back UI
        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
