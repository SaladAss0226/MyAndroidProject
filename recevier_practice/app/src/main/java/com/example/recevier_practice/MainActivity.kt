package com.example.recevier_practice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var flagg = false

    //建立broadcastRecevier物件 加入接收廣播後要執行的動作
    private val r = object :BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            //解析intent取得秒數資訊
            intent?.extras?.let{
                tv_clock.text = "%02d:%02d:%02d".format(it.getInt("H"),it.getInt("M"),it.getInt("S"))

                //%d表示數字佔位 %02d表示給予兩個數字的位置
            }
        }
    }

    //onCreate裡面要做的事是 註冊broadcastRecevier物件r 並啟動service
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //建立intentFilter來指定要接收的廣播的識別字串
        val intentFilter = IntentFilter("MyMessage")
        //註冊recevier
        registerReceiver(r,intentFilter)

        //取得service狀態
        flagg = MyService.flag

        btn_start.text = if(flagg) "暫停" else "開始"

        btn_start.setOnClickListener {
            flagg =!flagg
            btn_start.text = if(flagg) "暫停" else "開始"

            //啟動service
            startService(Intent(this,MyService::class.java).putExtra("flag",flagg))
            Toast.makeText(this,if(flagg) "計時開始" else "計時暫停",Toast.LENGTH_SHORT)
        }
    }

    //註銷廣播
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(r)

    }
}
