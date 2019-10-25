package com.example.sqlite_pra

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var dbrw :SQLiteDatabase              //宣告一個SQLiteDatabase
    private var items :ArrayList<String> = ArrayList()     //建立一個內容為字串的arrayList
    private lateinit var adpt:ArrayAdapter<String>      //宣告一個adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbrw = MyDBHelper(this).writableDatabase    //取得資料庫實體
        //建立adapter 使用simple_list_item_1樣式 載入items資料 並連結listView
        adpt = ArrayAdapter(this,android.R.layout.simple_list_item_1,items)
        listView.adapter = adpt


        //查詢資料
        btn_query.setOnClickListener {
            //根據輸入的書名查詢資料 (說明:rawQuery方法會回傳一個Cursor類別 可以想成一張資料表 book欄位用Cursor.getString(0)來取得 price欄位用Cursor.getString(1)來取得
            val c = dbrw.rawQuery(if(et_book.length()<1) "SELECT * FROM myTable"
                                           else "SELECT * FROM　myTable WHERE book LIKE '${et_book.text}'",null)
            c.moveToFirst()                                            //從第一筆開始
            items.clear()                                               //初始化items
            Toast.makeText(this,"共有${c.count}筆資料",Toast.LENGTH_SHORT).show()        //彈出視窗告知搜尋到幾筆資料

            for(i in 0 until c.count){                                                                 //用迴圈一筆一筆填入書名與價格到items裡 以顯示查詢到的資料
                items.add("書名:${c.getString(0)} \t\t\t\t 價格:${c.getString(1)}")
                c.moveToNext()                        //移動到下一筆
            }
            adpt.notifyDataSetChanged()           //更新listView
            c.close()                              //關閉cursor

        }

        //新增資料
        btn_insert.setOnClickListener {
            if(et_book.length()<1 || et_price.length()<1)
                Toast.makeText(this,"請輸入欄位",Toast.LENGTH_SHORT).show()
            else
                try{
                    //新增一筆資料進入myTable資料表
                    dbrw.execSQL("INSERT INTO myTable(book,price) VALUES(?,?)",
                        arrayOf<Any?>(et_book.text.toString(),et_price.text.toString()))

                    Toast.makeText(this,"新增書名${et_book.text}  價格${et_price.text}",Toast.LENGTH_SHORT).show()

                    et_book.setText("")              //清空輸入框
                    et_price.setText("")
                }catch (e:Exception){
                    Toast.makeText(this,"新增失敗",Toast.LENGTH_SHORT).show()
                }
        }

        //修改資料
        btn_update.setOnClickListener {
            if(et_book.length()<1 || et_price.length()<1)            //檢查欄位是否留空
                Toast.makeText(this,"請輸入欄位",Toast.LENGTH_SHORT).show()
            else
                try{
                    //根據book欄位來更新price欄位的值
                    dbrw.execSQL("UPDATE myTable SET price =${et_price.text} WHERE book LIKE '${et_book.text}'")

                    Toast.makeText(this,"更新書名${et_book.text}  價格${et_price.text}",Toast.LENGTH_SHORT).show()

                    et_book.setText("")              //清空輸入框
                    et_price.setText("")
                }catch (e:Exception){
                    Toast.makeText(this,"更新失敗",Toast.LENGTH_SHORT).show()
                }
        }

        //刪除資料
        btn_delete.setOnClickListener {
            if(et_book.length()<1 || et_price.length()<1)
                Toast.makeText(this,"欄位請勿留空",Toast.LENGTH_SHORT).show()
            else
                try{
                    //新增一筆資料進入myTable資料表
                    dbrw.execSQL("DELETE FROM myTable WHERE book LIKE '${et_book.text}'")

                    Toast.makeText(this,"刪除書名${et_book.text}  價格${et_price.text}",Toast.LENGTH_SHORT).show()

                    et_book.setText("")              //清空輸入框
                    et_price.setText("")
                }catch (e:Exception){
                    Toast.makeText(this,"刪除失敗",Toast.LENGTH_SHORT).show()
                }
        }





    }

    override fun onDestroy() {
        super.onDestroy()
        dbrw.close()              //資料庫不使用時記得關閉
    }
}
