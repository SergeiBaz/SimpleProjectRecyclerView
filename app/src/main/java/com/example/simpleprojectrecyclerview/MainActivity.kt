package com.example.simpleprojectrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simpleprojectrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var adapter = AutoAdapter()
    private val imageIdList = listOf(
        R.drawable.auto1,
        R.drawable.auto2,
        R.drawable.auto3,
        R.drawable.auto4,
        R.drawable.auto5,
        R.drawable.auto6,
    )
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            recView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            recView.adapter = adapter
            bAdd.setOnClickListener {
                if (index > 5) index = 0
                val auto = Auto(imageIdList[index], "Auto $index" )
                adapter.addAuto(auto)
                index++
            }
        }
    }
}