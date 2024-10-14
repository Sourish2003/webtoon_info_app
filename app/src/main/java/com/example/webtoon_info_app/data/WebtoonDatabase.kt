package com.example.webtoon_info_app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteWebtoon::class], version = 1)
abstract class WebtoonDatabase : RoomDatabase() {

    abstract fun webtoonDao(): WebtoonDao

    companion object {
        private const val DATABASE_NAME = "webtoon_info_database"

        @Volatile
        private var INSTANCE: WebtoonDatabase? = null

        fun getInstance(context: Context): WebtoonDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, // Pass the application context here
                        WebtoonDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}