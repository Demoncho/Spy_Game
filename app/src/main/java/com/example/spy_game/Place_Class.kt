package com.example.spy_game

class Place_Class(val place: String, val count_of_players: Int){

    private var array_of_places = arrayListOf<String>()

    init{
        array_of_places.add("Шпион")
        for (i in 1..count_of_players-1)
            array_of_places.add(place)
    }

    fun get_place():String{
        if (array_of_places.isEmpty()) return "ERROR"
        val random_number = (0..array_of_places.size-1).shuffled().first()
        val result = array_of_places[random_number]
        array_of_places.removeAt(random_number)
        return result
    }
}
