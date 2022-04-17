package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flStartBtn : FrameLayout = findViewById(R.id.flStart)
        flStartBtn.setOnClickListener{

        }

    }
}