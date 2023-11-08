package com.example.lesson4_orekhova

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson4_orekhova.data.detailList
import com.example.lesson4_orekhova.databinding.ItemBaseBinding

class BaseViewHolder(
    parent: ViewGroup,
    private val onItemClick: (BaseInfoItem) -> Unit,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_base, parent, false),
) {
    private val binding by viewBinding(ItemBaseBinding::bind)

    fun bind(base: BaseInfoItem) = with(binding) {
        root.setOnClickListener {
            onItemClick(base)
        }
        binding.imageViewIcon.setImageResource(base.image)
        binding.textViewId.text = base.name
    }
}