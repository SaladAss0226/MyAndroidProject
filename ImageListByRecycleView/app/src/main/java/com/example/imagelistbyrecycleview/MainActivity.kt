package com.example.imagelistbyrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val LL =  LinearLayoutManager(this)
        LL.orientation = LinearLayoutManager.VERTICAL
        r1.layoutManager = LL
        r1.adapter = MyAdapter()
    }
}
