package com.liucalvin.boggle.entity

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun boardToString(board: Board?): String? {
        return board?.randomizedLetters?.asString()
    }

    @TypeConverter
    fun stringToBoard(string: String?): Array<Array<Char>>? {
        return string?.asBoardArrayOfChars()
    }

    @TypeConverter
    fun timeToDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTime(date: Date?): Long? {
        return date?.time
    }

}