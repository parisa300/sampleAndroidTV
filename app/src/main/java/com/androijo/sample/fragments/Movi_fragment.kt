package com.androijo.sample.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.androijo.sample.R
import com.androijo.sample.adapter.MovieAdapter
import com.androijo.sample.model.Movie
import com.androijo.sample.model.MovieResponse
import com.androijo.sample.service.MovieApiInterface
import com.androijo.sample.service.MovieApiService
import kotlinx.android.synthetic.main.fragment_movie.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
class Movi_fragment : Fragment(R.layout.fragment_movie) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        rv_movies_list.layoutManager = LinearLayoutManager(this.context)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }


}