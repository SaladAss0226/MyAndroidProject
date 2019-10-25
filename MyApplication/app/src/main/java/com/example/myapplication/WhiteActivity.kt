package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat

class WhiteActivity : AppCompatActivity() {

    //先定義一個方法 設定intent會夾帶一個key過去mainActivity
    fun startTransition(flag:String) {
        val itt = Intent(this, MainActivity::class.java)
        itt.putExtra("flag", flag)
        startActivity(itt, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle())      //開始切換頁面去MainActivity
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_white)

        getSupportActionBar()?.hide()                     //隱藏標題欄

        Thread {
            //新建一個背景執行緒
            Thread.sleep(1000)                   //背景執行緒睡1.5秒
            runOnUiThread {                             //UI執行緒(主執行緒)執行動作
                startTransition("slide")           //呼叫startTransition來切換頁面
            }
        }.start()



    }
}
