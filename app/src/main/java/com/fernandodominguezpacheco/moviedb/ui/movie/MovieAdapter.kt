package com.fernandodominguezpacheco.moviedb.ui.movie

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fernandodominguezpacheco.moviedb.R
import com.fernandodominguezpacheco.moviedb.databinding.RowMovieBinding
import com.fernandodominguezpacheco.moviedb.domain.Movie

import com.fernandodominguezpacheco.moviedb.utils.Constants.BASE_IMAGE_URL
import com.fernandodominguezpacheco.moviedb.utils.loadUrl
import kotlin.properties.Delegates


class MovieAdapter(
    private val listener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var items: List<Movie> by Delegates.observable(mutableListOf()) {_,_,_ -> notifyDataSetChanged()}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            listener(item)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = RowMovieBinding.bind(view)

        fun bind(movieItem: Movie){

            with(binding){
                urlImage.loadUrl("${BASE_IMAGE_URL}${movieItem.urlImage}")
                title.text = movieItem.title
                popularity.text = movieItem.popularity.toString()
            }

        }


    }
}