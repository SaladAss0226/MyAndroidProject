package com.example.line

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.chatroom_dialog_example_bot.view.*
import kotlinx.android.synthetic.main.chatroom_dialog_example_user.view.*

class ChatroomAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
          companion object{
              const val USER = 1
              const val BOT = 2
              var waitingForMsgList = mutableListOf<Msgdata>()
          }
    inner class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val userSayWhat = itemView.tv_userDialog                                 //取得example中的textview
        fun bind(items:Msgdata) {
            userSayWhat.text = items.msg                                          //把data class [msg]中的msg資料放入textview
        }
    }
    inner class BotHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val botSayWhat = itemView.tv_botDialog                                      //取得example中的元件
        val bigHead = itemView.imgv_bighead
        fun bind(items: Msgdata) {
            botSayWhat.text = items.msg
            Glide.with(itemView)
                .load(items.photo)
                .transform(CircleCrop())
                .into(bigHead)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if (waitingForMsgList[position].FROM == 1) USER else BOT
        return super.getItemViewType(position)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==USER){
                val example = LayoutInflater.from(parent.context)
                    .inflate(R.layout.chatroom_dialog_example_user, parent, false)    //判斷是user的話就使用綠色泡泡框
                return UserHolder(example)        //回傳UserHolder
            }
            else{
                val example = LayoutInflater.from(parent.context)                          //判斷是bot的話就使用白色泡泡框
                .inflate(R.layout.chatroom_dialog_example_bot, parent, false)
                return BotHolder(example)         //回傳BotHolder
            }
        }

    override fun getItemCount() = waitingForMsgList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is UserHolder) holder.bind(waitingForMsgList[position])
        else if(holder is BotHolder) holder.bind(waitingForMsgList[position])

    }







}