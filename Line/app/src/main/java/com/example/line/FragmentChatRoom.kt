package com.example.line


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.line.ChatroomAdapter.Companion.waitingForMsgList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_chat_room.*
import kotlinx.android.synthetic.main.fragment_chat_room.view.*
import kotlin.random.Random

class FragmentChatRoom : Fragment() {

    private var toolBarTitle: String? = null

    companion object {
        fun newInstance(param1: String) =
            FragmentChatRoom().apply {
                arguments = Bundle().apply {
                    putString("ARG_PARAM1", param1)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            toolBarTitle = it.getString("ARG_PARAM1")
        }
    }

    val chatroomAdapter = ChatroomAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat_room, container, false)

        view.toolBar_chatroom.inflateMenu(R.menu.menu_chatroom)                         //把menu綁定至toolBar
        if (activity is AppCompatActivity)
            (activity as AppCompatActivity).setSupportActionBar(toolBar_chatroom)   //把自訂的toolBar設為ActionBar
        return view
    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        toolBar_chatroom.title = toolBarTitle



        recyclerView_chatroom.layoutManager = LinearLayoutManager(context)
        recyclerView_chatroom.adapter = chatroomAdapter

        //當按下send鍵  產生對話的資料來源
        btn_sendMsg.setOnClickListener {
            val randomMsg = MessageData.msgList[Random.nextInt(MessageData.msgList.size)]     //隨機產生機器人字串

            waitingForMsgList.add( Msgdata(1, et_user_input.text.toString(),0)  )   //FROM=1代表user 把輸入的字加入list
            waitingForMsgList.add(Msgdata(2, randomMsg,FragmentChat.bigHeadPhoto))       //FROM=2代表bot 把隨機產生的句子 以及fragmentChat傳過來的[指定對象大頭照]加入list
            chatroomAdapter.notifyDataSetChanged()
            recyclerView_chatroom.smoothScrollToPosition(waitingForMsgList.size-1)      //送出訊息時頁面自動滾動到最下面 增加使用者體驗

            et_user_input.text.clear()

//            Handler().postDelayed({
//                //chatroomAdapter.notifyDataSetChanged()
//            },3000)





        }

        //設定返回鍵點擊事件
        toolBar_chatroom.setNavigationOnClickListener {

            activity!!.navigationView?.visibility = View.VISIBLE               //把navigationView設回顯示狀態
            activity!!.onBackPressed()                                          //返回前一個fragment
        }


    }
}
