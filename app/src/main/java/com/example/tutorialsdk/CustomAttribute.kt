package com.example.tutorialsdk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper

class CustomAttribute : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_attribute)
        val attributeName = findViewById<TextView>(R.id.username)
        val attributeVal = findViewById<TextView>(R.id.password)

        val login = findViewById<View>(R.id.loginbtn) as MaterialButton
        val properties = Properties()
        properties.addAttribute("Password", attributeVal.text.toString())
        val back= findViewById<View>(R.id.goback) as MaterialButton

        back.setOnClickListener(View.OnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        login.setOnClickListener {
//            MoEAnalyticsHelper.setUniqueId(this, attributeName.text.toString())
//            MoEAnalyticsHelper.setUserName(this, attributeVal.text.toString())
            MoEAnalyticsHelper.setUserAttribute(this,attributeName.text.toString(), attributeVal.text.toString())
            Toast.makeText(this, "Data Tracked", Toast.LENGTH_SHORT).show()


//            Log.d("MainActivity",username.text.toString())


        }
    }
}