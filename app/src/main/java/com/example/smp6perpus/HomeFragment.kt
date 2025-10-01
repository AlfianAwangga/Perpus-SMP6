package com.example.smp6perpus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
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
        setUpRvTerakhir()
        return binding.root
    }

    private fun init() {
        binding.rvDashboard.layoutManager = GridLayoutManager(activity, 2)
        binding.rvPinjamTerakhir.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvKembaliTerakhir.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
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
    private fun setUpRvTerakhir() {
        val listData: MutableList<PinjamModel> = mutableListOf()
        idBuku().forEachIndexed { index, s ->
            listData.add(
                PinjamModel(
                    idBuku = s.toInt(),
                    judulBuku = judulBuku()[index],
                    IdPeminjam = idPeminjam()[index],
                    namaPeminjam = namaPeminjam()[index],
                    tanggal = tanggal()[index]
                )
            )
        }
        binding.rvPinjamTerakhir.adapter = PinjamHomeAdapter(listData)
        binding.rvKembaliTerakhir.adapter = KembaliHomeAdapter(listData)
    }
    private fun idBuku(): Array<String> = resources.getStringArray(R.array.idBuku)
    private fun judulBuku(): Array<String> = resources.getStringArray(R.array.judulBuku)
    private fun idPeminjam(): Array<String> = resources.getStringArray(R.array.idPeminjam)
    private fun namaPeminjam(): Array<String> = resources.getStringArray(R.array.namaPeminjam)
    private fun tanggal(): Array<String> = resources.getStringArray(R.array.tanggal)
}

