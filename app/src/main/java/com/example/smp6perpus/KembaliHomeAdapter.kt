package com.example.smp6perpus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smp6perpus.databinding.ItemTerakhirBinding

class KembaliHomeAdapter(private val kembaliList: List<PinjamModel>): RecyclerView.Adapter<KembaliHomeAdapter.ViewHolder>() {

    class ViewHolder(val binding : ItemTerakhirBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTerakhirBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(kembaliList[position]){
                binding.tvJudulTerakhir.text = this.judulBuku
                binding.tvPeminjamTerakhir.text = this.namaPeminjam
                binding.tvTanggalTerakhir.text = this.tanggal
            }
        }
    }

    override fun getItemCount(): Int = kembaliList.size

}