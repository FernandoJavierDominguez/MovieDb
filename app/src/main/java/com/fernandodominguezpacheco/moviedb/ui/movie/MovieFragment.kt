package com.fernandodominguezpacheco.moviedb.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private val adapter = MovieAdapter{
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
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(context, 2)
        observer(movieViewModel.movieItems){
            adapter.items = it
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}