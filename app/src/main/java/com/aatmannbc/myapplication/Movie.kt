package com.aatmannbc.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.IgnoredOnParcel
import org.json.JSONArray

@Parcelize
data class Movie (
    val movieId: Int,
    val voteAvergae : Double,
    val airDate : String,
    private val posterPath: String,
    val name: String,
    val overview: String,
): Parcelable{
    @IgnoredOnParcel
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object{
        fun fromJasonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()){
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getDouble("vote_average"),
                        movieJson.getString("first_air_date"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("name"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}