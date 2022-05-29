package com.example.workoutapp

import android.app.Application

class WorkoutApp: Application() {

    val db:HistoryDatabase by lazy {
        HistoryDatabase.getInstance(this)
    }
}