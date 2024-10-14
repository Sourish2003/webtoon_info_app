package com.example.webtoon_info_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webtoon_info_app.R
import com.example.webtoon_info_app.data.WebtoonDatabase

class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val webtoonDao = WebtoonDatabase.getInstance(this).webtoonDao()
        viewModelScope.launch {
            val favorites = webtoonDao.getAllFavorites()
            // Update UI with favorites list
        }
    }
}