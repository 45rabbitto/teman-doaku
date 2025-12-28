package com.temandoaku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.temandoaku.data.AppDatabase
import com.temandoaku.data.DoaData
import com.temandoaku.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding HARUS di awal
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Room Database
        val db = AppDatabase.getDatabase(this)
        val dao = db.doaDao()

        lifecycleScope.launch {
            dao.insertAll(DoaData.getAll())
        }

        // Shared Preference
        sharedPrefManager = SharedPrefManager(this)
        sharedPrefManager.updateLoginStreak()

        // Animasi
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

        // Tampilkan streak
        val streak = sharedPrefManager.getLoginStreak()
        if (streak > 0) {
            binding.tvStreak.text = "🔥 Streak: $streak hari"
            binding.tvStreak.visibility = View.VISIBLE
        } else {
            binding.tvStreak.visibility = View.GONE
        }
    }
}
