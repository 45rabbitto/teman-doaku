package com.temandoaku

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.temandoaku.data.DataSource
import com.temandoaku.data.Achievement

class SharedPrefManager(private val context: Context) {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("TemanDoakuPref", Context.MODE_PRIVATE)
    private val gson = Gson()

    // Keys
    private val KEY_DOA_READ = "doa_read"
    private val KEY_GAME_PLAYED = "game_played"
    private val KEY_LAST_LOGIN = "last_login"
    private val KEY_LOGIN_STREAK = "login_streak"
    private val KEY_UNLOCKED_ACHIEVEMENTS = "unlocked_achievements"

    /* =======================
       DOA READ
       ======================= */

    fun markDoaAsRead(doaId: Int) {
        val readDoas = getReadDoas().toMutableSet()
        readDoas.add(doaId)
        sharedPref.edit()
            .putString(KEY_DOA_READ, readDoas.joinToString(","))
            .apply()

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

    /* =======================
       GAME STATS
       ======================= */

    fun incrementGamePlayed() {
        val played = getGamesPlayed() + 1
        sharedPref.edit().putInt(KEY_GAME_PLAYED, played).apply()
        checkAchievements()
    }

    fun getGamesPlayed(): Int {
        return sharedPref.getInt(KEY_GAME_PLAYED, 0)
    }

    /* =======================
       LOGIN STREAK
       ======================= */

    fun updateLoginStreak() {
        val lastLogin = sharedPref.getLong(KEY_LAST_LOGIN, 0)
        val currentTime = System.currentTimeMillis()
        val oneDay = 24 * 60 * 60 * 1000L

        var streak = if (getLoginStreak() == 0) 1 else getLoginStreak()

        if (lastLogin == 0L || currentTime - lastLogin > oneDay * 2) {
            streak = 1
        } else if (currentTime - lastLogin > oneDay) {
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

    /* =======================
       ACHIEVEMENT
       ======================= */

    fun unlockAchievement(achievementId: Int) {
        val unlocked = getUnlockedAchievements().toMutableSet()
        if (achievementId !in unlocked) {
            unlocked.add(achievementId)
            val json = gson.toJson(unlocked)
            sharedPref.edit()
                .putString(KEY_UNLOCKED_ACHIEVEMENTS, json)
                .apply()
        }
    }

    fun getUnlockedAchievements(): Set<Int> {
        val json = sharedPref.getString(KEY_UNLOCKED_ACHIEVEMENTS, "[]")
        val type = object : TypeToken<Set<Int>>() {}.type
        return gson.fromJson(json, type) ?: emptySet()
    }

    private fun checkAchievements() {
        val readCount = getReadDoas().size
        val gamesPlayed = getGamesPlayed()
        val loginStreak = getLoginStreak()

        // Achievement 1: Baca 5 doa
        if (readCount >= 5) {
            unlockAchievement(1)
        }

        // Achievement 3: Main 3 game
        if (gamesPlayed >= 3) {
            unlockAchievement(3)
        }

        // Achievement 4: Login streak 7 hari
        if (loginStreak >= 7) {
            unlockAchievement(4)
        }

        // Achievement 5: Baca semua doa
        if (readCount >= DataSource.doaList.size) {
            unlockAchievement(5)
        }
    }

    fun getAllAchievementsWithStatus(): List<Achievement> {
        val unlockedIds = getUnlockedAchievements()
        return DataSource.achievements.map { achievement ->
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

    /* =======================
       RESET (Testing)
       ======================= */

    fun resetAllData() {
        sharedPref.edit().clear().apply()
    }
}
