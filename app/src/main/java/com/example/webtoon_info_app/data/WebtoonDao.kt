package com.example.webtoon_info_app.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WebtoonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favoriteWebtoon: FavoriteWebtoon)

    @Delete
    suspend fun deleteFavorite(favoriteWebtoon: FavoriteWebtoon)

    @Query("SELECT * FROM favorite_webtoons")
    suspend fun getAllFavorites(): List<FavoriteWebtoon>
}