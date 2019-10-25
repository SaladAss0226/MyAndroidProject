package com.example.animal_racing

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //建立兩個計數器 計算兩者的進度
     var rabbitProgress = 0
     var turtleProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            btn_start.isEnabled = false
            //初始化烏龜與兔子的進度
            rabbitProgress = 0
            turtleProgress = 0

            //執行副程式來執行Thread和AsyncTask
            runThread()
            runAsyncTask()
        }
    }

    //建立一個Thread來模擬兔子的移動 每0.1秒隨機增加計數器0-2的值 透過Handler來傳遞資料
    fun runThread(){
        object :Thread(){
            override fun run() {                                     //覆寫方法run
                while (rabbitProgress<=100&&turtleProgress<100){
                    try {
                        Thread.sleep(100)  //睡0.1秒
                    }catch (e:InterruptedException){
                        e.printStackTrace()
                    }
                    rabbitProgress += (Math.random()*3).toInt()     //隨機增加計數器0-2的值
                    val msg = Message()
                    msg.what = 1                        //加入代號
                    mHandler.sendMessage(msg)          //傳送訊息給mHandler
                }
            }
        }.start()
    }

    //建立Handler物件等待接收訊息
    private val mHandler = Handler(Handler.Callback {msg->
        when(msg.what){
            1 -> sb_rabbit.progress = rabbitProgress
        }
        //重複執行到計數器到100為止
        if(rabbitProgress>=100&&turtleProgress<100){
            Toast.makeText(this,"兔子勝利",Toast.LENGTH_SHORT).show()
            btn_start.isEnabled = true
        }
        true
    })

    //建立一個Thread來模擬烏龜的移動 每0.1秒隨機增加計數器0-2的值
    private fun runAsyncTask(){
        object :AsyncTask<Void,Int,Boolean>() {

            override fun doInBackground(vararg params: Void?): Boolean {
                while (turtleProgress <= 100 && rabbitProgress < 100) {
                    try {
                        Thread.sleep(100)                       //睡0.1秒
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    turtleProgress += (Math.random() * 3).toInt()         //隨機增加計數器0-2的值
                    //更新進度 傳入烏龜計數器
                    publishProgress(turtleProgress)

                }
                return true
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                values[0].let {
                    sb_turtle.progress = it!!           //寫入計數器的值到seekBar的進度中
                }
            }

            override fun onPostExecute(result: Boolean?) {
                if (turtleProgress >= 100 && rabbitProgress < 100) {
                    Toast.makeText(this@MainActivity, "烏龜獲勝", Toast.LENGTH_SHORT).show()
                    btn_start.isEnabled = true
                }
            }
        }.execute()
    }




























}

