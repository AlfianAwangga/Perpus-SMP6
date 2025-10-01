package com.example.smp6perpus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smp6perpus.databinding.ItemDashboardBinding

class DashboardAdapter(private val dashboardList: List<DashboardModel>): RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    class ViewHolder(val binding : ItemDashboardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDashboardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(dashboardList[position]){
                binding.tvNumberDashboard.text = this.nilai.toString()
                binding.tvNamaDashboard.text = this.nama
                binding.ivDashboard.setImageResource(this.gambar)
            }
        }
    }

    override fun getItemCount(): Int = dashboardList.size

}