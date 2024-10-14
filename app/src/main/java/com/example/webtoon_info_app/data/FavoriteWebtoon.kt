package com.example.webtoon_info_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_webtoons")
data class FavoriteWebtoon(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val webtoon: Webtoon
)