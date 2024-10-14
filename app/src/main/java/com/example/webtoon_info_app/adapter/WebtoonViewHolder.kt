package com.example.webtoon_info_app.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webtoon_info_app.R
import com.example.webtoon_info_app.data.Webtoon

class WebtoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.textView)
    private val imageView: ImageView = itemView.findViewById(R.id.imageView)
    private val descriptionTextView: TextView = itemView.findViewById(R.id.text_view_description)

    fun bind(webtoon: Webtoon) {
        titleTextView.text = webtoon.title
        Glide.with(itemView.context)
            .load(webtoon.imageUrl)
            .into(imageView)
        descriptionTextView.text = webtoon.description
    }
}