package com.example.spy_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Timer : AppCompatActivity() {

    lateinit var timer_text: TextView
    lateinit var pause_button: Button
    lateinit var countdown_timer: CountDownTimer
    private var running_timer: Boolean = true

    fun start_stop(){
        if (running_timer)
            stop_timer()
        else
            start_timer()
    }

    fun stop_timer(){

    }

    fun start_timer(){


    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        timer_text = findViewById(R.id.timer_text)
        pause_button = findViewById(R.id.pause_button)
        pause_button.setOnClickListener {
            start_stop()
        }
    }
}
