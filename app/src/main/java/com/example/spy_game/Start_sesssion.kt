package com.example.spy_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Start_sesssion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_sesssion)

        val params_of_start = getIntent()

        val players_number = params_of_start.getStringExtra("players")

        val time_number = params_of_start.getStringExtra("time")

        val tv1 = findViewById(R.id.textView) as TextView
        val tv2 = findViewById(R.id.textView2) as TextView
        tv1.setText(players_number)
        tv2.text = time_number
    }
}
