package com.example.line

import android.media.Image
import kotlin.random.Random

data class item(
    val id :Int,
    val imgg:Int,
    val namee:String,
    val contentt:String,
    val messageTime:String,
    var unreadd: Int,
    var isSelect:Boolean)

class Data {
    companion object{
        val itemList = mutableListOf<item>()


        val imageList = mutableListOf<Int>(R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img01,R.drawable.img09,R.drawable.img10)
        val nameList = mutableListOf<String>("寶貝","小胖","毛利小五郎","馬麻","飛天小女警","東東","安琪拉","櫻木花道","米卡莎","大橋未久")
        val contentList = mutableListOf<String>("先別說這個了，你聽過安麗嗎?","垃圾 你是不是還欠我2000塊","晚餐要回來吃嗎?","一個人寂寞嗎","你怎麼狠心這樣對我","我討厭你","我必須拯救這個渾沌的世界","你會使用星爆氣流斬嗎?","")

        //宣告方法 在方法裡利用迴圈來產生資料
        fun createItemList(){
            for(i in 0 until 50) {
                val image = imageList[Random.nextInt(imageList.size)]
                val name = nameList[Random.nextInt(nameList.size)]
                val content = nameList[Random.nextInt(contentList.size)]
                val hour = Random.nextInt(24)              //隨機亂數0-23
                val min = Random.nextInt(60)                   //隨機亂數0-59
                var unread = Random.nextInt(100)             //隨機亂數0-99

                val myItem = item(i,image,name,content,"%02d:%02d".format(hour,min),unread,false)
                itemList.add(myItem)
            }

        }
    }
}