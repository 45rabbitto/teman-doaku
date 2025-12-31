package com.temandoaku

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        NotificationHelper.showNotification(
            context,
            "Waktu Berdoa 🤲",
            "Jangan lupa berdoa hari ini bersama Teman Doaku"
        )
    }
}
