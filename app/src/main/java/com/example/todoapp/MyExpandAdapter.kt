package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.todoapp.databinding.ItemChildBinding
import com.example.todoapp.databinding.ItemParentBinding

class MyExpandAdapter(var titleList: List<String>, var map: HashMap<String, ArrayList<String>>) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int = titleList.size

    override fun getChildrenCount(p0: Int): Int {
        val groupName = titleList[p0]
        return map[groupName]!!.size
    }

    override fun getGroup(p0: Int): Any {
        return titleList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        val parentName = titleList[p0]
        val listChild = map[parentName]!!
        return listChild[p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, p1: Boolean, p2: View?, parent: ViewGroup?): View {
        val itemParentBinding = ItemParentBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        itemParentBinding.tvParent.text = titleList[groupPosition]
        return itemParentBinding.root
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, p2: Boolean, p3: View?, parent: ViewGroup?): View {
        val itemChildBinding = ItemChildBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        itemChildBinding.tvChild.text = map[titleList[groupPosition]]?.get(childPosition)
        return itemChildBinding.root
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}

