package com.aatmannbc.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"
class DetailActivity() : AppCompatActivity() {

    private lateinit var tv_Title :TextView
    private lateinit var tv_Overview : TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var tv_airDate : TextView
    private lateinit var iv_Poster : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tv_Title =findViewById(R.id.tv_Title)
        tv_Overview=findViewById(R.id.tv_Overview)
        ratingBar=findViewById(R.id.Rating)
        tv_airDate=findViewById(R.id.tv_airDate)
        iv_Poster=findViewById(R.id.iv_Poster)


        val movie = intent.getParcelableExtra<Movie>(MOVIE_EXTRA) as Movie
        Log.i(TAG, "Movie is $movie")
        tv_Title.text = movie.name
        tv_Overview.text = movie.overview
        tv_airDate.text = movie.airDate
        Glide.with(this).load(movie.posterImageUrl).into(iv_Poster)
        ratingBar.rating = movie.voteAvergae.toFloat()



    }
}
