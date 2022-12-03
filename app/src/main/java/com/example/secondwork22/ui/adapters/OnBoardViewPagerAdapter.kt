package com.example.secondwork22.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.secondwork22.databinding.ItemOnBoardBinding
import com.example.secondwork22.ui.models.BoardModel

class OnBoardViewPagerAdapter(val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<OnBoardViewPagerAdapter.ViewPagerViewHolder>() {
    var list: ArrayList<BoardModel> = arrayListOf()

    inner class ViewPagerViewHolder(val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: BoardModel) {
            binding.tvStart.text = model.title
            binding.txView.text = model.description
            binding.image.setImageResource(model.image)
            binding.tvStart.setOnClickListener {
                onItemClick(layoutPosition)
            }

        }
    }

    fun setData(list: ArrayList<BoardModel>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ItemOnBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}