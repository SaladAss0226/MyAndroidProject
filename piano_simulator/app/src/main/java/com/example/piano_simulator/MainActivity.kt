package com.example.piano_simulator

import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_DOWN
import android.view.MotionEvent.ACTION_UP
import kotlinx.android.synthetic.main.lineatlayout_main.*

class MainActivity : AppCompatActivity() {
    private var pianoSound_c: Int = 0
    private var pianoSound_d: Int = 0
    private var pianoSound_e: Int = 0
    private var pianoSound_f: Int = 0
    private var pianoSound_g: Int = 0
    private var pianoSound_a: Int = 0
    private var pianoSound_b: Int = 0
    private var pianoSound_cc: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lineatlayout_main)

        var sp = SoundPool.Builder().setMaxStreams(8).build()    //建立soundPool物件 sp
        sp.setOnLoadCompleteListener { soundPool, sampleId, status ->        //設定一個監聽器 當這個音效檔被載入完成的時候會觸發這個監聽器
                                                                             // (但你不知道什麼時候會載入完成 你無法控制那個時間長短)
            initKeyListener(soundPool)                          //當監聽器被觸發 執行initKeyListener方法
        }
        pianoSound_c = sp.load(this, R.raw.pianoc, 1)        //載入音效 參數由左至右是(context,音訊檔位置,優先級(最小為0,預設為0))
        pianoSound_d = sp.load(this, R.raw.pianod, 1)
        pianoSound_e = sp.load(this, R.raw.pianoe, 1)
        pianoSound_f = sp.load(this, R.raw.pianof, 1)
        pianoSound_g = sp.load(this, R.raw.pianog, 1)
        pianoSound_a = sp.load(this, R.raw.pianoa, 1)
        pianoSound_b = sp.load(this, R.raw.pianob, 1)
        pianoSound_cc = sp.load(this, R.raw.pianocc, 1)
    }



    private fun initKeyListener(soundPool: SoundPool) {

        key_c.setOnTouchListener { v, event ->
            when(event!!.action and MotionEvent.ACTION_MASK){   //註:!!表示堅持不會是空值，執行就是了
                ACTION_DOWN -> {
                    key_c.setImageResource(R.drawable.red)

                    if(Build.VERSION.SDK_INT>=21)         //若android SDK version為21以上
                        soundPool.play(pianoSound_c,1.0f,1.0f,2,0,1.0f)

                        /*使用.play撥放音效 參數由左至右是
                        1.撥放ID(streamID: Int) :由load指定，也就是前面的C
                        2.左聲道音量,右聲道音量(leftVolume: Float, rightVolume: Float) 範圍0.0~1.0
                        3.優先級(priority: Int)  最小為0,預設為0
                        4.重複撥放(loop: Int)    0=不重複,-1=無限重複,其他正數為+1播放次數
                        5.速度(rate: Float)  範圍0.5~2.0,1=正常速度*/
                }
                ACTION_UP     -> key_c.setImageResource(R.drawable.white)
            }
            true
        }

        key_d.setOnTouchListener { v, event ->
            when(event!!.action and MotionEvent.ACTION_MASK){   //註:!!表示堅持不會是空值，執行就是了
                ACTION_DOWN -> {
                    key_d.setImageResource(R.drawable.pink)
                    if(Build.VERSION.SDK_INT>=21)
                        soundPool.play(pianoSound_d,1.0f,1.0f,2,0,1.0f)
                }
                ACTION_UP     -> key_d.setImageResource(R.drawable.white)
            }
            true
        }

        key_e.setOnTouchListener { v, event ->
            when(event!!.action and MotionEvent.ACTION_MASK){   //註:!!表示堅持不會是空值，執行就是了
                ACTION_DOWN -> {
                    key_e.setImageResource(R.drawable.orange)
                    if(Build.VERSION.SDK_INT>=21)
                        soundPool.play(pianoSound_e,1.0f,1.0f,2,0,1.0f)
                }
                ACTION_UP     -> key_e.setImageResource(R.drawable.white)
            }
            true
        }

        key_f.setOnTouchListener { v, event ->
            when(event!!.action and MotionEvent.ACTION_MASK){   //註:!!表示堅持不會是空值，執行就是了
                ACTION_DOWN -> {
                    key_f.setImageResource(R.drawable.yellow)
                    if(Build.VERSION.SDK_INT>=21)
                        soundPool.play(pianoSound_f,1.0f,1.0f,2,0,1.0f)
                }
                ACTION_UP     -> key_f.setImageResource(R.drawable.white)
            }
            true
        }

        key_g.setOnTouchListener { v, event ->
            when(event!!.action and MotionEvent.ACTION_MASK){   //註:!!表示堅持不會是空值，執行就是了
                ACTION_DOWN -> {
                    key_g.setImageResource(R.drawable.green)
                    if(Build.VERSION.SDK_INT>=21)
                        soundPool.play(pianoSound_g,1.0f,1.0f,2,0,1.0f)
                }
                ACTION_UP     -> key_g.setImageResource(R.drawable.white)
            }
            true
        }

        key_a.setOnTouchListener { v, event ->
            when(event!!.action and MotionEvent.ACTION_MASK){   //註:!!表示堅持不會是空值，執行就是了
                ACTION_DOWN -> {
                    key_a.setImageResource(R.drawable.blue)
                    if(Build.VERSION.SDK_INT>=21)
                        soundPool.play(pianoSound_a,1.0f,1.0f,2,0,1.0f)
                }
                ACTION_UP     -> key_a.setImageResource(R.drawable.white)
            }
            true
        }

        key_b.setOnTouchListener { v, event ->
            when(event!!.action and MotionEvent.ACTION_MASK){   //註:!!表示堅持不會是空值，執行就是了
                ACTION_DOWN -> {
                    key_b.setImageResource(R.drawable.purple)
                    if(Build.VERSION.SDK_INT>=21)
                        soundPool.play(pianoSound_b,1.0f,1.0f,2,0,1.0f)
                }
                ACTION_UP     -> key_b.setImageResource(R.drawable.white)
            }
            true
        }

        key_cc.setOnTouchListener { v, event ->                 //override觸碰監聽事件
            when(event!!.action and MotionEvent.ACTION_MASK){   //註:!!表示堅持不會是空值，執行就是了
                ACTION_DOWN -> {
                    key_cc.setImageResource(R.drawable.red)
                    if(Build.VERSION.SDK_INT>=21)
                        soundPool.play(pianoSound_cc,1.0f,1.0f,2,0,1.0f)
                }
                ACTION_UP     -> key_cc.setImageResource(R.drawable.white)
            }
            true
        }
    }
}
