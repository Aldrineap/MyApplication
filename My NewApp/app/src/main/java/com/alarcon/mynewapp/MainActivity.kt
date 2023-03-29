package com.alarcon.mynewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var logoImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var subtitleTextView1: TextView
    private lateinit var subtitleTextView2: TextView
    private lateinit var subtitleTextView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logoImageView = findViewById(R.id.logoImageView)
        titleTextView = findViewById(R.id.titleTextView)
        subtitleTextView1 = findViewById(R.id.subtitleTextView1)
        subtitleTextView2 = findViewById(R.id.subtitleTextView2)
        subtitleTextView3 = findViewById(R.id.subtitleTextView3)

        Handler().postDelayed({
            val intent = Intent(this, ActivitySignUp::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
