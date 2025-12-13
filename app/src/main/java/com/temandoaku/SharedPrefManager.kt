package com.temandoaku

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPrefManager(private val context: Context) {

    private val sharedPref: SharedPreferences = context.getSharedPreferences("TemanDoakuPref", Context.MODE_PRIVATE)
    private val gson = Gson()

    // Constants
    private val KEY_DOA_READ = "doa_read"
    private val KEY_GAME_PLAYED = "game_played"
    private val KEY_GAME_WON = "game_won"
    private val KEY_LAST_LOGIN = "last_login"
    private val KEY_LOGIN_STREAK = "login_streak"
    private val KEY_UNLOCKED_ACHIEVEMENTS = "unlocked_achievements"

    // Menandai doa yang sudah dibaca
    fun markDoaAsRead(doaId: Int) {
        val readDoas = getReadDoas().toMutableSet()
        readDoas.add(doaId)
        sharedPref.edit().putString(KEY_DOA_READ, readDoas.joinToString(",")).apply()
        checkAchievements()
    }

    fun getReadDoas(): Set<Int> {
        val doasString = sharedPref.getString(KEY_DOA_READ, "")
        return if (doasString.isNullOrEmpty()) {
            emptySet()
        } else {
            doasString.split(",").mapNotNull { it.toIntOrNull() }.toSet()
        }
    }

    // Game stats
    fun incrementGamePlayed() {
        val played = getGamesPlayed() + 1
        sharedPref.edit().putInt(KEY_GAME_PLAYED, played).apply()
        checkAchievements()
    }

    fun getGamesPlayed(): Int {
        return sharedPref.getInt(KEY_GAME_PLAYED, 0)
    }

    fun incrementGameWon() {
        val won = getGamesWon() + 1
        sharedPref.edit().putInt(KEY_GAME_WON, won).apply()
        checkAchievements()
    }

    fun getGamesWon(): Int {
        return sharedPref.getInt(KEY_GAME_WON, 0)
    }

    // Login streak
    fun updateLoginStreak() {
        val lastLogin = sharedPref.getLong(KEY_LAST_LOGIN, 0)
        val currentTime = System.currentTimeMillis()
        val oneDay = 24 * 60 * 60 * 1000L

        var streak = getLoginStreak()

        if (lastLogin == 0L || currentTime - lastLogin > oneDay * 2) {
            // Reset streak jika lewat lebih dari 2 hari
            streak = 1
        } else if (currentTime - lastLogin > oneDay) {
            // Tambah streak jika login hari berikutnya
            streak += 1
        }

        sharedPref.edit()
            .putLong(KEY_LAST_LOGIN, currentTime)
            .putInt(KEY_LOGIN_STREAK, streak)
            .apply()

        checkAchievements()
    }

    fun getLoginStreak(): Int {
        return sharedPref.getInt(KEY_LOGIN_STREAK, 0)
    }

    // Achievement management
    fun unlockAchievement(achievementId: Int) {
        val unlocked = getUnlockedAchievements().toMutableSet()
        unlocked.add(achievementId)
        val unlockedJson = gson.toJson(unlocked)
        sharedPref.edit().putString(KEY_UNLOCKED_ACHIEVEMENTS, unlockedJson).apply()
    }

    fun getUnlockedAchievements(): Set<Int> {
        val unlockedJson = sharedPref.getString(KEY_UNLOCKED_ACHIEVEMENTS, "[]")
        val type = object : TypeToken<Set<Int>>() {}.type
        return gson.fromJson(unlockedJson, type) ?: emptySet()
    }

    // Check and update achievements based on current stats
    private fun checkAchievements() {
        val readCount = getReadDoas().size
        val gamesPlayed = getGamesPlayed()
        val gamesWon = getGamesWon()
        val loginStreak = getLoginStreak()

        // Achievement 1: Baca 5 doa
        if (readCount >= 5) {
            unlockAchievement(1)
        }

        // Achievement 2: Baca semua doa harian (misal 8 doa pertama)
        if (readCount >= 8) {
            unlockAchievement(2)
        }

        // Achievement 3: Main 3 game
        if (gamesPlayed >= 3) {
            unlockAchievement(3)
        }

        // Achievement 4: Login streak 7 hari
        if (loginStreak >= 7) {
            unlockAchievement(4)
        }

        // Achievement 5: Baca semua kategori (baca semua doa)
        if (readCount >= DataSource.doaList.size) {
            unlockAchievement(5)
        }

        // Achievement 6: Menang game
        if (gamesWon >= 1) {
            unlockAchievement(6)
        }
    }

    // Get all achievements with current status
    fun getAllAchievementsWithStatus(): List<Achievement> {
        val unlockedIds = getUnlockedAchievements()
        return DataSource.achievements.map { achievement ->
            // Buat achievement baru dengan status unlocked
            Achievement(
                id = achievement.id,
                title = achievement.title,
                description = achievement.description,
                iconResId = achievement.iconResId,
                isUnlocked = achievement.id in unlockedIds,
                type = achievement.type
            )
        }
    }

    // Reset all data (untuk testing)
    fun resetAllData() {
        sharedPref.edit().clear().apply()
    }
}