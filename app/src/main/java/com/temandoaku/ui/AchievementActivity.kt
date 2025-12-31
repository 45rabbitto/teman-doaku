package com.temandoaku.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.temandoaku.R
import com.temandoaku.SharedPrefManager
import com.temandoaku.databinding.ActivityAchievementBinding

class AchievementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAchievementBinding
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityAchievementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi SharedPrefManager
        sharedPrefManager = SharedPrefManager(this)

        // Tombol kembali
        binding.ivBack.setOnClickListener {
            finish()
        }

        loadAchievements()
        updateStats()
    }

    private fun loadAchievements() {
        val achievements = sharedPrefManager.getAllAchievementsWithStatus()

        // Clear container
        binding.llAchievements.removeAllViews()

        achievements.forEach { achievement ->
            // Buat view untuk setiap achievement
            val achievementView = layoutInflater.inflate(
                R.layout.item_achievement,
                binding.llAchievements,
                false
            )

            val tvTitle = achievementView.findViewById<TextView>(R.id.tvTitle)
            val tvDescription = achievementView.findViewById<TextView>(R.id.tvDescription)
            val ivIcon = achievementView.findViewById<ImageView>(R.id.ivIcon)
            val tvLocked = achievementView.findViewById<TextView>(R.id.tvLocked)

            tvTitle.text = achievement.title
            tvDescription.text = achievement.description
            ivIcon.setImageResource(achievement.iconResId)

            if (achievement.isUnlocked) {
                tvLocked.visibility = View.GONE
                achievementView.alpha = 1.0f
            } else {
                tvLocked.visibility = View.VISIBLE
                achievementView.alpha = 0.5f
            }

            binding.llAchievements.addView(achievementView)
        }
    }

    private fun updateStats() {
        val readCount = sharedPrefManager.getReadDoas().size
        val gamesPlayed = sharedPrefManager.getGamesPlayed()
        val streak = sharedPrefManager.getLoginStreak()

        binding.tvDoaRead.text = "Doa dibaca: $readCount"
        binding.tvGamesPlayed.text = "Game dimainkan: $gamesPlayed"
        binding.tvStreak.text = "Login streak: $streak hari"
    }
}