package com.example.smp6perpus

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.smp6perpus.databinding.ActivityFormBukuBinding

class FormBukuActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFormBukuBinding
    private val takePicturePreview = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
            bitmap: Bitmap? ->
        binding.ivBukuBaru.setImageBitmap(bitmap)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setIDBuku()
        dropdownOption()
        binding.btnGambarBuku.setOnClickListener(this)
        binding.btnBatalBuku.setOnClickListener(this)
        binding.btnSimpanBuku.setOnClickListener(this)

    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_gambar_buku -> {
                AmbilGambar()
            }
            R.id.btn_batal_buku -> {
                finish()
            }
            R.id.btn_simpan_buku -> {
                if (validationNotEmpty()) {
                    Toast.makeText(this@FormBukuActivity, "Buku berhasil disimpan", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@FormBukuActivity, "Mohon lengkapi data buku", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun setIDBuku() {
        binding.etIdBuku.setText("B001")
    }
    private fun dropdownOption() {
        binding.etRak.setAdapter(
            ArrayAdapter(
                applicationContext,
                android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.judulBuku)
            )
        )
        binding.etRak.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            Toast.makeText(this@FormBukuActivity, "Anda memilih: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
    private fun AmbilGambar() {
        takePicturePreview.launch(null)
    }
    private fun validationNotEmpty(): Boolean {
        var isValid = true
        val inputs = listOf(
            binding.etIdBuku,
            binding.etJudulBuku,
            binding.etPenerbit,
            binding.etRak,
            binding.etJumlahBuku
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