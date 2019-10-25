package com.example.myapplication


import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import jp.wasabeef.glide.transformations.CropCircleTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.third_fragment.*
import kotlinx.android.synthetic.main.third_fragment.view.*
import kotlinx.android.synthetic.main.third_fragment.view.imgv_shit01

class ThirdFragment : Fragment(){
    lateinit var rootView3:View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView3 = inflater.inflate(R.layout.third_fragment,container,false)
        Glide
            .with(context!!)
            .load(R.drawable.shit_background)
            //.transform(ToonFilterTransformation(0.5F, 10F))
            .transform(KuwaharaFilterTransformation(2))
            .into(rootView3.imgv_shit_background)
        Glide
            .with(context!!)
            .load((R.drawable.bubble))
            .into(rootView3.imgv_bubble)

        Glide                                                             //使用glide把圖片匯入設好的imageView
            .with(context!!)
            .load(R.drawable.shit03)                                       //載入照片
            .transform(CircleCrop())
            .into(rootView3.imgv_shit01)                                  //將照片放入ImageView
        Glide
            .with(context!!)
            .load(R.drawable.shit02)
            .transform(CircleCrop())
            .into(rootView3.imgv_shit02)
        Glide
            .with(context!!)
            .load(R.drawable.shit01)
            .transform(CircleCrop())
            .into(rootView3.imgv_shit03)
        return rootView3
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //主程式....
        //動畫持續性播放
        val ll = LinearInterpolator()
        var a1 = ObjectAnimator.ofFloat(imgv_shit01,"rotation",370f).apply {
            duration = 7000
            repeatCount = 100
            repeatMode = ValueAnimator.RESTART
            interpolator=ll
            start()
        }
        var a2 = ObjectAnimator.ofFloat(imgv_shit02,"rotation",350f).apply {
            duration = 7000
            startDelay = 1000
            repeatCount = 100
            repeatMode = ValueAnimator.RESTART
            interpolator=ll
            start()
        }
        var a3 = ObjectAnimator.ofFloat(imgv_shit03,"rotation",370f).apply {
            duration = 7000
            startDelay = 2000
            repeatCount = 100
            repeatMode = ValueAnimator.RESTART
            interpolator=ll
            start()
        }









    }
}