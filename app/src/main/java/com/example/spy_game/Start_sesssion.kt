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

    val name_of_locations_v1_dict = mapOf("Школа" to "https://tvzvezda.ru/storage/news_other_images/2019/09/03/8b837b59c1d6464d891efa5fbeebafc0.jpg",
                                          "Банк" to "https://static3.banki.ru/upload/iblock/7de/akcept_800x549.jpg",
                                          "Университет" to "https://sputniknews.kz/images/523/56/5235642.jpg",
                                          "Больница" to "http://gkbkchr.ru/wp-content/uploads/2016/07/cropped-1-2-1.jpg",
                                          "Пляж" to "https://www.forumdaily.com/wp-content/uploads/2016/06/Depositphotos_28019327_m-2015.jpg",
                                        "База террористов" to "http://www.sana.sy/ru/wp-content/uploads/2015/07/sana.sy11181.jpg",
                                        "Киностудия" to "http://nominus-media.ru/images/uslugi/14424439710486.jpg",
                                        "Партизанский отряд" to "https://www.meme-arsenal.com/memes/d89a138f5e1538a917d6ff1596a1f1b2.jpg",
                                        "Полярная станция" to "https://cs8.pikabu.ru/post_img/big/2018/04/14/12/1523737786120435741.jpg",
                                        "Супермаркет" to "http://rfranch.ru/wp-content/uploads/2018/04/2674012290679897_4a95.jpg",
                                        "Корпоративная вечеринка" to "https://images.aif.ru/010/698/9aacdaa8a2a4f91508f824c1cfbd542b.jpg",
                                        "Пассажирский поезд" to "https://img.tsn.ua/cached/1533897247/tsn-d5a3c83b3e2b3f0a9ff57401c8651a3a/thumbs/1340x530/67/94/f5437ddf924ad8438acbba0d37909467.jpg",
                                        "Посольство" to "https://pics.utro.ru/utro_photos/2018/10/12/1377013.jpg",
                                        "Театр" to "http://www.maly.ru/images/performances/5a43aa03ea87e.jpg",
                                        "Овощебаза" to "https://uralpolit.ru/assets/911113a0/images/oldsite/2014/08/2014-08-21_10-42-12_potorochin_glavnaya.jpg/680.jpg",
                                        "Пиратский корабль" to "https://y-hudozhnik.ru/wa-data/public/shop/products/34/49/4934/images/9480/9480.700.jpg",
                                        "Ресторан" to "https://www.restoran.ru/upload/resize_cache/iblock/a3a/1000_666_1ecda9200b395d49b21a355839cb65e9f/1_etaj_1_2476.jpg",
                                        "Воинская часть" to "https://news.nashbryansk.ru/v2/uploads/news/images/2018/October/3272.jpg",
                                        "Океанский лайнер" to "http://korabley.net/_nw/1/46479.jpg",
                                        "Самолет" to "https://ichef.bbci.co.uk/news/660/cpsprodpb/10608/production/_106808076_tass_33120300.jpg",
                                        "Церковь" to "https://sib-catholic.ru/wp-content/uploads/2017/05/2017-05-18_14-53-24.png",
                                        "Войско крестоносцев" to "http://page.maple4.ru/assets/site/images/krestovpohod.jpg",
                                        "Орбитальная станция" to "https://img.rg.ru/img/content/150/08/83/2_d_850.jpg",
                                        "Подводная лодка" to "https://cdn1.img.inosmi.ru/images/23942/93/239429322.jpg",
                                        "Спа-салон" to "https://laudator.ru/wp-content/uploads/2012/01/spa-salon-1024x681.jpg",
                                        "Цирк-шапито" to "https://www.marimedia.ru/media/poster/d/8/Cirkshapito_Alle_34904128cc4dcdeae249e412dd62ad67576f053a.jpg",
                                        "Казино" to "https://varlamov.me/2017/casinomax/01.jpg",
                                        "Отель" to "https://www.rostovhotel.ru/upload/slider_bg/2016-1920.jpg",
                                        "Полицейский участок" to "https://st2.depositphotos.com/1037718/11535/i/950/depositphotos_115353400-stock-photo-police-station-in-georgia.jpg",
                                        "Станция техобслуживания" to "http://krownmotors.ru/wp-content/uploads/2018/05/avtoservis11-1500x630.jpg")

    val name_of_locations_v2_dict = mapOf("Стройплощадка" to "https://static3.depositphotos.com/1007344/230/i/950/depositphotos_2303226-stock-photo-building-site.jpg",
                                        "Стадион" to "https://nevasport.ru/wp-content/uploads/2018/08/krasnodar-3-1024x682.jpg",
                                        "Экскурсионный автобус" to "https://autoreview.ru/images/Article/1600/Article_160036_860_575.jpg",
                                        "Свадьба" to "https://i.ytimg.com/vi/zzuI1sona1M/maxresdefault.jpg",
                                        "Метро" to "https://www.iguides.ru/upload/medialibrary/b08/b080f27aa54bf764b678e762876353d9.jpg",
                                        "Музей" to "http://kazan-kremlin.ru/wp-content/uploads/2017/04/muzej-estestvennoj-itsorii.jpg",
                                        "Рок-концерт" to "https://www.soyuz.ru/public/uploads/files/5/7165204/1005x558_20171222160607b782ecf33c.jpg",
                                        "Заправочная станция" to "https://i.ytimg.com/vi/pss_GAavfFY/maxresdefault.jpg",
                                        "Парламент" to "http://scd.ru.rfi.fr/sites/russian.filesrfi/imagecache/rfi_16x9_1024_578/sites/images.rfi.fr/files/aef_image/hemicycle-plein-vue-panoramique.jpg",
                                        "Дом престрарелых" to "http://www.exo-ykt.ru/upload/iblock/372/372e7a1ba16ba6cc6976b8034f162342.jpg",
                                        "Шахта" to "https://cs11.pikabu.ru/post_img/2018/05/21/3/1526869658178069320.jpg",
                                        "Библиотека" to "https://need4trips.com/wordpress/wp-content/uploads/2017/11/Irlandiya-Dublin-Staraya-biblioteka-Triniti-kolledzh.jpg",
                                        "Шоколадная фабрика" to "https://zolotoy.ru/wp-content/uploads/2018/11/ууаа-min.jpg",
                                        "Джаз-бенд" to "https://grow.org.ua/wp-content/uploads/2016/03/5.jpg",
                                        "Порт" to "http://eurasia.expert/upload/iblock/878/878dbbb32a40464f447509434148b9b6.jpg",
                                        "Тюрьма" to "http://www.sobaka.ru/images/image/01/01/09/16/_normal.jpg",
                                        "Кладбище" to "https://s0.rbk.ru/v6_top_pics/media/img/2/60/755446791792602.jpg",
                                        "Виноградник" to "https://ee24.ru/media/cache/c8/9b/c89b64729f40c01aa77687738cefa3f3.jpg",
                                        "Автогонки" to "http://www.1gai.ru/uploads/posts/2017-03/1489848927_7.jpg",
                                        "Выставка кошек" to "https://gorod342.ru/images/photos/medium/article12394.jpg")

    val name_of_locations_time_machine_dict = mapOf("Бородинская битва" to "https://www.pravmir.ru/wp-content/uploads/2015/09/051-1050x504.jpg",
                                                    "Испанская инквизиция" to "https://cdn-s-static.arzamas.academy/storage/material/263/share_share_picture-dbc42aa0-eaa8-4862-837f-def9f054ec21.jpg",
                                                    "Лунная станция" to "https://efemer.org/wp-content/uploads/2018/09/Лунная-станция.jpg",
                                                    "Подпольный бар" to "http://gotonight.ru/ih800/catalog/places2/1839_mitzvabar2.jpg",
                                                    "Троянская война" to "https://greecemagazine.ru/wp-content/uploads/2018/01/Trojan-Horse-750x460.jpg",
                                                    "Вигвам" to "https://cs10.pikabu.ru/post_img/big/2018/02/20/9/1519137351160580166.jpg",
                                                    "Караван" to "http://timeismoney.kg/wp-content/uploads/2018/05/tmb_119640_4046.jpg",
                                                    "Мастерская Леонардо" to "https://pbs.twimg.com/media/DAHoBPqWAAAgX_r.jpg",
                                                    "Рота мушкетеров" to "https://cs9.pikabu.ru/post_img/big/2017/08/26/11/1503773870173214353.jpg",
                                                    "Турецкий гарем" to "https://wonderfulturkey.files.wordpress.com/2017/02/osmanlida-harem-hakkinda-bc4b0lc4b0nmeyenler-30-c4b0lgc4b0nc387-malumat-30-gc396rsel-tablo-c396nemli-bilgi-resim-tablosu-ile-osmanlc4b1-sarayc4b1-haremi-nedir.jpg",
                                                    "Воздушный шар" to "https://cdn.bitrix24.ru/b8072719/landing/c39/c397f4beecd6cfa782a1bf77a0bcd083/vozdushnyy_shar_mechta.jpg",
                                                    "Круг друидов" to "http://www.bayanay.info/uploads/posts/1392439570_255c5bda6ecc11ad3fc073ee0737.jpeg",
                                                    "Монастырь Шаолинь" to "http://buddistt.ru/wp-content/uploads/2018/09/Istoriya_monastyrya_shaolin_-_odin_den_iz_zhizni_monahov_1.jpg",
                                                    "Рыцарский турнир" to "http://hellotraveler.ru/wp-content/uploads/2017/07/Kaltenberger-Rittertunier-23.jpg",
                                                    "Фестиваль хиппи" to "http://fanday.ru/wp-content/uploads/2011/06/Image000110.jpg",
                                                    "Дирижабль первой мировой" to "https://img.rg.ru/img/content/160/92/68/dirizhabl1_d_850.jpg",
                                                    "Лагерь золотоискателей" to "http://cult-and-art.net/uploads/posts_meta/albums/32543_album-f3dn8zttketfhbdgyhrz.jpg",
                                                    "Отряд Робин Гуда" to "http://altritter.ru/UserFiles/Image/Statii/RobinGud/komanda1.jpg",
                                                    "Салун" to "https://not-lonely.com/upload/iblock/4c7/4c70c62812b7952b1f842f1dd3b798d2.jpg",
                                                    "Французская революция" to "https://mirfrance.ru/wp-content/uploads/2017/10/French-Revolution.jpg",
                                                    "Древняя олимпиада" to "https://cdn.fishki.net/upload/post/2017/10/03/2395826/interesnye-fakty-o-drevney-grecii-12.jpg",
                                                    "Лагерь повстанцев" to "https://im3.turbina.ru/photos.4/7/4/2/1/8/2781247/big.photo/Lager-povstantsev.jpg",
                                                    "Пещера неандертальцев" to "https://hotgeo.ru/uploads/posts/2019-04/1554188939_1j.jpg",
                                                    "Танковый бой" to "http://www.vokrugsveta.ru/img/cmn/2006/08/09/013.jpg",
                                                    "Школа ниндзя" to "https://fujitravel.ru/pictures/143/pic1_26032014013835.jpg",
                                                    "Древнеримский сенат" to "https://upload.wikimedia.org/wikipedia/commons/a/a3/Maccari-Cicero.jpg",
                                                    "Ладья викингов" to "https://static.life.ru/posts/2017/09/1046474/gr/north/360369368cb990dfa583329804393cea__1440x.jpg",
                                                    "Племя людоедов" to "https://static.inforeactor.ru/uploads/2016/02/28/orig-001-1456659580.jpg",
                                                    "Строительство пирамид" to "http://egyptopedia.info/images/stories/Original/architect/tech_pyramid_30.jpg",
                                                    "Эпидемия черной смерти" to "https://knife.media/wp-content/uploads/2018/11/CHuma-1-1024x717.jpg")


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
                    start_timer.putExtra("id",place_name[place_id])
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
