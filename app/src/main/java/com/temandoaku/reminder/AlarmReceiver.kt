package com.temandoaku.reminder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {

        Log.d("ALARM_TEST", "Alarm diterima")

        // tampilkan notifikasi
        NotificationHelper.showNotification(context)

        // SET ULANG alarm → bikin loop 1 jam
        ReminderHelper.setHourlyReminder(context)
    }
}
