package com.example.line


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_search.*
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.line.MainActivity.Companion.historyAdapter
import com.example.line.MainActivity.Companion.historyArrayList
import kotlinx.android.synthetic.main.fragment_search.recyclerView
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlinx.android.synthetic.main.keywords_example.view.*


/**
 * A simple [Fragment] subclass.
 */
class FragmentSearch : Fragment() {

    lateinit var rootView: View

    //***此fragment又分成兩個頁面 分別是顯示歷史紀錄跟熱詞的頁面 跟 顯示搜尋結果的recyclerview頁面


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_search, container, false)
        return rootView

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_clearEditText.visibility = View.INVISIBLE

        //自動彈出鍵盤
        et_search.requestFocus()                 //取得焦點
        var imm:InputMethodManager = et_search.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(et_search,0)




        //搜尋結果頁面的recyclerView
        val searchAdapter = SearchAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = searchAdapter
        recyclerView.visibility = View.INVISIBLE              //先隱藏搜尋結果的recyclerView


        //顯示歷史紀錄的listView
        historyAdapter = ArrayAdapter(context!!,android.R.layout.simple_list_item_1,historyArrayList)
        listView_search_history.adapter = historyAdapter

        //顯示熱詞的gridView
        val keywordsAdapter = KeywordsAdapter(context!!)
        //val linearLayoutManager = LinearLayoutManager(context)
        gridView_keywords.numColumns = 3
        gridView_keywords.adapter = keywordsAdapter






        //監聽editText字元變化來自動過濾搜尋
        et_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(sequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(sequence: CharSequence, i: Int, i1: Int, i2: Int) {

                if (et_search.length()<1) {
                    recyclerView.visibility = View.INVISIBLE
                    layout_remind_words.visibility = View.VISIBLE
                    btn_clearEditText.visibility = View.INVISIBLE
                }
                else {
                    val list =
                        Data.itemList.filter { it.namee.contains(et_search.text.toString()) }  //挑出namee裡面有包含搜尋字詞的item並放入list
                    recyclerView.visibility = View.VISIBLE
                    btn_clearEditText.visibility = View.VISIBLE
                    layout_remind_words.visibility = View.INVISIBLE
                    SearchAdapter.SearchList = list           //把list指定給SearchList來生成recyclerView
                }
                searchAdapter.notifyDataSetChanged()

            }
            override fun afterTextChanged(editable: Editable) {}
        })



        //搜尋按鈕點擊事件
        btn_search.setOnClickListener {
            if (et_search.length()<1) recyclerView.visibility = View.INVISIBLE
            else {
                val list = Data.itemList.filter { it.namee.contains(et_search.text.toString()) }  //挑出namee裡面有包含搜尋字詞的item並放入list
                SearchAdapter.SearchList = list                                     //把list指定給SearchList來生成recyclerView
                historyArrayList.add(et_search.text.toString())                           //把搜尋過的字詞存入歷史紀錄
                tv_noHistory.visibility = View.INVISIBLE

                //自動收起鍵盤
                var imm:InputMethodManager = et_search.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view?.getWindowToken(),0)
            }
            searchAdapter.notifyDataSetChanged()
            historyAdapter.notifyDataSetChanged()

        }


        //返回按鈕點擊事件
        btn_leftback.setOnClickListener {
            //自動收起鍵盤
            var imm:InputMethodManager = rootView.et_search.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.getWindowToken(),0)

            activity!!.navigationView?.visibility = View.VISIBLE               //把navigationView設回顯示狀態
            activity!!.onBackPressed()                                          //返回前一個fragment
        }


        //清除editView按鈕點擊事件
        btn_clearEditText.setOnClickListener {
            et_search.text.clear()
        }

        //清除歷史紀錄點擊事件
        btn_clearHistory.setOnClickListener {
            historyArrayList.removeAll(historyArrayList)
            historyAdapter.notifyDataSetChanged()
        }



    }


    var keywordsArrayList = arrayListOf("中華職棒","NBA","亞錦賽","韓國瑜台南","高欣欣","中美貿易戰","反送中","全運會","陳同佳","山下智久")

    inner class KeywordsAdapter(var m: Context) : BaseAdapter() {
        override fun getCount() = keywordsArrayList.size
        override fun getItem(position: Int) = position
        override fun getItemId(position: Int) = position.toLong()
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var keywordsTextview = LayoutInflater.from(m).inflate(R.layout.keywords_example, null)
            keywordsTextview.tv_keywordsItem.text = keywordsArrayList[position]
            return keywordsTextview
        }
    }
//    fun forceOpenSoftKeyboard(context: Context) {
//        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS)
//    }

}
