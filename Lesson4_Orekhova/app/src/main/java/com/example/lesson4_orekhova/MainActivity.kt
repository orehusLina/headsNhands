package com.example.lesson4_orekhova

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4_orekhova.data.detailList
import com.example.lesson4_orekhova.databinding.ActivityMainBinding
import com.example.lesson4_orekhova.data.baseList

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private val itemsAdapter = ItemsAdapter()
    lateinit var courseRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        courseRV = binding.idRVCourses
        val layoutManager = GridLayoutManager(this,2)
        courseRV.layoutManager = layoutManager


        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        binding.toolbar.menu.findItem(R.id.settings).setOnMenuItemClickListener {
            Toast.makeText(this, "Открыли настройки", Toast.LENGTH_SHORT).show()
            true

        }
        binding.idRVCourses.adapter = itemsAdapter.apply {
            onBaseClick = {
                Toast.makeText(this@MainActivity, it.name, Toast.LENGTH_SHORT).show()
            }
            detailListener = DetailListener { detail ->
                Toast.makeText(this@MainActivity, detail.name, Toast.LENGTH_SHORT).show()
            }
        }
        val baseList = baseList(resources).toList()
        val detailList = detailList(resources).toList()

        itemsAdapter.setList(
            listOf(
                *List(7) { position ->
                    ListItem.DetailItem(
                        DetailInfoItem(
                            name = detailList[position].name,
                            description = detailList[position].description,
                            image = detailList[position].image,
                            urgent = detailList[position].urgent,
                        )
                    )
                }.toTypedArray(),
                *List(3) { position ->
                    ListItem.BaseItem(
                        BaseInfoItem(
                            name = baseList[position].name,
                            image = baseList[position].image,
                        )
                    )
                }.toTypedArray(),
            )
        )

        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (itemsAdapter.getItemViewType(position) == TYPE_DETAIL
                    && position != detailList.size - 1) 1
                else 2
            }
        }


    }
}