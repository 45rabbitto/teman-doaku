package com.temandoaku.reminder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        Log.d("ALARM_TEST", "AlarmReceiver terpanggil")

        NotificationHelper.showNotification(context)

        // set ulang alarm untuk besok
        ReminderHelper.setDailyReminder(context)
    }
}

