package com.example.line

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.line.MainActivity.Companion.fragmentDeletePage
import com.example.line.MainActivity.Companion.fragmentSearch
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.f2.*
import kotlinx.android.synthetic.main.f2.recyclerView
import kotlinx.android.synthetic.main.f2.view.*
import kotlinx.android.synthetic.main.fragment_chat_room.*

class FragmentChat : Fragment() {
    companion object{
        var bigHeadPhoto:Int = 0
    }

    val chatAdapter = ChatAdapter()     //這邊要建立一個adapter實體 後面需要用到ChatAdapter裡的方法的時候才能呼叫

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        //setHasOptionsMenu(true)    //若是使用onCreateOptionsMenu來載入menu 要記得加這行你的menu才會出來
        val view = inflater.inflate(R.layout.f2, container, false)


        //此方法為隱藏原本預設的actionBar 自己設一個toolBar放上去
        view.toolBar.inflateMenu(R.menu.menu02)                         //把menu綁定至toolBar
        if(activity is AppCompatActivity)
            (activity as AppCompatActivity).setSupportActionBar(toolBar)   //把自訂的toolBar設為ActionBar

        view.toolBar.setOnMenuItemClickListener{
            when (it.itemId) {
                R.id.item_editMessage -> showEditPage()
                R.id.item_sort  -> itemListSort()
                R.id.item_unread -> setRead()
                R.id.item_search -> showSearchPage()
            }
            true
        }
        return view

    }

    //此方法為 單純把menu導入進來放在actionBar上
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

//           inflater.inflate(R.menu.menu02,menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) {
//            R.id.item_editMessage -> showEditPage()
//            R.id.item_sort  -> itemListSort(adapter)
//            R.id.item_unread -> setRead(adapter)
//        }
//        return true
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


//        activity.navigationView?.visibility = View.VISIBLE               //把navigationView設回顯示狀態

        //連接recyclerView
        //val LL = LinearLayoutManager(context)
        //LL.orientation = LinearLayoutManager.VERTICAL    //預設就是vertical 此行可以省略
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = chatAdapter


        //override item們的點擊事件(進入聊天室)
        chatAdapter.setToClick(object :ChatAdapter.mItemClickListener{
            override fun toClick(items: item) {

                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.constraintLay_fullScreen, FragmentChatRoom.newInstance(items.namee))?.addToBackStack(null)?.commit()
                                                                               //把聊天對象的名稱夾帶過去fragmentChatroom

                ChatroomAdapter.waitingForMsgList = items.messageList      //把指定對象的messagelist指定給adapter裡的list去產生recyclerView
                                                                           //(也就是根據點擊不同對象 會產生各自獨立的聊天室 並會記錄各自的聊天紀錄
                bigHeadPhoto = items.imgg                                  //設定聊天室中聊天對象的大頭照
                items.unreadd = 0                                         //設為已讀
                chatAdapter.notifyDataSetChanged()

                val mainActivity = activity
                mainActivity?.navigationView?.visibility = View.INVISIBLE

            }
        })





    }


    private fun setRead() {
        AlertDialog.Builder(context!!)
            .setMessage("要將所有訊息標為已讀嗎?")
            .setNeutralButton("取消") { _, _ ->
            }
            .setPositiveButton("標為已讀") { _, _ ->
                Data.itemList.forEach { it.unreadd = 0 }       //forEach迴圈會走訪list中每一個元素
                chatAdapter.notifyDataSetChanged()
            }.show()
    }

        private fun itemListSort() {
            val list = arrayOf("收到的時間", "未讀訊息")

            var position = 0
            AlertDialog.Builder(context!!)                              //建立一個dialog物件
                .setTitle("單選式對話框")
                .setSingleChoiceItems(list, 0) { _, i ->
                    //建立並將陣列的資料載入列表
                    position = i                                           //紀錄哪一個選項被點選了 並傳給postion
                }
                .setPositiveButton("確定") { _,_->
                    if (position == 0) {
                        //先排時間先後 再排未讀訊息
                        Data.itemList.sortWith(compareBy({ it.messageTime }, { it.unreadd }))
                        chatAdapter.notifyDataSetChanged()
                    } else {
                        //先排未讀訊息 再排時間先後
                        Data.itemList.sortWith(compareBy({ it.unreadd }, { it.messageTime }))
                        chatAdapter.notifyDataSetChanged()
                    }

                }.show()
        }

        private fun showEditPage() {
            //跳轉Fragment至FragmentDeletePage
            val manager = fragmentManager
            val fragmentTransaction: FragmentTransaction? = manager?.beginTransaction()
            fragmentTransaction?.replace(R.id.constraintLay_fullScreen, fragmentDeletePage)?.addToBackStack(null)?.commit()

            val mainActivity = activity                          //取得當前fragment所依附的activity
            mainActivity?.navigationView?.visibility = View.INVISIBLE               //把navigationView設為隱藏
        }

    private fun showSearchPage() {
        val manager = fragmentManager
        val fragmentTransaction: FragmentTransaction? = manager?.beginTransaction()
        fragmentTransaction?.replace(R.id.constraintLay_fullScreen,fragmentSearch)?.addToBackStack(null)?.commit()

        val mainActivity = activity                          //取得當前fragment所依附的activity
        mainActivity?.navigationView?.visibility = View.INVISIBLE               //把navigationView設為隱藏


    }

    }
