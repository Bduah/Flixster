package com.example.flixster

import org.json.JSONArray

data class Movie (
    val movieId: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
    private val backdropPath: String,
){
    val backdropPathUrl = "https://image.tmdb.org/t/p/w780/$backdropPath"
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object{
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 8 until movieJsonArray.length()){
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview"),
                        movieJson.getString("backdrop_path")
                    )
                )
            }
            return movies
        }
    }

}