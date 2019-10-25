package com.example.line

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.viewHolder>() {

    //宣告viewHolder
    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.imgv_image)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val content = itemView.findViewById<TextView>(R.id.tv_content)
        val time = itemView.findViewById<TextView>(R.id.tv_time)
        var unread = itemView.findViewById<TextView>(R.id.tv_unread)
        val unreadLayout = itemView.findViewById<LinearLayout>(R.id.unreadLayout)
        //宣告方法來綁定資料
        fun Bind(items: item) {
            Glide.with(itemView)
                .load(items.imgg)
                .transform(CircleCrop())
                .into(img)


            name.text = items.namee
            content.setText(items.contentt)
            time.setText(items.messageTime)

            if (items.unreadd == 0) unreadLayout.visibility = View.INVISIBLE
                else unread.text=items.unreadd.toString()



        }
    }

    //創建viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val example = inflater.inflate(R.layout.example, parent, false)
        return viewHolder(example)
    }

    override fun getItemCount() = Data.itemList.count()
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.Bind(Data.itemList[position])


    }


}