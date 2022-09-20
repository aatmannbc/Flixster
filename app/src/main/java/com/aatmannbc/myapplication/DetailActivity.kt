package com.aatmannbc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import android.widget.TextView

private const val TAG = "DetailActivity"
class DetailActivity : AppCompatActivity() {

    private lateinit var tv_Title :TextView
    private lateinit var tv_Overview : TextView
    private lateinit var ratingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tv_Title =findViewById(R.id.tv_Title)
        tv_Overview=findViewById(R.id.tv_Overview)
        ratingBar=findViewById(R.id.Rating)

        val movie = intent.getParcelableExtra<Movie>(MOVIE_EXTRA) as Movie
        Log.i(TAG, "Movie is $movie")
        tv_Title.text = movie.name
        tv_Overview.text = movie.overview

    }
}