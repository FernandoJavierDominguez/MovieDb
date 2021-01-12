package com.fernandodominguezpacheco.moviedb.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fernandodominguezpacheco.moviedb.R
import com.fernandodominguezpacheco.moviedb.databinding.RowActorBinding
import com.fernandodominguezpacheco.moviedb.domain.Actor
import kotlin.properties.Delegates

class ActorAdapter(
    private val listener: (Actor) -> Unit
) : RecyclerView.Adapter<ActorAdapter.ViewHolder>() {


    var items: List<Actor> by Delegates.observable(mutableListOf()) { _, _, _ -> notifyDataSetChanged()}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_actor, parent, false)
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

        private val binding = RowActorBinding.bind(view)

        fun bind(actorItem: Actor){

            with(binding){
                //urlImage.loadUrl("${Constants.BASE_IMAGE_URL}${movieItem.urlImage}")
                name.text = actorItem.name
                popularity.text = actorItem.popularity.toString()
            }

        }

    }
}

