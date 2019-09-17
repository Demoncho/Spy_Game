package com.example.spy_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Timer : AppCompatActivity() {

    lateinit var timer_text: TextView
    lateinit var pause_button: Button
    internal lateinit var countdown_timer: CountDownTimer
    private var running_timer: Boolean = false
    var time_of_game: Long = 0

    fun start_stop(){
        if (running_timer)
            stop_timer()
        else
            start_timer()
    }

    fun stop_timer(){
        countdown_timer.cancel()
        pause_button.text = "Продолжить"
        running_timer = false
    }

    fun start_timer(){
        countdown_timer = object : CountDownTimer(time_of_game ,1000){
            override fun onTick(millisUntilFinished: Long) {
                time_of_game = millisUntilFinished
                update_timer()
            }

            override fun onFinish() {

            }

        }.start()

        pause_button.text = "Пауза"
        running_timer = true

    }

    fun update_timer(){
        val minutes_left = time_of_game / 60000
        val seconds_left = time_of_game % 60000 / 1000

        var time_left: String = "0"
        time_left += minutes_left.toString()
        time_left += ":"
        if (seconds_left < 10) time_left += "0"
        time_left += seconds_left
        timer_text.text = time_left
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        val time_intent = getIntent()
        time_of_game = time_intent.getStringExtra("time").toLong() * 60000
        timer_text = findViewById(R.id.timer_text)
        pause_button = findViewById(R.id.pause_button)
        pause_button.setOnClickListener {
            start_stop()
        }
        update_timer()
    }
}
