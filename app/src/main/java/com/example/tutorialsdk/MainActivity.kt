package com.example.tutorialsdk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.moengage.cards.ui.CardActivity
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper
import com.moengage.inapp.MoEInAppHelper
import com.moengage.inbox.ui.view.InboxActivity
import com.moengage.pushbase.MoEPushHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MoEPushHelper.getInstance().requestPushPermission(this)


        val attributeName = findViewById<TextView>(R.id.username)
        val attributeVal = findViewById<TextView>(R.id.password)
        val card = findViewById<View>(R.id.cards)
        val login = findViewById<View>(R.id.loginbtn) as MaterialButton
        val customat = findViewById<View>(R.id.customatt) as MaterialButton
        val properties = Properties()
        val s= attributeVal.text.toString()
        properties.addAttribute("Password", "${attributeVal.text.toString()}")
        val trackevent=findViewById<View>(R.id.TrackEvent)
        val notif = findViewById<View>(R.id.notif)

        notif.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, InboxActivity::class.java)
            startActivity(intent)

        })
        customat.setOnClickListener( View.OnClickListener{
            val intent2 = Intent(this, CustomAttribute::class.java )
            startActivity(intent2)
        })
        trackevent.setOnClickListener(View.OnClickListener {
            val intent1 = Intent(this, TrackEvent::class.java)
            startActivity(intent1)
        })
        login.setOnClickListener {
//            MoEAnalyticsHelper.setUniqueId(this, username.text.toString())
//            MoEAnalyticsHelper.setUserName(this, username.text.toString())
            MoEAnalyticsHelper.trackEvent(this, "Login", properties)
            MoEAnalyticsHelper.setUniqueId(this,attributeName.text.toString())
            MoEAnalyticsHelper.setFirstName(this,attributeName.text.toString())

            Log.d("MainActivity", attributeVal.text.toString())
            Toast.makeText(this, "Data Tracked", Toast.LENGTH_SHORT).show()



        }
        card.setOnClickListener{
            val intent = Intent(this, CardActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onStart(){
        super.onStart()
        MoEInAppHelper.getInstance().showInApp(this)
    }
}