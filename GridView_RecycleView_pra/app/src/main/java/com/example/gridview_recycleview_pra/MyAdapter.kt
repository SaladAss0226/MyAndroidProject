package com.example.gridview_recycleview_pra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.example.view.*

class MyAdapter(private val context: Context): RecyclerView.Adapter<MyAdapter.viewHolderr>(){

    lateinit var mContext :Context
    init {
        mContext = context
    }

    inner class viewHolderr(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView = itemView.imgv
        val textView = itemView.tv
        fun Bind(itemm:item){
            Glide.with(mContext).load(itemm.img).into(imageView)
            textView.setText(itemm.txt)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderr {
        var ex = LayoutInflater.from(parent.context).inflate(
            R.layout.example,parent,false
        )
        return viewHolderr(ex)
    }

    override fun getItemCount() = itemList.count()
    override fun onBindViewHolder(holder: viewHolderr, position: Int) {
        holder.Bind(itemList[position])
    }
}