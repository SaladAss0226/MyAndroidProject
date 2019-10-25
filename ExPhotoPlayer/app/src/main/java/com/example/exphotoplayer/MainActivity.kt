package com.example.exphotoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //將圖片放入陣列
        var imgId= intArrayOf(R.drawable.image01,R.drawable.image02,R.drawable.image03)
        var p=0 //索引值(第一張索引值是0 第二張是1)
        var count = imgId.size //有幾張圖片

        btn_prev.setOnClickListener{
            p--
            if(p<0) {
                p = count-1
            }
            img_photo.setImageResource(imgId[p])
                setTitle("${p+1}/$count")
        }
        btn_next.setOnClickListener {
            p++
            if(p==count){
                p = 0
            }
            img_photo.setImageResource(imgId[p])
            setTitle("${p+1}/$count")

        }



    }
}
