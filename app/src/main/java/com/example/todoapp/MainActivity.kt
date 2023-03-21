package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener{
            val intent = Intent(this,ToDoList::class.java)
            startActivity(intent)
        }
        binding.btn2.setOnClickListener{
            val intent = Intent(this,AddToDo::class.java)
            startActivity(intent)
        }
    }
}