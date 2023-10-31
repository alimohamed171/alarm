package com.example.alarm

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alarm.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val c = Calendar.getInstance()

        binding.pickTime.setOnClickListener {

            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(
                this,{
                    view,hour,minute ->
                    binding.textView.text=("$hour : $minute")
                }, hour , minute , false
            )
            timePickerDialog.show()
        }

        binding.pickDate.setOnClickListener {
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val DatePickerDialog = DatePickerDialog(
                this,{
                        view, year, monthOfYear, dayOfMonth ->
//                    selectedDateTV.text =
//                        (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    binding.textView2.text=("${dayOfMonth.toString()}-${monthOfYear+1}-" +
                            "$year")

                },year,month,day
            )
            DatePickerDialog.show()
        }








    }








}