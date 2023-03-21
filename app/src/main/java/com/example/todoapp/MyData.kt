package com.example.todoapp

import java.util.SplittableRandom

object MyData {
    val map = HashMap<String,ArrayList<User>>()
    val tittleList =ArrayList<String>()

    fun addMap(){
        tittleList.add("Open")
        tittleList.add("Development")
        tittleList.add("Uploading")
        tittleList.add("Reject")
        tittleList.add("Closed")

        val open = arrayListOf<User>()
        val development = arrayListOf<User>()
        val uploading = arrayListOf<User>()
        val reject = arrayListOf<User>()
        val closed = arrayListOf<User>()

        map[tittleList[0]] = open
        map[tittleList[1]] = development
        map[tittleList[2]] = uploading
        map[tittleList[3]] = reject
        map[tittleList[4]] = closed
    }
}