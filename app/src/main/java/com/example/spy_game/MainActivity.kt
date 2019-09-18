package com.example.spy_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var checkbox_v1: CheckBox
    lateinit var checkbox_v2: CheckBox
    lateinit var checkbox_time_machine: CheckBox

    fun start_new_game(view: View){
        if (checkbox_v1.isChecked || checkbox_v2.isChecked || checkbox_time_machine.isChecked) {
            val select_param = Intent(this, Select_parametrs_for_new_game::class.java)
            select_param.putExtra("v1",checkbox_v1.isChecked)
            select_param.putExtra("v2",checkbox_v2.isChecked)
            select_param.putExtra("time_machine",checkbox_time_machine.isChecked)
            startActivity(select_param)
        }
        else Toast.makeText(this, "Не выбраны версии", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkbox_v1 = findViewById(R.id.checkBox_v1)
        checkbox_v2 = findViewById(R.id.checkBox_v2)
        checkbox_time_machine = findViewById(R.id.checkBox_time_machine)
    }
}
