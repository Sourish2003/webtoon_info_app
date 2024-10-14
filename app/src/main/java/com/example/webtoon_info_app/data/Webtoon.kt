package com.example.webtoon_info_app.data
import java.io.Serializable

data class Webtoon(
    val title: String,
    val imageUrl: String,
    val description: String,
    val rating: Float = 0.0f // Initialize with default rating
) : Serializable