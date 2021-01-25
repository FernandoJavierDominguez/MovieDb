package com.fernandodominguezpacheco.moviedb.ui.actor

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.fernandodominguezpacheco.moviedb.MovieApp
import com.fernandodominguezpacheco.moviedb.databinding.FragmentActorBinding
import com.fernandodominguezpacheco.moviedb.utils.Constants
import com.fernandodominguezpacheco.moviedb.utils.SharedViewModel
import com.fernandodominguezpacheco.moviedb.utils.loadUrl
import com.fernandodominguezpacheco.moviedb.utils.observer


class ActorFragment : Fragment() {

    private var _binding: FragmentActorBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer(sharedViewModel.getSelectedActor()){
            with(binding){
                name.text = it.name
                popularity.text = it.popularity.toString()
                urlImage.loadUrl("${Constants.BASE_IMAGE_URL}${it.urlImage}")
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        (context.applicationContext as MovieApp).getComponent().inject(this)
        super.onAttach(context)
    }


}