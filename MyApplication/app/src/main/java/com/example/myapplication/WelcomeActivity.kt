package com.example.myapplication

import android.content.Intent
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WelcomeActivity : AppCompatActivity() {

    private var cat :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var sp = SoundPool.Builder().setMaxStreams(8).build()    //建立soundPool物件 sp
        sp.setOnLoadCompleteListener { soundPool, sampleId, status ->        //設定一個監聽器 當這個音效檔被載入完成的時候會觸發這個監聽器
                                                                             // (但你不知道什麼時候會載入完成 你無法控制那個時間長短)
            if(Build.VERSION.SDK_INT>=21)                                   //若android SDK version為21以上
                soundPool.play(cat,1.0f,1.0f,2,0,1.0f)

        }
        cat = sp.load(this, R.raw.cat, 1)

        getSupportActionBar()?.hide()             //隱藏標題欄

        Thread{
            Thread.sleep(1500)
            runOnUiThread {
                startActivity(Intent(this,WhiteActivity::class.java))                 //開始切換頁面
                overridePendingTransition(0,android.R.anim.fade_out)
                //畫面淡出
            }
        }.start()
    }
}
