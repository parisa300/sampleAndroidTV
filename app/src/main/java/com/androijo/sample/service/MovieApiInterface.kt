package com.androijo.sample.service

import com.androijo.sample.model.MovieResponse
import retrofit2.http.GET
import retrofit2.Call
interface MovieApiInterface {

    @GET("3/movie/550?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getMovieList(): Call<MovieResponse>
}