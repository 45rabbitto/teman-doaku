package com.temandoaku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

import com.temandoaku.data.AppDatabase
import com.temandoaku.data.DoaData
import com.temandoaku.databinding.ActivityMainBinding
import com.temandoaku.ui.DoaListActivity
import com.temandoaku.ui.MinigameActivity
import com.temandoaku.ui.AchievementActivity
import com.temandoaku.reminder.ReminderHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔔 PASANG ALARM NOTIFIKASI (WAJIB)
        ReminderHelper.setDailyReminder(this)

        val dao = AppDatabase.getDatabase(this).doaDao()
        lifecycleScope.launch {
            val count = dao.getCount()
            if (count == 0) {
                dao.insertAll(DoaData.getAll())
            }
        }

        sharedPrefManager = SharedPrefManager(this)
        sharedPrefManager.updateLoginStreak()

        val scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        val scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down)

        binding.cvDoa.setOnClickListener {
            it.startAnimation(scaleUp)
            it.startAnimation(scaleDown)
            startActivity(Intent(this, DoaListActivity::class.java))
        }

        binding.cvGame.setOnClickListener {
            it.startAnimation(scaleUp)
            it.startAnimation(scaleDown)
            startActivity(Intent(this, MinigameActivity::class.java))
        }

        binding.cvAchievement.setOnClickListener {
            it.startAnimation(scaleUp)
            it.startAnimation(scaleDown)
            startActivity(Intent(this, AchievementActivity::class.java))
        }

        val streak = sharedPrefManager.getLoginStreak()
        if (streak > 0) {
            binding.tvStreak.text = "🔥 Streak: $streak hari"
            binding.tvStreak.visibility = View.VISIBLE
        } else {
            binding.tvStreak.visibility = View.GONE
        }
    }
}
