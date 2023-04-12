package com.example.simpleprojectrecyclerview

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.simpleprojectrecyclerview.databinding.ActivityEditBinding
import com.example.simpleprojectrecyclerview.databinding.AutoItemBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.auto1
    private val imageIdList = listOf(
        R.drawable.auto1,
        R.drawable.auto2,
        R.drawable.auto3,
        R.drawable.auto4,
        R.drawable.auto5,
        R.drawable.auto6,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        bNextIm.setOnClickListener {
            indexImage++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
            Log.d("MyLog", "Index: $indexImage")
        }
        bDone.setOnClickListener {
            val auto = Auto(imageId, editTitle.text.toString(), edDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("auto", auto)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }

    }
}