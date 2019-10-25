package com.example.imagelistbyrecycleview

data class item(val imagee:Int,val textt:String) //宣告item資料型態是一張圖片和一個字串

val itemList = mutableListOf(             //宣告一個list放item們
    item(R.drawable.image01, "hi"),
    item(R.drawable.image02, "hey"),
    item(R.drawable.image03, "hey"),
    item(R.drawable.img04, "hey"),
    item(R.drawable.img05, "hey"),
    item(R.drawable.img06, "hey"),
    item(R.drawable.img07, "hey"),
    item(R.drawable.img08, "hey"),
    item(R.drawable.img09, "hey"),
    item(R.drawable.img10, "hey"),
    item(R.drawable.img11, "hey"),
    item(R.drawable.img12, "hey")
)
