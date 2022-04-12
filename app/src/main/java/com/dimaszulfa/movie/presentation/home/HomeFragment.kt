package com.dimaszulfa.movie.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimaszulfa.movie.R
import com.dimaszulfa.movie.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HomeAdapter(context)
        binding.rvMovies.adapter = adapter
        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        vm.getMovieData()

        vm.movies.observe(viewLifecycleOwner){
            adapter.addData(it)
            adapter.notifyDataSetChanged()

        }
    }

    private lateinit var binding: FragmentHomeBinding
    private val vm: HomeViewModel by viewModel()
    private lateinit var adapter: HomeAdapter
}