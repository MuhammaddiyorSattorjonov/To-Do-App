package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityInfoBinding

class Info : AppCompatActivity() {
    lateinit var binding:ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreferences.init(this)
        val name = intent.getStringExtra("shu")
        println(name)

        var planArray = MySharedPreferences.catchList
        var plan1 = User()
        var index = -1
        for (plan in planArray){
            if (plan.toDaName == name){
                plan1 = plan
                index = planArray.indexOf(plan)
                binding.name.text = plan.toDaName
                binding.createDead.text = plan.toDoCreateDeadline
                binding.degree.text = plan.degree?.name
                binding.deadline.text = plan.toDoDeadline
                binding.description.text = plan.toDoDescription
                binding.img.setImageResource(plan.degree!!.image)
                when(plan.level){
                    "Open"->binding.open.isChecked = true
                    "Development"->binding.development.isChecked = true
                    "Reject"->binding.Reject.isChecked = true
                    "Uploading"->binding.Uploading.isChecked = true
                    "Close"->binding.Close.isChecked = true
                }
                break
            }
        }
        binding.ok.setOnClickListener{
            var rad = ""
            if (binding.open.isChecked) rad = "Open"
            if (binding.development.isChecked) rad = "Development"
            if (binding.Uploading.isChecked) rad = "Uploading"
            if (binding.Reject.isChecked) rad = "Reject"
            if (binding.Close.isChecked) rad = "Close"

            plan1.level = rad
            planArray[index] = plan1
            MySharedPreferences.catchList = planArray
            Toast.makeText(this, "${plan1.level} ga o'tkizildi", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}