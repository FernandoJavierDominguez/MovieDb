package com.fernandodominguezpacheco.moviedb.ui.movie

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.fernandodominguezpacheco.moviedb.R
import com.fernandodominguezpacheco.moviedb.databinding.FragmentMovieBinding
import com.fernandodominguezpacheco.moviedb.ui.movie.MovieAdapter
import com.fernandodominguezpacheco.moviedb.ui.movie.MovieViewModel
import com.fernandodominguezpacheco.moviedb.utils.SharedViewModel
import com.fernandodominguezpacheco.moviedb.utils.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    private val movieViewModel: MovieViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    val adapter = MovieAdapter{
        sharedViewModel.selectMovie(it)
        requireView().findNavController().navigate(R.id.action_movieFragment_to_detailFragment)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieBinding.bind(view)
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(context, 2)
        observer(movieViewModel.movieItems){
            adapter.items = it
        }
        setHasOptionsMenu(true)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            //R.id.action_settings -> true
            R.id.search -> {
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        movieViewModel.text.value = newText!!.toLowerCase()
                        return false
                    }
                })
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}