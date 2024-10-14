package com.example.webtoon_info_app.utils

object RatingUtil {

    fun calculateAverageRating(ratings: List<Float>): Float {
        if (ratings.isEmpty()) return 0.0f
        return ratings.sum() / ratings.size
    }
}