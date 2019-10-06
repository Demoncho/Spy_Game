package com.example.spy_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class Start_sesssion : AppCompatActivity() {

    val spy_pict = arrayListOf<String>("http://pngimg.com/uploads/spy/spy_PNG12.png",
        "https://st.depositphotos.com/2196544/2312/i/450/depositphotos_23120686-stock-photo-sneaking-spy.jpg",
        "https://vignette.wikia.nocookie.net/town-of-salem/images/3/36/Spy.png/revision/latest?cb=20170420102900&path-prefix=ru")

    var name_of_locations = hashMapOf<String, String>()

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

    val name_of_locations_v1_dict = mapOf("Школа" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                          "Банк" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                          "Университет" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                          "Больница" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                          "Пляж" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "База террористов" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Киностудия" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Партизанский отряд" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Полярная станция" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Супермаркет" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Корпоративная вечеринка" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Пассажирский поезд" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Посольство" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Театр" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Овощебаза" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Пиратский корабль" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Ресторан" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Воинская часть" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Океанский лайнер" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Самолет" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Церковь" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Войско крестоносцев" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Орбитальная станция" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Подводная лодка" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Спа-салон" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Цирк-шапито" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Казино" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Отель" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Полицейский участок" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Станция техобслуживания" to "http://memesmix.net/media/created/d6q4kb.jpg")

    val name_of_locations_v2_dict = mapOf("Стройплощадка" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Стадион" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Экскурсионный автобус" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Свадьба" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Метро" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Музей" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Рок-концерт" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Заправочная станция" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Парламент" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Дом престрарелых" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Шахта" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Библиотека" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Шоколадная фабрика" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Джаз-бенд" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Порт" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Тюрьма" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Кладбище" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Виноградник" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Автогонки" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                        "Выставка кошек" to "http://memesmix.net/media/created/d6q4kb.jpg")

    val name_of_locations_time_machine_dict = mapOf("Бородинская битва" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Испанская инквизиция" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Лунная станция" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Подпольный бар" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Троянская война" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Вигвам" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Караван" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Мастерская Леонардо" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Рота мушкетеров" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Турецкий гарем" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Воздушный шар" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Круг друидов" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Монастырь Шаолинь" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Рыцарский турнир" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Фестиваль хиппи" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Дирижабль первой мировой" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Лагерь золотоискателей" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Отряд Робин Гуда" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Салун" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Французская революция" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Древняя олимпиада" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Лагерь повстанцев" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Пещера неандертальцев" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Танковый бой" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Школа ниндзя" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Древнеримский сенат" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Ладья викингов" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Племя людоедов" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Строительство пирамид" to "http://memesmix.net/media/created/d6q4kb.jpg",
                                                    "Эпидемия черной смерти" to "http://memesmix.net/media/created/d6q4kb.jpg")


    fun start_game(players: String, time: String){
        val button = findViewById(R.id.button_get_info) as Button
        val text_number_of_player = findViewById(R.id.text_of_info) as TextView
        val text_place = findViewById(R.id.text_name_of_place) as TextView

        if(getIntent().getBooleanExtra("v1",false))
            name_of_locations.putAll(name_of_locations_v1_dict)

        if(getIntent().getBooleanExtra("v2",false))
            name_of_locations.putAll(name_of_locations_v2_dict)

        if(getIntent().getBooleanExtra("time_machine",false))
            name_of_locations.putAll(name_of_locations_time_machine_dict)

        val place_id = (0..name_of_locations.size-1).shuffled().first()

        val place_name = arrayListOf<String>()
        name_of_locations.forEach{(k, v) -> place_name.add(k)}

        val game = Place_Class(place_name[place_id],players.toInt())

        val imageView = findViewById(R.id.image_place) as ImageView

        Picasso.get().load(name_of_locations[place_name[place_id]]).into(imageView)

        var i = 1
            button.setOnClickListener {
                if (i <= players.toInt()) {
                    if (button.text == "Получить место") {
                        i++
                        imageView.visibility = View.VISIBLE
                        text_place.text = game.get_place()
                        if (text_place.text == "Шпион")
                            Picasso.get().load(spy_pict.shuffled().first()).into(imageView)
                        else Picasso.get().load(name_of_locations[place_name[place_id]]).into(imageView)
                        button.text = "Скрыть"
                    }
                    else {
                        imageView.visibility = View.INVISIBLE
                        text_number_of_player.text = "Игрок номер: " + i.toString()
                        text_place.text = ""
                        button.text = "Получить место"
                    }
                }
                else if (button.text=="Поехали"){
                    imageView.visibility = View.INVISIBLE
                    val start_timer = Intent(this, Timer::class.java)
                    start_timer.putExtra("time", time)
                    start_timer.putExtra("id",name_of_locations[place_name[place_id]].orEmpty())
                    start_timer.putExtra("array",place_name)
                    startActivity(start_timer)
                }
                else {
                    imageView.visibility = View.INVISIBLE 
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
