package com.androijo.sample.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androijo.sample.R
import com.androijo.sample.model.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_subject.view.*

class MovieAdapter(
    private val movies : List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie : Movie){
            itemView.cardName.text = movie.title

            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_subject, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }
}