package com.example.spy_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Timer : AppCompatActivity() {

    lateinit var timer_text: TextView
    lateinit var pause_button: Button
    lateinit var reveal_spy_button: Button
    lateinit var start_game_button: Button
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

    fun reveal_list(view : View){
        stop_timer()
        val list_of_places = Intent(this, List_of_places:: class.java  )
        list_of_places.putExtra("id", getIntent().getStringExtra("id"))
        list_of_places.putExtra("array",getIntent().getStringArrayListExtra("array"))
        startActivity(list_of_places)
    }

    fun start_new_game(view : View){
        val new_game = Intent(this, MainActivity::class.java)
        new_game.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(new_game)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        val time_intent = getIntent()
        time_of_game = time_intent.getStringExtra("time").toLong() * 60000

        timer_text = findViewById(R.id.timer_text)
        reveal_spy_button = findViewById(R.id.reveal_spy_button)
        pause_button = findViewById(R.id.pause_button)
        start_game_button = findViewById(R.id.new_game_button)

        pause_button.setOnClickListener {
            reveal_spy_button.visibility = View.VISIBLE
            reveal_spy_button.isClickable = true

            start_game_button.visibility = View.VISIBLE
            start_game_button.isClickable = true

            start_stop()
        }
        update_timer()
    }
}
