package com.example.tutorialsdk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper


class TrackEvent : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.track_event)
            val eventname=findViewById<TextView>(R.id.eventname)
            val attriname= findViewById<TextView>(R.id.attributename)
            val attrival = findViewById<TextView>(R.id.attributeval)
            val properties = Properties()
            properties
                // tracking integer
                .addAttribute(attriname.text.toString(), attrival.text.toString())


            val back = findViewById<View>(R.id.goback) as MaterialButton
            val track = findViewById<View>(R.id.datarack)as MaterialButton
            back.setOnClickListener(View.OnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            })
            track.setOnClickListener(View.OnClickListener {
                MoEAnalyticsHelper.trackEvent(this, eventname.text.toString(), properties)
                Toast.makeText(this, "Data Tracked", Toast.LENGTH_SHORT).show()


            })


        }
    }