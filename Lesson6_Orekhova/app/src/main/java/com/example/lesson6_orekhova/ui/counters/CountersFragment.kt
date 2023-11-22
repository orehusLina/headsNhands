package com.example.lesson6_orekhova.ui.counters

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson6_orekhova.R
import com.example.lesson6_orekhova.data.listAll
import com.example.lesson6_orekhova.databinding.FragmentCountersBinding

class CountersFragment : Fragment() {

    private var _binding: FragmentCountersBinding? = null
    private val itemsAdapter = ItemsAdapter()
    private lateinit var courseRV: RecyclerView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val countersViewModel =
            ViewModelProvider(this).get(CountersViewModel::class.java)

        _binding = FragmentCountersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        courseRV = binding.idRVCourses
        courseRV.adapter = itemsAdapter
        val layoutManager = LinearLayoutManager(context)
        courseRV.layoutManager = layoutManager
        itemsAdapter.setList(listAll(resources))

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}