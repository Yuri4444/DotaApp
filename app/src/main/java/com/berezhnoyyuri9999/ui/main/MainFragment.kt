package com.berezhnoyyuri9999.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.berezhnoyyuri9999.data.HeroesList
import com.berezhnoyyuri9999.dotaapp.databinding.FragmentMainBinding
import com.berezhnoyyuri9999.ui.main.adapter.HeroesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    private val viewModel : MainFragmentViewModel by viewModel()
    private val adapter by lazy { HeroesAdapter(requireContext()) }


    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)

//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainFragmentViewModel::class.java)



        binding?.rvHeroes?.adapter = adapter
        viewModel.heroesList.observe(viewLifecycleOwner, {
            adapter.setData(it)
            Log.e("R", it.toString())
        })

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetch()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}