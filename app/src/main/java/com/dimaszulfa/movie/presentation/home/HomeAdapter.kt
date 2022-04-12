package com.dimaszulfa.movie.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dimaszulfa.movie.R
import com.dimaszulfa.movie.domain.Movie

class HomeAdapter(private var context: Context?= null) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val list = ArrayList<Movie>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.txTitle)
        val img = itemView.findViewById<ImageView>(R.id.ivPoster)
        val rating = itemView.findViewById<TextView>(R.id.txRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = list[position]
        with(holder) {
            title.text = list.original_title
            rating.text = list.vote_average.toString()
            Glide.with(context!!)
                .load("https://image.tmdb.org/t/p/w500/" + list.poster_path).into(img)
        }

    }

    override fun getItemCount(): Int = list.size

    fun addData(data: List<Movie>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}