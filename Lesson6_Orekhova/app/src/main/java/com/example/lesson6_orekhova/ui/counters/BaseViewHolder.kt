package com.example.lesson6_orekhova.ui.counters

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson6_orekhova.R
import com.example.lesson6_orekhova.databinding.ItemBaseBinding

class BaseViewHolder(
    parent: ViewGroup,
    private val baseListener: BaseListener?,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_base, parent, false),
) {
    private val binding by viewBinding(ItemBaseBinding::bind)

    fun bind(base: Counters) = with(binding) {
        root.setOnClickListener {
            baseListener?.onBaseClick(base)
        }
        binding.imageViewIcon.setImageResource(base.image)
        binding.textViewCardName.text = base.name
        binding.textViewNumber.text = base.number.toString()

        if (base.urgent) {
            var textDate = binding.root.resources.getString(R.string.urgent_submission_date)
            textDate += " " + base.submitNumbersDate
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
            val textDate = binding.root.resources.getString(R.string.last_submitted_date) + " "
                base.lastSubmittedDate + " " + binding.root.resources.getString(R.string.next_submission_date) +
                " " + base.nextAccountingTime
            textViewWithDates.text = textDate
        }
    }
}