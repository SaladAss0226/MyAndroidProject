package com.example.sqlite_pra

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//SQLite只有三種資料型態:INTEGER整數 REAL小數 TEXT字串
//SQL語法沒有大小寫之分
class MyDBHelper(context: Context,name:String= database,factory:SQLiteDatabase.CursorFactory?=null
,version:Int = v):SQLiteOpenHelper(context,name,factory,version) {
    companion object{
        private const val database = "mdatabase.db"     //資料庫名稱
        private const val v = 1                         //資料庫版本
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table myTable(book text PRIMARY KEY,price integer NOT NULL)")
        //建立一個名為mytable的資料表  有book(text)(設有主鍵)與price(integer)兩個欄位
    }

    //SQLiteOpenHelper偵測到資料庫版本更新時 會呼叫此方法 所以我們必須在裡面加入刪除舊表格的語法
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS myTable")   //若mytable已存在 將其刪除
        onCreate(db)                                        //重新執行onCreate 建立新表單

    }

}