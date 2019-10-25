package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chen01_fragment.*
import androidx.recyclerview.widget.RecyclerView.LayoutManager as LayoutManager1

class chen01_Fragment :Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val i = inflater.inflate(R.layout.chen01_fragment,container,false)
        return i
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val LL =LinearLayoutManager(context)
        LL.orientation = LinearLayoutManager.VERTICAL
        recyclerViewww.layoutManager = LL
        recyclerViewww.adapter =chen01_Adapter()




    }

}