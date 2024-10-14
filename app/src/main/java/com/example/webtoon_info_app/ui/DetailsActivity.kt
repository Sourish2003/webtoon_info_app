package com.example.webtoon_info_app.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.example.webtoon_info_app.R
import com.example.webtoon_info_app.data.FavoriteWebtoon
import com.example.webtoon_info_app.data.Webtoon
import com.example.webtoon_info_app.data.WebtoonDao
import com.example.webtoon_info_app.data.WebtoonDatabase
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity() {

    private lateinit var webtoon: Webtoon
    private lateinit var webtoonDao: WebtoonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webtoon = intent.getSerializableExtra("webtoon") as Webtoon  // Using Serializable
        webtoonDao = WebtoonDatabase.getInstance(this).webtoonDao()

        // Set details on UI elements
        findViewById<TextView>(R.id.textView).text = webtoon.title
        // ... set other details for image, description etc.

        val favoriteButton = findViewById<Button>(R.id.button_favorite)
        favoriteButton.setOnClickListener {
            toggleFavorite(favoriteButton)
        }
    }

    private fun toggleFavorite(favoriteButton: Button) {
        val favoriteWebtoon = FavoriteWebtoon(0, webtoon)
        viewModelScope.launch {
            if (isFavorite()) {
                // Remove from favorites
                webtoonDao.deleteFavorite(favoriteWebtoon)
                favoriteButton.text = "Add to Favorites"
            } else {
                // Add to favorites
                webtoonDao.insertFavorite(favoriteWebtoon)
                favoriteButton.text = "Remove from Favorites"
            }
        }
    }

    private suspend fun isFavorite(): Boolean {
        val favorites = webtoonDao.getAllFavorites()
        return favorites.any { it.webtoon.title == webtoon.title }
    }
}