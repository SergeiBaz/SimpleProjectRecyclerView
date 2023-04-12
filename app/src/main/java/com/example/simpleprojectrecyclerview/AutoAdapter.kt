package com.example.simpleprojectrecyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleprojectrecyclerview.databinding.AutoItemBinding

class AutoAdapter: RecyclerView.Adapter<AutoAdapter.AutoHolder>() {
    private val autoList = ArrayList<Auto>()
    class AutoHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = AutoItemBinding.bind(item)
        fun bind(auto: Auto) = with(binding){
            imageAuto.setImageResource(auto.imageID)
            tvTitle.text = auto.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.auto_item, parent, false)
        return AutoHolder(view)
    }

    override fun getItemCount(): Int {
        return autoList.size
    }

    override fun onBindViewHolder(holder: AutoHolder, position: Int) {
        holder.bind(autoList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAuto(auto: Auto){
        autoList.add(auto)
        notifyDataSetChanged()
    }

}