package com.example.smp6perpus

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smp6perpus.Utils.dropdownOption
import com.example.smp6perpus.Utils.showMaterialDatePicker
import com.example.smp6perpus.Utils.todayDate
import com.example.smp6perpus.databinding.ActivityFormPeminjamanBinding
import com.google.android.material.textfield.TextInputEditText

class FormPeminjamanActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFormPeminjamanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormPeminjamanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etTanggalPinjam.setText(todayDate())
        dropdownOption(binding.etNamaPeminjam, applicationContext, resources.getStringArray(R.array.namaPeminjam))
        dropdownOption(binding.etJudulBukuPinjam, applicationContext, resources.getStringArray(R.array.judulBuku))
        binding.etBatasKembali.setOnClickListener(this)
        binding.btnBatalPinjam.setOnClickListener(this)
        binding.btnSimpanPinjam.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.et_batas_kembali -> {
                showMaterialDatePicker(binding.etBatasKembali, supportFragmentManager)
            }
            R.id.btn_batal_pinjam -> {
                finish()
            }
            R.id.btn_simpan_pinjam -> {
                if (validationNotEmpty()) {
                    Toast.makeText(this, "Buku berhasil disimpan", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Mohon lengkapi data peminjaman", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun validationNotEmpty(): Boolean {
        var isValid = true
        val inputs = listOf(
            binding.etNamaPeminjam,
            binding.etJudulBukuPinjam,
            binding.etTanggalPinjam,
            binding.etBatasKembali,
            binding.etJumlahPinjam
        )
        for (input in inputs) {
            if (input.text.toString().trim().isEmpty()) {
                input.error = "Input tidak boleh kosong"
                isValid = false
            }
        }
        return isValid
    }
}