package com.example.line

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.f2_copy.*
import kotlinx.android.synthetic.main.f2_copy.toolBar

class FragmentDeletePage: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.f2_copy,container,false)
        if(activity is AppCompatActivity)
            (activity as AppCompatActivity).setSupportActionBar(toolBar)   //把自訂的toolBar設為ActionBar
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //設定recyclerView
        val LL = LinearLayoutManager(context)
        LL.orientation = LinearLayoutManager.VERTICAL
        recyclerView02.layoutManager = LL
        val deletePageAdapter = DeletePageAdapter()
        recyclerView02.adapter = deletePageAdapter

        deletePageAdapter.setToSelect(object :DeletePageAdapter.checkBoxListener{    //在這裡實作checkBox點選事件!
            override fun toSelect(items: item) {
                items.isSelect = !items.isSelect
                deletePageAdapter.notifyDataSetChanged()                   //會重跑一次方法來抓資料
            }
        })


        //設定返回鍵點擊事件
        toolBar.setNavigationOnClickListener {

            activity!!.navigationView?.visibility = View.VISIBLE               //把navigationView設回顯示狀態
            activity!!.onBackPressed()                                          //返回前一個fragment
        }

        //刪除鈕點擊事件
        btn_delete.setOnClickListener {
            val ii = Data.itemList.filter { it.isSelect }   //挑出itemList中屬性isSelect為true的item
            Data.itemList.removeAll(ii)                                //刪掉itemList中的這些item
            deletePageAdapter.notifyDataSetChanged()

            activity!!.navigationView?.visibility = View.VISIBLE               //把navigationView設回顯示狀態
            activity!!.onBackPressed()                                          //返回前一個fragment

        }




    }

}