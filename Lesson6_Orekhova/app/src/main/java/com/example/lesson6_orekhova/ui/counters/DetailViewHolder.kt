package com.example.lesson6_orekhova.ui.counters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson6_orekhova.R
import com.example.lesson6_orekhova.databinding.ItemDetailBinding

class DetailViewHolder(
    parent: ViewGroup,
    private val detailListener: DetailListener?,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false),
) {
    private val binding by viewBinding(ItemDetailBinding::bind)

    fun bind(detail: Counters) = with(binding) {

        root.setOnClickListener {
            detailListener?.onDetailClick(detail)
        }

        binding.imageViewIcon.setImageResource(detail.image)
        binding.textViewCardName.text = detail.name
        binding.textViewNumber.text = detail.number.toString()

        if (detail.urgent) {
            var textDate = binding.root.resources.getString(R.string.urgent_submission_date)
            textDate += " " + detail.submitNumbersDate
            binding.textViewWithDates.text = textDate
            val red = binding.root.resources.getColor(R.color.red)
            textViewWithDates.setTextColor(red)
        } else {
            binding.textViewWithDates.setCompoundDrawablesWithIntrinsicBounds(
                null,
                null,
                null,
                null
            )
            val textDate = binding.root.resources.getString(R.string.last_submitted_date) + " " +
                    detail.lastSubmittedDate + " " + binding.root.resources.getString(R.string.next_submission_date) +
                    " " + detail.nextAccountingTime
            textViewWithDates.text = textDate
        }
    }
}