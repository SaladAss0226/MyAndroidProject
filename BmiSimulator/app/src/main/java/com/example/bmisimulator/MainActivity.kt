package com.example.bmisimulator

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            when{
                et_height.length()<1 ->Toast.makeText(this,"請輸入身高",Toast.LENGTH_SHORT).show()
                et_weight.length()<1 ->Toast.makeText(this,"請輸入體重",Toast.LENGTH_SHORT).show()
                else         -> runAsyncTask()
            }
        }
    }

    private fun runAsyncTask(){
        object :AsyncTask<Void,Int,Boolean>(){
            override fun onPreExecute() {
                super.onPreExecute()
                tv_weight.text = "標準體重\n無"       //初始化計算結果
                tv_bmi.text = "體脂肪\n無"
                progressBar2.progress = 0             //初始化模擬的進度條
                tv_progress.text = "0%"
                LL_progress.visibility = View.VISIBLE
            }

            override fun doInBackground(vararg params: Void?): Boolean {   //製作模擬進度條:
                var progressss = 0
                while(progressss<=100){                        //建立迴圈執行100次 總共睡5秒
                    try {
                        Thread.sleep(50)
                        publishProgress(progressss)            //傳出progressss(型別為Int) 給onProgressUpdate
                        progressss++
                    }catch (e:InterruptedException){
                        e.printStackTrace()
                    }
                }
                return true                                   //迴圈結束後 傳出布林值true給onPostExcute並執行onPostExcute方法
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                values[0]?.let {
                    progressBar2.progress = it                        //接收doInBackground傳來的progressss的數值
                    progressBar.progress = it
                    tv_progress.text = "$it%"
                }
            }

            override fun onPostExecute(result: Boolean?) {
                LL_progress.visibility = View.GONE

                val cal_height = et_height.text.toString().toDouble()   //身高
                val cal_weight = et_weight.text.toString().toDouble()   //體重
                val cal_standWeight:Double
                val cal_bodyFat:Double

                if(rbtn_boy.isChecked){        //男生的bmi計算方式
                    cal_standWeight = (cal_height-80)*0.7
                    cal_bodyFat = (cal_weight-cal_standWeight*0.88)/cal_weight*100
                }else{                       //女生的bmi計算方式
                    cal_standWeight = (cal_height-70)*0.6
                    cal_bodyFat = (cal_weight-cal_standWeight*0.82)/cal_weight*100
                }

                tv_weight.text = "標準體重\n${String.format("%.2f",cal_standWeight)}"
                tv_bmi.text = "體脂肪\n${String.format("%.2f",cal_bodyFat)}"
            }

        }.execute()
    }
}
