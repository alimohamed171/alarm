package com.example.alarm

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.TimePickerDialog
import android.os.Build
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



        createNotificationChannel()


        binding.pickTime.setOnClickListener {

            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(
                this,{
                    view,hour,minute ->
                    binding.textView.text= "$hour : $minute"
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

                    binding.textView2.text="${dayOfMonth}-${monthOfYear+1}-" +
                            "$year"

                },year,month,day
            )
            DatePickerDialog.show()
        }








    }


    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "ak channel"
            val description = "Channel for Alarm Manager"
            val imp = NotificationManager.IMPORTANCE_HIGH
            val channel : NotificationChannel = NotificationChannel("Alarm",name,imp)
            channel.description = description
            val notificationManager : NotificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }







}