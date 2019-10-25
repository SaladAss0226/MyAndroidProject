package com.example.myapplication

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.view.View
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_wangwang.*
import kotlinx.android.synthetic.main.first_fragment.*

class wangwangActivity : AppCompatActivity() {

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
                fadeTransition.duration = 2000
                window.enterTransition = fadeTransition
                window.exitTransition = fadeTransition

            }
        }
    }

    lateinit var bgm: MediaPlayer


    override fun onResume() {
        super.onResume()
        bgm.start()                           //設定activity在onResume的階段開始播放音樂

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wangwang)


        setupTrainsition()                                     //呼叫fade過場進入動畫

        bgm = MediaPlayer.create(this,R.raw.background_music)     //載入音樂檔(需要時間)




        //val fragmentmgr = supportFragmentManager                     //呼叫supportFragmentManager方法取得FragmentManager
        //val fragmentTrans = fragmentmgr.beginTransaction()      //呼叫FragmentManager的beginTransaction方法 建立一個fragmentTransaction物件
        //fragmentTrans.add(R.id.frameLay,homeFragment(),"myhomeFragment")            //參數分別為 (要當容器的layout,要加入的fragment類別,取新名稱)



        //建立一個VPA類別的物件
        val adpt = VPA(supportFragmentManager,3)    //bh到底要填多少??

        //連接我們做的fragment畫面跟滑頁vp(vp建立在activity_main.xml裡面)
        vp.adapter = adpt






    }
}
//建立一個類別VPA 繼承FragmentPagerAdapter
class VPA(f: FragmentManager, bh:Int) : FragmentPagerAdapter(f,bh){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> FirstFragment()   //第一頁要呈現的fragment(kt檔)
            1 -> SecondFragment()   //第二頁要呈現的fragment(kt檔)
            else -> ThirdFragment()    //第三頁頁要呈現的fragment(kt檔)
        }
    }
    override fun getCount(): Int = 3 //直接回傳fragment頁數

}
