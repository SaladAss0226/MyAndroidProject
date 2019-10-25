package com.example.imagelistbyrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.exsample.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.viewHolderr>() {

    //宣告一個viewHolder
    inner class viewHolderr(itemView: View) : RecyclerView.ViewHolder(itemView) {   //宣告一個ViewHolder類別
        val img = itemView.imgv
        val text = itemView.tv
        fun Bind(items: item) {
            img.setImageResource(items.imagee)       //把item資料庫裡的資料們貼上我們的框架
            text.setText(items.textt)
        }

    }

    //創建一個viewHolder實體出來 並回傳viewHodlerr(example)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolderr {
        val inflaterr = LayoutInflater.from(parent.context)
        val example = inflaterr.inflate(R.layout.exsample, parent, false)    //把example框架貼上viewHolerr
        return viewHolderr(example)             //回傳擁有example框架的viewHolderr
    }

    override fun getItemCount(): Int = itemList.count()      //告訴系統有幾筆資料
    override fun onBindViewHolder(holder: viewHolderr, position: Int) {
        holder.Bind(itemList[position])           //呼叫bind方法
    }
}