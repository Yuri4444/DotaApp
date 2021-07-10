package com.berezhnoyyuri9999.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.berezhnoyyuri9999.dotaapp.R
import com.berezhnoyyuri9999.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.frMain, MainFragment()).commit()
    }
}