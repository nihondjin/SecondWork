package com.example.secondwork22.ui.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.secondwork22.R
import com.example.secondwork22.databinding.FragmentOnBoardBinding
import com.example.secondwork22.ui.adapters.OnBoardViewPagerAdapter
import com.example.secondwork22.ui.models.BoardModel

class OnBoardFragment : Fragment(){
    private lateinit var binding : FragmentOnBoardBinding
    private val viewPagerAdapter = OnBoardViewPagerAdapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setupListeners()
    }
    private fun setupListeners() {
        binding.pager.setOnClickListener {
            binding.pager.setCurrentItem(binding.pager.currentItem + 1, true)
        }
        binding.startBtn.setOnClickListener {
            if (binding.pager.currentItem == 2) {
                findNavController().navigate(R.id.homeFragment)
            } else
                binding.pager.setCurrentItem(binding.pager.currentItem + 1, true)
        }

    }

    private fun getData() {
        setupAdapter()
        changeButtonTextDependingOnPagerCurrentItem()
    }

    private fun changeButtonTextDependingOnPagerCurrentItem() {
        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    2 -> binding.startBtn.text = ""
                    else -> binding.startBtn.text = "Пропустить"
                }
            }
        })
    }
    private fun getBoardList(): ArrayList<BoardModel> {
        val list: ArrayList<BoardModel> = arrayListOf()
        list.add(
            BoardModel(
                R.drawable.image,
                "", "Очень удобный функционал ",
            )
        )
        list.add(
            BoardModel(
                R.drawable.rectabgle, "", "Быстрый, качественный продукт",
            )
        )
        list.add(
            BoardModel(
                R.drawable.rectangle_two,
                "Начать работу",
                "Куча функций и интересных фишек",
            )
        )
        return list
    }

    private fun setupAdapter() {
        binding.pager.adapter = viewPagerAdapter
        viewPagerAdapter.setData(getBoardList())
        binding.dotsIndicator.attachTo(binding.pager)
    }



    private fun onItemClick(position: Int) {
        when (position) {
            0 -> {
                binding.pager.setCurrentItem(1, true)
            }
            1 -> {
                binding.pager.setCurrentItem(2, true)
            }
            2 -> {
                findNavController().navigate(R.id.homeFragment)
            }
        }
    }
}