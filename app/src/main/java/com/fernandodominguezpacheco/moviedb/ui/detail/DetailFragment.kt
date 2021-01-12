package com.fernandodominguezpacheco.moviedb.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.fernandodominguezpacheco.moviedb.R
import com.fernandodominguezpacheco.moviedb.databinding.FragmentDetailBinding
import com.fernandodominguezpacheco.moviedb.utils.Constants
import com.fernandodominguezpacheco.moviedb.utils.SharedViewModel
import com.fernandodominguezpacheco.moviedb.utils.loadUrl
import com.fernandodominguezpacheco.moviedb.utils.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val detailViewModel: DetailViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val actorAdapter = ActorAdapter{
        sharedViewModel.selectActor(it)
        requireView().findNavController().navigate(R.id.action_detailFragment_to_actorFragment)
    }
    private val genreAdapter = GenreAdapter{

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.actors.adapter = actorAdapter
        binding.genres.adapter = genreAdapter

        observer(sharedViewModel.getSelectedMovie()){
            with(binding){
                urlImage.loadUrl("${Constants.BASE_IMAGE_URL}${it.urlImage}")
                title.text = it.title
                overview.text = it.overview
                actorAdapter.items = it.actors
                genreAdapter.items = it.genres
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}