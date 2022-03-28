package com.chathuranga.assignment02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        val saveBtn = findViewById<Button>(R.id.saveBtn)
        val showInfoBtn = findViewById<Button>(R.id.showInfoBtn)
        val ageEt = findViewById<EditText>(R.id.ageEt)
        val switch1 = findViewById<Switch>(R.id.switch1)
        val infoTv = findViewById<TextView>(R.id.infoTv)

        saveBtn.setOnClickListener{
            val name =  findViewById<EditText>(R.id.nameEt).text.toString().trim()
            val age = Integer.parseInt(ageEt.text.toString().trim())
            val experienced = switch1.isChecked

            val editor = sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putInt("AGE", age)
            editor.putBoolean("EXPERIENCED", experienced)

            editor.apply()
        }

        showInfoBtn.setOnClickListener{
            val name = sharedPreferences.getString("NAME", "")
            val age = sharedPreferences.getInt("AGE", 0)
            var experience = "No"

            if(sharedPreferences.getBoolean("EXPERIENCED", false)){
                experience = "Yes"
            }

            infoTv.text = "Name: $name \nAge: $age \nExperience: $experience"
        }

    }
}