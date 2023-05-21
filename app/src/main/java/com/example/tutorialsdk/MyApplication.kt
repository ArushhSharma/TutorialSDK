package com.example.tutorialsdk
import android.app.Application
import com.moengage.core.DataCenter
import com.moengage.core.LogLevel.VERBOSE
import com.moengage.core.MoEngage
import com.moengage.core.analytics.MoEAnalyticsHelper
import com.moengage.core.config.FcmConfig
import com.moengage.core.config.LogConfig
import com.moengage.core.config.NotificationConfig
import com.moengage.core.enableAdIdTracking
import com.moengage.core.model.AppStatus


public class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        val moEngage = MoEngage.Builder(this, "BQBLHI0GC3I0GGOALY7AHWXL", DataCenter.DATA_CENTER_1)
            .configureNotificationMetaData(NotificationConfig(R.drawable.small_icon, R.drawable.large_icon))
            .configureLogs(LogConfig(VERBOSE))
            .configureFcm(FcmConfig(true))
            .build()
        MoEngage.initialiseDefaultInstance(moEngage)

    }

}