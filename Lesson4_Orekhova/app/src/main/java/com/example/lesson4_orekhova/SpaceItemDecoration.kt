package com.example.lesson4_orekhova

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class SpacesItemDecoration(private val space: Int, private val spanCount: Int) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position: Int = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        outRect.left = space - column * space / spanCount
        outRect.right = (column + 1) * space / spanCount

        if (position < spanCount) {
            outRect.top = space
        }
    }
}