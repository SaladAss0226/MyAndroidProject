package com.example.hellonihaoma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment:Fragment() {               //首頁的kt檔

    override fun onCreateView(              //在onCreateView中 定義當前kt檔的畫面要放在哪個layout檔
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mora, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {            //裡面放主程式
        super.onActivityCreated(savedInstanceState)

    }
}