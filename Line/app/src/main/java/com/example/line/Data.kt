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
    var isSelect:Boolean,
    val messageList:MutableList<Msgdata>)            //messageList為存放每個人的聊天室對話紀錄的list

class Data {
    companion object{
        val itemList = mutableListOf<item>()


        private val imageList = mutableListOf<Int>(R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img01,R.drawable.img09,R.drawable.img10)
        private val nameList = mutableListOf<String>("老婆","寶貝","國瑜","毛利小五郎","小魔女","JaVale McGee","明日花","毛利小七八郎","綠巨人","小橋未久","彌豆子","逢坂小河","千反田","金木研","半澤直樹","合成獸","小門未知子")
        private val contentList = mutableListOf<String>("先別說這個了，你聽過安麗嗎?","垃圾 你是不是還欠我2000塊","晚餐要回來吃嗎?","一個人寂寞嗎","你怎麼狠心這樣對我","我討厭你","我必須拯救這個渾沌的世界","你會使用星爆氣流斬嗎?","我現在要出征")

        //宣告方法 在方法裡利用迴圈來產生資料
        fun createItemList(){
            for(i in 0 until 50) {  //0-49 總共50項
                val image = imageList[Random.nextInt(imageList.size)]
                val name = nameList[Random.nextInt(nameList.size)]
                val content = contentList[Random.nextInt(contentList.size)]
                val hour = Random.nextInt(24)              //隨機亂數0-23
                val min = Random.nextInt(60)                   //隨機亂數0-59
                var unread = Random.nextInt(31)             //隨機亂數0-50
                val messageList = mutableListOf<Msgdata>()

                val myItem = item(i,image,name,content,"%02d:%02d".format(hour,min),unread,false,messageList)
                itemList.add(myItem)
            }

        }
    }
}