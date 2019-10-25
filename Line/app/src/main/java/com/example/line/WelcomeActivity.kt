package com.example.line

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getSupportActionBar()?.hide()             //隱藏標題欄

        Thread{
            Thread.sleep(1500)
            runOnUiThread {
                startActivity(Intent(this,MainActivity::class.java))                 //開始切換頁面
            }
        }.start()

    }
}
