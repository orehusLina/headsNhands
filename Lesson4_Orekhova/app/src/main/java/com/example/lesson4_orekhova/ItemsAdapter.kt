package com.example.lesson4_orekhova

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

const val TYPE_DETAIL = 0
const val TYPE_BASE = 1

class ItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<ListItem>()

    lateinit var onBaseClick: (BaseInfoItem) -> Unit
    lateinit var detailListener: DetailListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DETAIL -> DetailViewHolder(parent, detailListener)
            TYPE_BASE -> BaseViewHolder(parent, onBaseClick)
            else -> error("ViewType not supported")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailViewHolder -> holder.bind((items[position] as ListItem.DetailItem).detailItem)
            is BaseViewHolder -> holder.bind((items[position] as ListItem.BaseItem).baseItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is ListItem.DetailItem) {
            TYPE_DETAIL
        } else {
            TYPE_BASE
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(items: List<ListItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}