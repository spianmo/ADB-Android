package com.teamhelper.adb.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teamhelper.adb.R
import com.teamhelper.adb.fragments.HelpPreferenceFragment

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, HelpPreferenceFragment())
            .commit()
    }
}