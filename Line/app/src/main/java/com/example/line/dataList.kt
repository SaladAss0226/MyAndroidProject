package com.example.line

//data class item(
//     val imgg:Int,
//     val namee:String,
//     val contentt:String,
//     val messageTime:String,
//     var unreadd: Int,
//     var isSelect:Boolean)



// val itemList = mutableListOf(
//     item(R.drawable.img01,"安安","先別說這個了，你聽過安麗嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),   //隨機未讀數量),
//item(R.drawable.img02,"小胖","垃圾你是不是還欠我2000塊","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//item(R.drawable.img03,"老先覺-彰化中山店","老編好累","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//item(R.drawable.img04,"馬麻","晚餐要回來吃嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//item(R.drawable.img05,"MUSE Taichung","早安早安~~又到了一週活動預告...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//item(R.drawable.img06,"東東","東東 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//item(R.drawable.img07,"安琪拉","一個人寂寞嗎","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//item(R.drawable.img08,"汪家三姐弟(3)","一坨屎 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//item(R.drawable.img09,"帶著夢想去旅行(132)","【特惠團】沙巴限定GO~兩晚希爾頓，彩虹島浮潛、龍沙灣生態、渡假村旅拍...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//item(R.drawable.img10,"chloeee","確定是五六日","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//
//     item(R.drawable.img01,"安安","先別說這個了，你聽過安麗嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),   //隨機未讀數量),
//     item(R.drawable.img02,"小胖","垃圾你是不是還欠我2000塊","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img03,"老先覺-彰化中山店","老編好累","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img04,"馬麻","晚餐要回來吃嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img05,"MUSE Taichung","早安早安~~又到了一週活動預告...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img06,"東東","東東 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img07,"安琪拉","一個人寂寞嗎","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img08,"汪家三姐弟(3)","一坨屎 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img09,"帶著夢想去旅行(132)","【特惠團】沙巴限定GO~兩晚希爾頓，彩虹島浮潛、龍沙灣生態、渡假村旅拍...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img10,"chloeee","確定是五六日","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//
//     item(R.drawable.img01,"安安","先別說這個了，你聽過安麗嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),   //隨機未讀數量),
//     item(R.drawable.img02,"小胖","垃圾你是不是還欠我2000塊","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img03,"老先覺-彰化中山店","老編好累","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img04,"馬麻","晚餐要回來吃嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img05,"MUSE Taichung","早安早安~~又到了一週活動預告...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img06,"東東","東東 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img07,"安琪拉","一個人寂寞嗎","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img08,"汪家三姐弟(3)","一坨屎 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img09,"帶著夢想去旅行(132)","【特惠團】沙巴限定GO~兩晚希爾頓，彩虹島浮潛、龍沙灣生態、渡假村旅拍...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img10,"chloeee","確定是五六日","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//
//     item(R.drawable.img01,"安安","先別說這個了，你聽過安麗嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),   //隨機未讀數量),
//     item(R.drawable.img02,"小胖","垃圾你是不是還欠我2000塊","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img03,"老先覺-彰化中山店","老編好累","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img04,"馬麻","晚餐要回來吃嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img05,"MUSE Taichung","早安早安~~又到了一週活動預告...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img06,"東東","東東 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img07,"安琪拉","一個人寂寞嗎","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img08,"汪家三姐弟(3)","一坨屎 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img09,"帶著夢想去旅行(132)","【特惠團】沙巴限定GO~兩晚希爾頓，彩虹島浮潛、龍沙灣生態、渡假村旅拍...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img10,"chloeee","確定是五六日","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//
//     item(R.drawable.img01,"安安","先別說這個了，你聽過安麗嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),   //隨機未讀數量),
//     item(R.drawable.img02,"小胖","垃圾你是不是還欠我2000塊","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img03,"老先覺-彰化中山店","老編好累","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img04,"馬麻","晚餐要回來吃嗎?","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img05,"MUSE Taichung","早安早安~~又到了一週活動預告...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img06,"東東","東東 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img07,"安琪拉","一個人寂寞嗎","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img08,"汪家三姐弟(3)","一坨屎 傳送了貼圖","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img09,"帶著夢想去旅行(132)","【特惠團】沙巴限定GO~兩晚希爾頓，彩虹島浮潛、龍沙灣生態、渡假村旅拍...","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false),
//     item(R.drawable.img10,"chloeee","確定是五六日","%02d:%02d".format((Math.random()*24).toInt(),(Math.random()*60).toInt()),(Math.random()*100).toInt(),false)


 //     )