package com.example.gridview_recycleview_pra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //設定用Gridview來顯示
        var g = GridLayoutManager(this,2) //填2表示我們以兩欄來顯示
        rccv.layoutManager = g

        //嵌入MyAdapter
        rccv.adapter = MyAdapter(this)

    }
}
