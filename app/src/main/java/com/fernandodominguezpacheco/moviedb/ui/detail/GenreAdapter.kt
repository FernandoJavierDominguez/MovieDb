package com.fernandodominguezpacheco.moviedb.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fernandodominguezpacheco.moviedb.R
import com.fernandodominguezpacheco.moviedb.databinding.RowGenreBinding
import com.fernandodominguezpacheco.moviedb.databinding.RowMovieBinding
import com.fernandodominguezpacheco.moviedb.domain.Actor
import com.fernandodominguezpacheco.moviedb.domain.Genre
import com.fernandodominguezpacheco.moviedb.domain.Movie
import com.fernandodominguezpacheco.moviedb.ui.movie.MovieAdapter
import com.fernandodominguezpacheco.moviedb.utils.Constants
import com.fernandodominguezpacheco.moviedb.utils.loadUrl
import kotlin.properties.Delegates

class GenreAdapter(
    private val listener: (Genre) -> Unit
) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    var items: List<Genre> by Delegates.observable(mutableListOf()) { _, _, _ -> notifyDataSetChanged()}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_genre, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = RowGenreBinding.bind(view)

        fun bind(genreItem: Genre){

            with(binding){
                name.text = genreItem.name
            }

        }


    }
}

