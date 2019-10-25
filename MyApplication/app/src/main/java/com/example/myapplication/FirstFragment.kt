package com.example.myapplication

import android.R.attr.repeatCount
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.trace
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.request.transition.Transition
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import jp.wasabeef.glide.transformations.gpu.*
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.first_fragment.view.*
import kotlinx.android.synthetic.main.first_fragment.view.imgv_chen01
import kotlinx.android.synthetic.main.home_fragment.*
import android.R.attr.start
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Activity
import android.view.animation.LinearInterpolator
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_wangwang.*


class FirstFragment :Fragment(){
    lateinit var rootView: View                                           //這裡要先lateinit 意思就是說 我們在這邊宣告一個rootView變數
    override fun onCreateView(                                             //但是我晚一點才會初始化他 也就是下面的inflater那邊才會給他值
        inflater: LayoutInflater,                                         //他有了值之後 在onActivityCreated裡的主程式就可以使用rootView了!!!
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.first_fragment,container,false)  //rootView代表整個first_fragment

        Glide        //匯入背景
            .with(context!!)
            .load(R.drawable.graduate)
            .transform(SepiaFilterTransformation(1f))
            .into(rootView.imgv_background)
        Glide
            .with(context!!)
            .load(R.drawable.maple)
            .into(rootView.imgv_maple)

        Glide                                                             //使用glide把圖片匯入設好的imageView
            .with(context!!)
            .load(R.drawable.chen01)
            .transform(MultiTransformation(RoundedCornersTransformation(100, 0, RoundedCornersTransformation.CornerType.ALL)))
            .into(rootView.imgv_chen01)
        Glide
            .with(context!!)
            .load(R.drawable.chen22)
            .transform(MultiTransformation(RoundedCornersTransformation(100, 0, RoundedCornersTransformation.CornerType.ALL)))
            .into(rootView.imgv_chen02)
        Glide
            .with(context!!)
            .load(R.drawable.chen03)
            .transform(MultiTransformation(RoundedCornersTransformation(100, 0, RoundedCornersTransformation.CornerType.ALL)))
            .into(rootView.imgv_chen03)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //主程式....

        //動畫持續性播放
        val ll = LinearInterpolator()
        var a1 = ObjectAnimator.ofFloat(imgv_chen01,"alpha",0f,1f,0f).apply {
            duration = 7000
            repeatCount = 100
            repeatMode = ValueAnimator.RESTART
            interpolator=ll
            start()
        }
        var a2 =ObjectAnimator.ofFloat(imgv_chen02,"alpha",0f,1f,0f).apply {
            duration = 7000
            startDelay = 1000
            repeatCount = 100
            repeatMode = ValueAnimator.RESTART
            interpolator=ll
            start()
        }
        var a3 = ObjectAnimator.ofFloat(imgv_chen03,"alpha",0f,1f,0f).apply {
            duration = 7000
            startDelay = 2000
            repeatCount = 100
            repeatMode = ValueAnimator.RESTART
            interpolator=ll
            start()
        }

        //var aa = AnimatorSet().apply {
          //  play(a2).after(a1)
           // play(a3).after(a2)
            //start()
       // }


        //在fragment中跳轉另一個fragment(動態載入)
        imgv_chen01.setOnClickListener {
            val manager  = fragmentManager      //建立一個fragmentManager物件manager
            val ft :FragmentTransaction?                          //建立一個FragmentTransaction物件ft
            ft = manager?.beginTransaction()                //用ft來接 因為fragmentManager裡面的beginTransaction方法會回傳一個fragmentTransaction
            ft?.replace(R.id.frameLay,chen01_Fragment(),"chen01Fragmen")?.commit()  //把chen01_Fragment.kt和其所連結的chen01_fragment.xml
                                                                                        //放入framlay這個container容器裡面並取代

            val test = activity             //取得當前fragment所依附的activity(也就是wangwangActivity)
            test?.vp?.visibility = View.INVISIBLE               //把vp(viewPager那個容器)設為隱藏


        }









    }
}