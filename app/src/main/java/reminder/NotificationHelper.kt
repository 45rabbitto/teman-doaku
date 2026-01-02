package com.temandoaku.reminder

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.temandoaku.R

object NotificationHelper {

    private const val CHANNEL_ID = "daily_reminder"

    fun showNotification(context: Context) {

        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Pengingat Doa Harian",
                NotificationManager.IMPORTANCE_HIGH
            )
            manager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Teman teman 🤍")
            .setContentText("Jangan lupa doa hari ini ya")
            .setAutoCancel(true)
            .build()

        manager.notify(1001, notification)
    }
}
