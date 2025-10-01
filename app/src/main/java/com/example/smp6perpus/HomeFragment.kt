package com.example.smp6perpus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.smp6perpus.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        setUpRvDashboard()
        return binding.root
    }

    private fun init() {
        binding.rvDashboard.layoutManager = GridLayoutManager(activity, 2)
    }
    private fun setUpRvDashboard() {
        val listData: MutableList<DashboardModel> = mutableListOf()

        namaDashboard().forEachIndexed { index, s ->
            listData.add(
                DashboardModel(
                    nama = s,
                    nilai = nilaiDashboard()[index],
                    gambar = gambarDashboard()[index]
                )
            )
        }
        binding.rvDashboard.adapter = DashboardAdapter(listData)
    }
    private fun namaDashboard(): Array<String> = resources.getStringArray(R.array.namaDashboard)
    private fun nilaiDashboard(): IntArray = resources.getIntArray(R.array.nilaiDashboard)
    private fun gambarDashboard(): List<Int> {
        return listOf(
            R.drawable.baseline_local_library_24,
            R.drawable.baseline_local_library_24,
            R.drawable.baseline_local_library_24,
            R.drawable.baseline_local_library_24
        )
    }
}

