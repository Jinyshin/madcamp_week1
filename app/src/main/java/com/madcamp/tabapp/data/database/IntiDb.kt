package com.madcamp.tabapp.data.database

import android.app.Application

class InitDb : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = AppDatabase.getDatabase(this)
    }
}
