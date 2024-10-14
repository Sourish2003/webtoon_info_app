package com.example.webtoon_info_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.webtoon_info_app.R
import com.example.webtoon_info_app.data.Webtoon
import com.example.webtoon_info_app.data.WebtoonDatabase

class WebtoonAdapter(
    private val context: Context,
    private val webtoons: List<Webtoon>,
    private val webtoonDatabase: WebtoonDatabase,  // Inject WebtoonDatabase
    private val onFavoriteClickListener: (webtoon: Webtoon) -> Unit
) : RecyclerView.Adapter<WebtoonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.content_main, parent, false)
        return WebtoonViewHolder(view)
    }

    override fun onBindViewHolder(holder: WebtoonViewHolder, position: Int) {
        val webtoon = webtoons[position]
        holder.bind(webtoon)
        holder.itemView.setOnClickListener {
            onFavoriteClickListener(webtoon)
        }
    }

    override fun getItemCount(): Int = webtoons.size
}