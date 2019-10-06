package com.example.spy_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isInvisible

class List_of_places : AppCompatActivity() {

    lateinit var list_of_places: ListView
    lateinit var end_game_text: TextView
    lateinit var new_game_button: Button

    fun start_new_game(view : View){
        val new_game = Intent(this, MainActivity::class.java)
        new_game.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(new_game)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_places)

        end_game_text = findViewById(R.id.end_game_text)
        new_game_button = findViewById(R.id.new_game_button)

        list_of_places = findViewById(R.id.list_of_places)
        val adapter_for_places = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getIntent().getStringArrayListExtra("array"))
        list_of_places.adapter = adapter_for_places
        list_of_places.setOnItemClickListener{parent, view, position, id ->
            list_of_places.visibility = View.INVISIBLE
            end_game_text.visibility = View.VISIBLE
            new_game_button.visibility = View.VISIBLE

            if (list_of_places.getItemAtPosition(position).toString() == getIntent().getStringExtra("id"))
                end_game_text.text = "Победа с:"
            else end_game_text.text =  "Поражение :с"
        }
    }
}
