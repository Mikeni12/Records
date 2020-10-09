package com.mikeni.records.utils

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromListOfDoubles(list: List<Double>?): String {
        return list?.joinToString(separator = ";") { it.toString() } ?: ""
    }

    @TypeConverter
    fun toListOfDoubles(string: String?): List<Double> {
        return ArrayList(string?.split(";")?.mapNotNull { it.toDoubleOrNull() } ?: emptyList())
    }
}