package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.c01_example.view.*

class chen01_Adapter :RecyclerView.Adapter<chen01_Adapter.vHolder>(){

    inner class vHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imgg = itemView.imgv_EX
        val txtt = itemView.tv_EX
         fun Bind(items: Item) {
            imgg.setImageResource(items.img)            //宣告方法Bimd  把資料貼上我們的example的框架
            txtt.text = items.txt
        }
    }

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vHolder {
            val inflaterr =LayoutInflater.from(parent.context)
            val ex = inflaterr.inflate(R.layout.c01_example,parent,false)      //把example框架貼上vHoler
            return vHolder(ex)
    }

    override fun onBindViewHolder(holder: vHolder, position: Int) {
        holder.Bind(itemList[position])                                  //正式呼叫Bind方法
    }



}