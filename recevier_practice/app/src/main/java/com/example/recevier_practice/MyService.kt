package com.example.recevier_practice

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder

class MyService : Service() {
    companion object {           //companion object就是java中的static用法
        var flag: Boolean = false    //計數器狀態 預設成false
    }

    private var h =0         //計數器數值
    private var m =0
    private var s =0

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //啟動這個service時會呼叫onStartCommand方法
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        flag = intent!!.getBooleanExtra("flag",false)

        Thread(Runnable {

            while (flag){
                try {
                    Thread.sleep(1000)              //用Thread來計算秒數 延遲一秒
                }catch (e:InterruptedException){
                    e.printStackTrace()
                }
                s++                                 //計數器+1
                if(s>=60){
                    s=0;m++
                    if(m>=60){
                        m=0;h++
                    }
                }
                val i = Intent("MyMessage")        //產生帶MyMessage識別字串的intent
                val bb = Bundle()                         //把累加的值(經過的秒數)放入intent
                bb.putInt("H",h)
                bb.putInt("M",m)
                bb.putInt("S",s)
                i.putExtras(bb)

                sendBroadcast(i)                          //發送廣播給BroadcastReceiver
            }
        }).start()
        return Service.START_STICKY
    }
}
