package com.example.spy_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class Select_parametrs_for_new_game : AppCompatActivity() {

    lateinit var slider_players: SeekBar
    lateinit var value_players: TextView

    lateinit var slider_time: SeekBar
    lateinit var value_time: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_parametrs_for_new_game)

        slider_players = findViewById(R.id.seekBar_count_of_players) as SeekBar
        value_players = findViewById(R.id.count_of_players_text) as TextView

        slider_players.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                value_players.text = "Количество игроков: " + (progress.toInt() + 4).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                value_players.text = "Количество игроков: " + (seekBar.progress.toInt() + 4).toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                value_players.text = "Количество игроков: " + (seekBar.progress.toInt() + 4).toString()
            }
        })

        slider_time = findViewById(R.id.seekBar_count_of_time) as SeekBar
        value_time = findViewById(R.id.count_of_time_text) as TextView

        slider_time.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                value_time.text = "Время(мин): " + (progress.toInt() + 4).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                value_time.text = "Время(мин): " + (seekBar.progress.toInt() + 4).toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                value_time.text = "Время(мин): " + (seekBar.progress.toInt() + 4).toString()
            }
        })

    }
}
