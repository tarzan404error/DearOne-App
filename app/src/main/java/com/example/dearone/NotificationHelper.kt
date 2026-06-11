package com.example.dearone

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationHelper {

    private const val CHANNEL_ID = "dearone_channel"

    fun showNotification(
        context: Context,
        title: String,
        message: String
    ) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                CHANNEL_ID,
                "DearOne Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )

            val manager =
                context.getSystemService(
                    Context.NOTIFICATION_SERVICE
                ) as NotificationManager

            manager.createNotificationChannel(channel)
        }

        val notification =
            NotificationCompat.Builder(
                context,
                CHANNEL_ID
            )
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(
                    NotificationCompat.PRIORITY_HIGH
                )
                .build()

        NotificationManagerCompat
            .from(context)
            .notify(
                1001,
                notification
            )
    }
}