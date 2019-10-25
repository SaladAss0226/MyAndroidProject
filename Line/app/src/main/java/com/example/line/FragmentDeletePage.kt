package com.example.line

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.f2_copy.*
import kotlinx.android.synthetic.main.f2_copy.view.*

class FragmentDeletePage: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.f2_copy,container,false)
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
            //跳轉回Fra02
            //addtobackstack
            val manager  = fragmentManager      //建立一個fragmentManager物件
            val ft : FragmentTransaction? = manager?.beginTransaction()
            ft?.replace(R.id.constraintLay,FragmentChat())?.commit()
            ft?.addToBackStack(null)                         //回到上一個fragment 也就是不會再產生一個新的fragment

            val mainActivity = activity                          //取得當前fragment所依附的activity
            mainActivity?.constraintLay?.visibility = View.VISIBLE                   //把constraintLay設回顯示狀態
            mainActivity?.constraintLay_deletePage?.visibility = View.INVISIBLE      //把刪除頁面設為隱藏
            mainActivity?.navigationView?.visibility = View.VISIBLE               //把navigationView設回顯示狀態

        }

        //刪除鈕點擊事件
        btn_delete.setOnClickListener {
            val ii = Data.itemList.filter { it.isSelect }   //挑出itemList中屬性isSelect為true的item
            Data.itemList.removeAll(ii)                               //刪掉itemList中的這些item
            deletePageAdapter.notifyDataSetChanged()

            //跳轉回Fra02
            val manager  = fragmentManager
            val ft : FragmentTransaction? = manager?.beginTransaction()
            ft?.replace(R.id.constraintLay,FragmentChat())?.commit()
            ft?.addToBackStack(null)

            val mainActivity = activity                          //取得當前fragment所依附的activity
            mainActivity?.constraintLay?.visibility = View.VISIBLE                   //把constraintLay設回顯示狀態
            mainActivity?.constraintLay_deletePage?.visibility = View.INVISIBLE      //把刪除頁面設為隱藏
            mainActivity?.navigationView?.visibility = View.VISIBLE               //把navigationView設回顯示狀態

        }




    }

}