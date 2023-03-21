package com.example.todoapp

import android.annotation.SuppressLint
import android.support.v4.os.IResultReceiver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class SpinnerAdapter(var list:List<Flag>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var Itemview:View
        if (p1 == null){
            Itemview = LayoutInflater.from(p2?.context).inflate(R.layout.spinner_item_view,p2, false)
        }else{
            Itemview = p1
        }
        Itemview.findViewById<TextView>(R.id.flag_name).text =  list[p0].name
        if (list[p0].image != -1)
        Itemview.findViewById<ImageView>(R.id.flag_image).setImageResource(list[p0].image)


        return Itemview
    }
}