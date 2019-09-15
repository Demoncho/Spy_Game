package com.example.spy_game

import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Start_sesssion : AppCompatActivity() {

    val name_of_locations = arrayListOf<String>("Школа","Банк","Университет","Больница","Пляж")

    fun start_game(players: String, time: String){
        val button = findViewById(R.id.button_get_info) as Button
        val text_number_of_player = findViewById(R.id.text_of_info) as TextView
        val text_place = findViewById(R.id.text_name_of_place) as TextView

        val place_id = (0..name_of_locations.size-1).shuffled().first()
        val game = Place_Class(name_of_locations[place_id],players.toInt())

        var i = 1
            button.setOnClickListener {
                if (i <= players.toInt()) {
                    if (button.text == "Получить место") {
                        i++
                        text_place.text = game.get_place()
                        button.text = "Скрыть"
                    } else {
                        text_number_of_player.text = "Игрок номер: " + i.toString()
                        text_place.text = ""
                        button.text = "Получить место"
                    }
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_sesssion)

        val params_of_start = getIntent()

        val players_number = params_of_start.getStringExtra("players")

        val time_number = params_of_start.getStringExtra("time")

        start_game(players_number,time_number)
    }
}
