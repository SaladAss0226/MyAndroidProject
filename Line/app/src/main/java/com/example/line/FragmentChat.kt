package com.example.line

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.f2.*
import kotlinx.android.synthetic.main.f2.view.*

class FragmentChat : Fragment() {

    val adapter = ChatAdapter()     //這邊要建立一個adapter實體 後面需要用到ChatAdapter裡的方法的時候才能呼叫

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.f2, container, false)
        
        setHasOptionsMenu(true)    //要記得加這行你的menu才會出來啦


        //此方法為隱藏原本預設的actionBar 自己設一個toolBar放上去
        view.toolBar.inflateMenu(R.menu.menu02)

        view.toolBar.setOnMenuItemClickListener{
            when (it.itemId) {
                R.id.item_editMessage -> showEditPage()
                R.id.item_sort  -> itemListSort(adapter)
                R.id.item_unread -> setRead(adapter)
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

        //連接recyclerView
        val LL = LinearLayoutManager(context)
        LL.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = LL
        recyclerView.adapter = adapter
    }


    private fun setRead(adapter: ChatAdapter) {
        AlertDialog.Builder(context!!)
            .setMessage("要將所有訊息標為已讀嗎?")
            .setNeutralButton("取消") { _, _ ->
            }
            .setPositiveButton("標為已讀") { _, _ ->
                for (i in 0 until Data.itemList.size) {
                    Data.itemList[i].unreadd = 0
                }
                adapter.notifyDataSetChanged()
            }.show()
    }

        private fun itemListSort(adapter: ChatAdapter) {
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
                        adapter.notifyDataSetChanged()
                    } else {
                        //先排未讀訊息 再排時間先後
                        Data.itemList.sortWith(compareBy({ it.unreadd }, { it.messageTime }))
                        adapter.notifyDataSetChanged()
                    }

                }.show()
        }

        private fun showEditPage() {
            //跳轉Fragment至FragmentDeletePage
            val manager = fragmentManager
            val ft: FragmentTransaction? = manager?.beginTransaction()
            ft?.replace(R.id.constraintLay_deletePage, FragmentDeletePage())?.commit()

            val mainActivity = activity                          //取得當前fragment所依附的activity
            mainActivity?.constraintLay_deletePage?.visibility = View.VISIBLE        //把刪除頁面設回顯示狀態
            mainActivity?.constraintLay?.visibility =
                View.INVISIBLE                //把其他fragment用的container設為隱藏
            mainActivity?.navigationView?.visibility =
                View.INVISIBLE               //把navigationView設為隱藏
        }

    }
