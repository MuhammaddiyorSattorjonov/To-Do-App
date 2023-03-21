package com.example.todoapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityAddToDoBinding
import java.util.Calendar

class AddToDo : AppCompatActivity() {
    lateinit var binding: ActivityAddToDoBinding
    lateinit var userArray:ArrayList<Flag>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        MySharedPreferences.init(this)

        val spinnerAdapter = SpinnerAdapter(userArray)
        binding.spinner.adapter = spinnerAdapter

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val c1 = Calendar.getInstance()
        val year1 = c1.get(Calendar.YEAR)
        val month1 = c1.get(Calendar.MONTH)
        val day1 = c1.get(Calendar.DAY_OF_MONTH)

        binding.data.setOnClickListener(){
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{viewModelStore,mYear,mMonth,mDay->
                binding.data.setText(""+mDay+"/"+mMonth+"/"+mYear)
            },year,month,day)
            dpd.show()
        }
        binding.deadline.setOnClickListener(){
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{viewModelStore,mYear,mMonth,mDay->
                binding.deadline.setText(""+mDay+"/"+mMonth+"/"+mYear)
            },year1,month1,day1)
            dpd.show()
        }

        binding.save.setOnClickListener{
            val toDoName = binding.name.text.toString().trim()
            val toDoDescription = binding.description.text.toString().trim()
            val toDoCreateData = binding.data.text.toString().trim()
            val toDoDedline = binding.deadline.text.toString().trim()

            val degree = userArray[binding.spinner.selectedItemPosition]
            if (toDoName.isNotEmpty()&&toDoDescription.isNotEmpty()&&toDoCreateData.isNotEmpty()&&toDoDedline.isNotEmpty()){
                val list = MySharedPreferences.catchList
                list.add(User(toDoName,toDoDescription,degree,toDoCreateData,toDoDedline,"Open"))
                MySharedPreferences.catchList = list
                finish()
                Toast.makeText(this, "save", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Ma'lumotlarni to'ldiring", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun loadData(){
        userArray = ArrayList()
        userArray.add(Flag(-1,"To Do Degree"))
        userArray.add(Flag(R.drawable.red,"Urgent"))
        userArray.add(Flag(R.drawable.yellow,"High"))
        userArray.add(Flag(R.drawable.blue,"Normal"))
        userArray.add(Flag(R.drawable.green,"Low"))
    }
}