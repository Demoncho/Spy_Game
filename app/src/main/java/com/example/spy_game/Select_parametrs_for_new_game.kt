package com.example.spy_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class Select_parametrs_for_new_game : AppCompatActivity() {

    lateinit var slider_players: SeekBar
    lateinit var value_players: TextView

    lateinit var slider_time: SeekBar
    lateinit var value_time: TextView

    fun start_game_with_param(view: View){

        val players = findViewById(R.id.count_of_players_text) as TextView
        val players_number = players.text.toString().takeLast(1)

        val time = findViewById(R.id.count_of_time_text) as TextView
        val time_number = time.text.toString().takeLast(1)

        val start_game = Intent(this, Start_sesssion::class.java)
        start_game.putExtra("players", players_number)
        start_game.putExtra("time", time_number)
        startActivity(start_game)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_parametrs_for_new_game)

        slider_players = findViewById(R.id.seekBar_count_of_players)
        value_players = findViewById(R.id.count_of_players_text)

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
