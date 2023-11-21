package com.example.lesson4_orekhova

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson4_orekhova.databinding.ItemDetailBinding
import kotlinx.coroutines.currentCoroutineContext
import java.security.AccessController.getContext

class DetailViewHolder(
    parent: ViewGroup,
    private val detailListener: DetailListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false),
) {
    private val binding by viewBinding(ItemDetailBinding::bind)

    fun bind(detail: DetailInfoItem) = with(binding) {

        root.setOnClickListener {
            detailListener.onDetailClick(detail)
        }

        binding.imageViewIcon.setImageResource(detail.image)
        binding.textViewId.text = detail.name
        binding.textViewFullName.text = detail.description
        if (detail.urgent) {
            val red = binding.root.resources.getColor(R.color.red)
            textViewFullName.setTextColor(red)
        }
    }
}