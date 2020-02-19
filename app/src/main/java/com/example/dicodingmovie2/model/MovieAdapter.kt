package com.example.dicodingmovie2.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicodingmovie2.DetailActivity
import com.example.dicodingmovie2.R
import kotlinx.android.synthetic.main.item_row_movie.view.*

class MovieAdapter(
    private val listHero : ArrayList<Movie>
) :RecyclerView.Adapter<MovieAdapter.CardViewViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_movie, viewGroup, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            with(itemView) {
               /* Glide.with(itemView.context)
                    .load(movie.poster)
                    .apply(RequestOptions().override(350, 550))
                    .into(itemView.iv_poster) */
                itemView.iv_poster.setImageResource(movie.poster)
                tv_title.text = movie.title
                tv_duration.text = movie.durationTime

                itemView.card_view.setOnClickListener {
                    var movies = arrayListOf<Movie>()
                    val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
                    moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
                    context.startActivity(moveWithObjectIntent)

                }
            }
        }
    }}
