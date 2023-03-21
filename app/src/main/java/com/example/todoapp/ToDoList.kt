package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todoapp.databinding.ActivityToDoListBinding

class ToDoList : AppCompatActivity() {
    lateinit var map: HashMap<String, ArrayList<String>>
    lateinit var titleList:ArrayList<String>

    lateinit var openArray:ArrayList<String>
    lateinit var developmentArray:ArrayList<String>
    lateinit var uploadingArray:ArrayList<String>
    lateinit var rejectArray:ArrayList<String>
    lateinit var closedArray:ArrayList<String>
    lateinit var binding:ActivityToDoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreferences.init(this)
        keshdanArrayga()


        binding.expandList.setOnChildClickListener { expandableListView, view, groupposition, childposition, id ->
            val intent = Intent(this,Info::class.java)
            intent.putExtra("shu",map[titleList[groupposition]]?.get(childposition))
            startActivity(intent)
            true
        }
    }
    private fun keshdanArrayga() {
        map = HashMap()
        titleList = ArrayList()
        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Close")

        openArray = ArrayList()
        developmentArray = ArrayList()
        uploadingArray = ArrayList()
        rejectArray = ArrayList()
        closedArray = ArrayList()

        var planArray: ArrayList<User>
        planArray = MySharedPreferences.catchList
        println(planArray)
        var nameArray = ArrayList<User>()
        for (todoPlan in planArray) {
            if (todoPlan.level == "Open"){
                openArray.add(todoPlan.toDaName)
            }
            if (todoPlan.level == "Development"){
                developmentArray.add(todoPlan.toDaName)
            }
            if (todoPlan.level == "Uploading"){
                uploadingArray.add(todoPlan.toDaName)
            }
            if (todoPlan.level == "Reject"){
                rejectArray.add(todoPlan.toDaName)
            }
            if (todoPlan.level == "Close"){
                closedArray.add(todoPlan.toDaName)
            }
        }

        map[titleList[0]] = openArray
        map[titleList[1]] = developmentArray
        map[titleList[2]] = uploadingArray
        map[titleList[3]] = rejectArray
        map[titleList[4]] = closedArray

    }


    override fun onStart() {
        super.onStart()
        MySharedPreferences.init(this)
        keshdanArrayga()
        val spinerAdapter1 = MyExpandAdapter(titleList, map)
        binding.expandList.setAdapter(spinerAdapter1)
    }
}