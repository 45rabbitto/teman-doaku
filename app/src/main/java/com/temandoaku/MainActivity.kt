package com.temandoaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.temandoaku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi SharedPrefManager dengan context
        sharedPrefManager = SharedPrefManager(this)

        // Update login streak setiap kali app dibuka
        sharedPrefManager.updateLoginStreak()

        // Load animasi dari resources
        val scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        val scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down)

        // Tombol Kumpulan Doa
        binding.cvDoa.setOnClickListener {
            it.startAnimation(scaleUp)
            it.startAnimation(scaleDown)
            startActivity(Intent(this, DoaListActivity::class.java))
        }

        // Tombol Mini Game
        binding.cvGame.setOnClickListener {
            it.startAnimation(scaleUp)
            it.startAnimation(scaleDown)
            startActivity(Intent(this, MinigameActivity::class.java))
        }

        // Tombol Achievement
        binding.cvAchievement.setOnClickListener {
            it.startAnimation(scaleUp)
            it.startAnimation(scaleDown)
            startActivity(Intent(this, AchievementActivity::class.java))
        }

        // Tampilkan streak di main activity jika ada
        val streak = sharedPrefManager.getLoginStreak()
        if (streak > 0) {
            binding.tvStreak.text = "Streak: $streak hari"
            binding.tvStreak.visibility = android.view.View.VISIBLE
        }
    }
}