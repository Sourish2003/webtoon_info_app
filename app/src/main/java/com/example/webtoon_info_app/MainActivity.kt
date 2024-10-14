package com.example.webtoon_info_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webtoon_info_app.adapter.WebtoonAdapter
import com.example.webtoon_info_app.data.Webtoon
import com.example.webtoon_info_app.data.WebtoonDatabase
import com.example.webtoon_info_app.ui.DetailsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webtoonDatabase: WebtoonDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Replace with your actual data source
        val webtoons = listOf(
            Webtoon(
                title = "Webtoon Title 1",
                imageUrl = "https://example.com/image1.jpg",
                description = "Short description for Webtoon 1"
            ),
            // Add more webtoons here
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_transform)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize WebtoonDatabase instance with application context
        webtoonDatabase = WebtoonDatabase.getInstance(applicationContext)

        val adapter = WebtoonAdapter(this, webtoons, webtoonDatabase) { webtoon ->
            // Handle favorite click, e.g., navigate to DetailsActivity
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("webtoon", webtoon)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}