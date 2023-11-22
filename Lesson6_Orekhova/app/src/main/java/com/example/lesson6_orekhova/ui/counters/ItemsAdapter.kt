package com.example.lesson6_orekhova.ui.counters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

const val TYPE_DETAIL = 0
const val TYPE_BASE = 1

class ItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<Counters>()

    //lateinit var onBaseClick: (Counters) -> Unit
    var detailListener: DetailListener? = null
    var baseListener: BaseListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DETAIL -> DetailViewHolder(parent, detailListener)
            TYPE_BASE -> BaseViewHolder(parent, baseListener)
            else -> error("ViewType not supported")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailViewHolder -> holder.bind(items[position])
            is BaseViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].detailInfoNeeded == true) {
            TYPE_DETAIL
        } else {
            TYPE_BASE
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(items: List<Counters>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}