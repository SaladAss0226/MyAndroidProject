package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    //先定義一個方法 設定intent會夾帶一個key過去wangwangActivity
    fun startTransitionnn(flag:String) {
        val itt = Intent(this, wangwangActivity::class.java)
        itt.putExtra("flag", flag)
       startActivity(
            itt, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle())      //開始切換頁面去wangwangActivity
   }





    private fun setupTrainsition() {                          //定義過場動畫方法
        when(intent.getStringExtra("flag")){             //找到intent送過來的key是哪一個
            "explode" -> {
                val explodeTransition = Explode()
                explodeTransition.duration = 1000
                window.enterTransition = explodeTransition
                window.exitTransition = explodeTransition
            }

            "slide" -> {
                val slideTransition = Slide()
                slideTransition.duration = 1000
                window.enterTransition = slideTransition
                window.exitTransition = slideTransition
            }
            "fade" -> {
                val fadeTransition = Fade()
                fadeTransition.duration = 1000
                window.enterTransition = fadeTransition
                window.exitTransition = fadeTransition

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)         //這行一定要放在setcontentView前面!!!!!!!!!!!!!!!用來控制過場動畫
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setupTrainsition()                                                  //呼叫過場動畫
        getSupportActionBar()?.hide()                           //隱藏標題欄

        btn_login.setOnClickListener {
            if(et_pwd.text.toString()=="") {
                //跳轉畫面
                //startActivity(Intent(this, wangwangActivity::class.java))
                login_page_in_page.setVisibility(View.GONE)
                tv_user_welcome_back.text = "Welcome back!!\n${et_userName.text.toString()}"

                Thread{                                              //執行緒睡兩秒
                    Thread.sleep(1000)
                    runOnUiThread {
                        startTransitionnn("slide")
                    }
                }.start()



            }else {
                Toast.makeText(this, "帳號或密碼無效", Toast.LENGTH_SHORT).show()
                et_userName.setText("")
                et_pwd.setText("")
            }
            }
        }



    }

