package com.example.line

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class DeletePageAdapter : RecyclerView.Adapter<DeletePageAdapter.viewHolder>() {

    //在這裡做interface把事情外包給fragment去做是因為 adapter只處理畫面 觸發監聽這些雜事不應該寫在這(不過其實要看個人怎麼界定哪些是雜事)
    private var listener:checkBoxListener? = null       //宣告變數listener 繼承checkBox介面
    interface checkBoxListener{
        fun toSelect(items:item)                        //宣告抽象方法
    }

    fun setToSelect(listener:checkBoxListener){
        this.listener = listener
        //把代入的參數listener指定給本地listener
    }

    //宣告viewHolder
    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(R.id.imgv_image)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val content = itemView.findViewById<TextView>(R.id.tv_content)
        val time = itemView.findViewById<TextView>(R.id.tv_time)
        val checkBox = itemView.findViewById<CheckBox>(R.id.checkbox)

        //宣告方法來綁定資料
        fun bind(items:item){
            Glide.with(itemView)
                .load(items.imgg)
                .transform(CircleCrop())
                .into(img)
            name.text = items.namee
            content.text = items.contentt
            time.text = items.messageTime
            if(items.isSelect==true) checkBox.isChecked = true       //修正recyclerView因為view的複用而產生的bug
            else checkBox.isChecked = false

            checkBox.setOnClickListener {       //設定checkBox點選事件
                listener?.toSelect(items)        //呼叫listen的抽象方法toSelect

            }

        }
    }

    //創建viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val example = inflater.inflate(R.layout.example_copy,parent,false)
        return viewHolder(example)
    }

    override fun getItemCount() = Data.itemList.count()
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(Data.itemList[position])
        }


    }

