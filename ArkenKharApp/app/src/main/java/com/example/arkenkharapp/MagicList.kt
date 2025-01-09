package com.example.arkenkharapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arkenkharapp.databinding.AllMagicBinding

class MagicList : BaseActivity() {

    private lateinit var binding: AllMagicBinding

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_magic)
        binding = AllMagicBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    private fun setupImageViewClickListeners() {
        val imageViews = listOf(
            binding.air,
            binding.water,
            binding.earth,
            binding.fire,
            binding.ice,
            binding.blood,
            binding.death,
            binding.time,
            binding.shadow,
            binding.light,
            binding.dark,
            binding.curse
        )

        imageViews.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val imageName = when(index) {
                    0 -> "Air"
                    1 -> "Water"
                    2 -> "Earth"
                    3 -> "Fire"
                    4 -> "Ice"
                    5 -> "Blood"
                    6 -> "Death"
                    7 -> "Time"
                    8 -> "Shadow"
                    9 -> "Light"
                    10 -> "Dark"
                    11 -> "Curse"
                    else -> ""
                }
            }
        }
    }
}
