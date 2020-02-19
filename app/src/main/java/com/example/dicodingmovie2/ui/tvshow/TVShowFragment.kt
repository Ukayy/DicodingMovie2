package com.example.dicodingmovie2.ui.tvshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingmovie2.R
import com.example.dicodingmovie2.model.Movie
import com.example.dicodingmovie2.model.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class TVShowFragment : Fragment() {

    private val list = ArrayList<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        list.addAll(getListTVShow())
        showRecyclerCardView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun showRecyclerCardView() {
        rv_movies.setHasFixedSize(true)
        rv_movies.layoutManager = LinearLayoutManager(activity)
        val cardViewMovieAdapter = MovieAdapter(list)
        rv_movies.adapter = cardViewMovieAdapter
    }

    private fun getListTVShow(): ArrayList<Movie> {
        val dataName = resources.getStringArray(R.array.tvshow_titles)
        val dataDescription = resources.getStringArray(R.array.tvshow_descriptions)
        val dataPhoto = resources.obtainTypedArray(R.array.tvshow_posters)
        val dataRelease = resources.getStringArray(R.array.tvshow_releasedates)
        val dataDuration = resources.getStringArray(R.array.tvshow_durationtimes)
        val dataDistributedby = resources.getStringArray(R.array.tvshow_distributedby)




        val listTVShow = ArrayList<Movie>()
        for (position in dataName.indices){
            val tvshow = Movie(
                dataName[position],
                dataDescription[position],
                dataPhoto.getResourceId(position, -1),
                dataRelease[position],
                dataDuration[position],
                dataDistributedby[position]
            )
            listTVShow.add(tvshow)
        }
        return listTVShow
    }
}
