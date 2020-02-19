package com.example.dicodingmovie2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dicodingmovie2.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.layout_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_person"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie

        tv_title.text = movie.title
        tv_description.text = movie.description
        tv_distributedby.text = movie.distributedBy
        tv_durationtime.text = movie.durationTime
        tv_releasedate.text = movie.releaseDate
        iv_poster.setImageResource(movie.poster)

    }
}