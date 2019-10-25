package com.example.myapplication

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.rotationMatrix
import androidx.core.graphics.scaleMatrix
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.first_fragment.view.*
import kotlinx.android.synthetic.main.first_fragment.view.imgv_chen01
import kotlinx.android.synthetic.main.first_fragment.view.imgv_chen02
import kotlinx.android.synthetic.main.first_fragment.view.imgv_chen03
import kotlinx.android.synthetic.main.second_fragment.*
import kotlinx.android.synthetic.main.second_fragment.view.*
import kotlinx.android.synthetic.main.second_fragment.view.imgv_quei01
import android.view.animation.LinearInterpolator



class SecondFragment : Fragment(){
    lateinit var rootView2:View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView2 = inflater.inflate(R.layout.second_fragment,container,false)
        Glide
            .with(context!!)
            .load(R.drawable.q_background)
            //.transform(KuwaharaFilterTransformation(2))
            .transform(ToonFilterTransformation(0.7F, 10F))
            .into(rootView2.imgv_quei_background)

        Glide                                                             //使用glide把圖片匯入設好的imageView
            .with(context!!)
            .load(R.drawable.q01)                                       //載入照片
            .into(rootView2.imgv_quei01)                                  //將照片放入ImageView
        Glide
            .with(context!!)
            .load(R.drawable.q02)
            .into(rootView2.imgv_quei02)
        Glide
            .with(context!!)
            .load(R.drawable.q03)
            .into(rootView2.imgv_quei03)
    return rootView2
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //主程式....
        //動畫持續播放

        var a1 = ObjectAnimator.ofFloat(imgv_quei01,"rotationY",360f).apply {
            duration = 7000
            repeatCount = 100
            repeatMode = ValueAnimator.RESTART

            start()
        }
        var a2 = ObjectAnimator.ofFloat(imgv_quei02,"rotationY",360f).apply {
            duration = 7000
            startDelay = 1000
            repeatCount = 100
            repeatMode = ValueAnimator.RESTART

            start()
        }
        var a3 = ObjectAnimator.ofFloat(imgv_quei03,"rotationY",360f).apply {
            duration = 7000
            startDelay = 2000
            repeatCount = 100
            repeatMode = ValueAnimator.RESTART
            start()
        }









    }
}