package com.example.smp6perpus

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.smp6perpus.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigation()
        binding.fabAdd.setOnClickListener{
            showBottomSheetForm()
        }
    }

    //setup bottom navbar
    private fun bottomNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
    }

    //install splash screen
    private fun splashScreen() {
        Thread.sleep(1000)
        installSplashScreen()
    }

    //show bottom sheet form
    private fun showBottomSheetForm() {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_add)
        bottomSheetDialog.show()
    }

    fun onTextViewClicked(view: View) {
        when (view.id) {
            R.id.tv_tambah_buku -> {
                val intent =  Intent(this, FormBukuActivity::class.java)
                startActivity(intent)
            }
            R.id.tv_tambah_pinjam -> {
                val intent =  Intent(this, FormPeminjamanActivity::class.java)
                startActivity(intent)
            }
            R.id.tv_tambah_kembali -> {
                val intent =  Intent(this, FormPengembalian::class.java)
                startActivity(intent)
            }
            R.id.tv_tambah_akun -> {
                Toast.makeText(this, "Belum Tersedia", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
