package com.example.smp6perpus

import android.app.DatePickerDialog
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object Utils {
    fun todayDate(): String {
        val today = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            .format(Date())

        return today
    }

    fun dropdownOption(et: AutoCompleteTextView, context: Context, text: Array<String>) {
        et.setAdapter(
            ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, text)
        )
        et.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            Toast.makeText(context, "Anda memilih: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }

    fun showMaterialDatePicker(et: TextInputEditText, fm: FragmentManager) {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Pilih Tanggal")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        datePicker.addOnPositiveButtonClickListener { selection ->
            val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                .format(Date(selection))
            et.setText(date)
        }

        datePicker.show(fm, "DATE_PICKER")
    }
    fun showDialogDatePicker(context: Context, et: TextInputEditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                et.setText(selectedDate)
            },
            year, month, day
        )
        datePicker.show()
    }
}