package com.example.spy_game

import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils

class Start_sesssion : AppCompatActivity() {

    var name_of_locations = arrayListOf<String>()

    val name_of_locations_v1 = arrayListOf("Школа","Банк","Университет","Больница","Пляж","База террористов","Киностудия","Партизанский отряд","Полярная станция",
                                                "Супермаркет","Корпоративная вечеринка","Пассажирский поезд","Посольство","Театр","Овощебаза","Пиратский корабль","Ресторан",
                                                "Воинская часть","Океанский лайнер","Самолет","Церковь","Войско крестоносцев","Орбитальная станция","Подводная лодка",
                                                "Спа-салон","Цирк-шапито","Казино","Отель","Полицейский участок","Станция техобслуживания")

    val name_of_locations_v2 = arrayListOf("Стройплощадка", "Стадион",
        "Экскурсионный автобус","Свадьба","Метро","Музей","Рок-концерт","Заправочная станция","Парламент","Дом престрарелых",
        "Шахта","Библиотека","Шоколадная фабрика","Джаз-бенд","Порт","Тюрьма","Кладбище","Виноградник","Автогонки","Выставка кошек")

    val name_of_locations_time_machine = arrayListOf("Бородинская битва","Испанская инквизиция","Лунная станция","Подпольный бар","Троянская война","Вигвам","Караван",
                                        "Мастерская Леонардо","Рота мушкетеров","Турецкий гарем","Воздушный шар","Круг друидов","Монастырь Шаолинь","Рыцарский турнир",
                                        "Фестиваль хиппи","Дирижабль первой мировой","Лагерь золотоискателей","Отряд Робин Гуда","Салун","Французская революция","Древняя олимпиада",
                                        "Лагерь повстанцев","Пещера неандертальцев","Танковый бой","Школа ниндзя","Древнеримский сенат","Ладья викингов","Племя людоедов",
                                        "Строительство пирамид","Эпидемия черной смерти")


    fun start_game(players: String, time: String){
        val button = findViewById(R.id.button_get_info) as Button
        val text_number_of_player = findViewById(R.id.text_of_info) as TextView
        val text_place = findViewById(R.id.text_name_of_place) as TextView

        if(getIntent().getBooleanExtra("v1",false))
            name_of_locations.addAll(name_of_locations_v1)

        if(getIntent().getBooleanExtra("v2",false))
            name_of_locations.addAll(name_of_locations_v2)

        if(getIntent().getBooleanExtra("time_machine",false))
            name_of_locations.addAll(name_of_locations_time_machine)

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
                else if (button.text=="Поехали"){
                    val start_timer = Intent(this, Timer::class.java)
                    start_timer.putExtra("time", time)
                    start_timer.putExtra("id",name_of_locations[place_id])
                    start_timer.putExtra("array",name_of_locations)
                    startActivity(start_timer)
                }
                else {
                    text_place.text = ""
                    text_number_of_player.text=""
                    button.text ="Поехали"
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
