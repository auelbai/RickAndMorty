package com.example.rickandmorty.data

import androidx.room.TypeConverter
import com.example.rickandmorty.models.Location
import com.example.rickandmorty.models.Origin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    @TypeConverter
    fun fromOrigin(origin: Origin): String {
        return origin.name
    }

    @TypeConverter
    fun toOrigin(name: String): Origin {
        return Origin(name, name)
    }

    @TypeConverter
    fun fromLocation(location: Location): String {
        return location.name
    }

    @TypeConverter
    fun toLocation(name: String): Location {
        return Location(name, name)
    }

    @TypeConverter
    fun fromEpisodes(value: List<String>): String {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toEpisodes(value: String): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }
}