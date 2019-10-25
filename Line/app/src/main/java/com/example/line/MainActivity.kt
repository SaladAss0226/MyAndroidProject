package com.example.line

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //***重要***   為什麼要在這邊就將Fragment實例化?
    // 在這邊將Fragment實例化 之後只要呼叫這裡的變數即可 若把實例化放在replace方法裡 會變成每一次呼叫時都產生新的Fragment
    val fragFriend = FragmentFriend()
    val fragChat = FragmentChat()
    val fragArticle = FragmentArticle()
    val fragToday = FragmentToday()
    val fragWallet = FragmentWallet()


    private var listener = object :BottomNavigationView.OnNavigationItemSelectedListener {
       //設定navigationBar裡的item們的點擊事件 被點擊後採動態載入fragment的方式
        override fun onNavigationItemSelected(item : MenuItem): Boolean {
            when (item.itemId) {
                R.id.f1 -> {
                    val manager = supportFragmentManager
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.constraintLay,fragFriend).commit()
                    //replace方法參數為(fragment們所在的containter,要切換的新fragment)
                }
                R.id.f2 -> {
                    title = "聊天"
                    val t = supportFragmentManager.beginTransaction()
                    t.replace(R.id.constraintLay,fragChat).commit()
                }
                R.id.f3 -> {
                    val t = supportFragmentManager.beginTransaction()
                    t.replace(R.id.constraintLay,fragArticle).commit()
                }
                R.id.f4 -> {
                    val t = supportFragmentManager.beginTransaction()
                    t.replace(R.id.constraintLay,fragToday).commit()
                }
                R.id.f5 -> {
                    val t = supportFragmentManager.beginTransaction()
                    t.replace(R.id.constraintLay,fragWallet).commit()
                }
            }
           return true
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Data.createItemList()       //載入資料!


        //使用FragChat當作開啟app時預設的畫面
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.constraintLay,fragChat).commit()

        navigationView.setOnNavigationItemSelectedListener(listener)

        


    }
}
