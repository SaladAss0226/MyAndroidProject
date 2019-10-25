package com.example.fingerguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_mora.setOnClickListener {
            if(et_name.length()<1) tv1.text="請輸入玩家姓名!!"
            else {
                //顯示玩家姓名與我方出拳
                tv_player.text= "玩家\n${et_name.text}"

                tv_myTrun.text = "我方出拳\n${if (btn_scissor.isChecked)"剪刀"
                else if (btn_stone.isChecked)"石頭" else "布"}"

                //Random()產生0-1不含1的亂數 *3產生0-2代表電腦的出拳
                val cc = (Math.random()*3).toInt()
                tv_computer.text = "電腦出拳\n${if(cc==0)"剪刀"
                else if(cc==1)"石頭" else "布"}"

                when{
                    btn_stone.isChecked && cc==0 ||
                    btn_scissor.isChecked && cc==2 ||
                    btn_paper.isChecked && cc==1
                    -> {
                        tv_winner.text = "勝利者\n${et_name.text}"
                        tv1.setText("恭喜你獲勝了!!")
                    }
                            btn_stone.isChecked && cc==2 ||
                            btn_scissor.isChecked && cc==1 ||
                            btn_paper.isChecked && cc==0
                    -> {
                        tv_winner.text = "勝利者\n電腦"
                        tv1.setText("你輸了QQQQ")
                    }
                    else -> {
                        tv_winner.text = "勝利者\n平手"
                        tv1.setText("平局，請再試一次")
                    }



                }



            }
        }
















    }
}
