package com.example.lesson4_orekhova

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4_orekhova.data.listAll
import com.example.lesson4_orekhova.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private val itemsAdapter = ItemsAdapter()
    private lateinit var courseRV: RecyclerView

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
                Snackbar.make(binding.idRVCourses, it.name, Snackbar.LENGTH_SHORT).show()
            }
            detailListener = DetailListener { detail ->
                Snackbar.make(binding.idRVCourses, detail.name, Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.toolbar.menu.findItem(R.id.idIconAbout).setOnMenuItemClickListener {
            val myDialogFragment = MyDialogFragment()
            val manager = supportFragmentManager
            val transaction: FragmentTransaction = manager.beginTransaction()
            myDialogFragment.show(transaction, "dialog")
            true
        }

        itemsAdapter.setList(listAll(resources))

        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (itemsAdapter.getItemViewType(position) == TYPE_DETAIL ||
                    (listAll(resources).size % 2 != 0 && position == listAll(resources).size - 1)) 1
                else 2
            }
        }

        val spanCount = 2
        val space = (2 * resources.displayMetrics.density).toInt()
        binding.idRVCourses.addItemDecoration(
            SpacesItemDecoration(space, spanCount)
        )
    }
}