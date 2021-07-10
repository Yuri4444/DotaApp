package com.berezhnoyyuri9999.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.berezhnoyyuri9999.AppApplication
import com.berezhnoyyuri9999.dotaapp.databinding.FragmentMainBinding
import com.berezhnoyyuri9999.ui.main.adapter.HeroesAdapter
import javax.inject.Inject

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding


    lateinit var viewModel : MainFragmentViewModel

    private val adapter by lazy { HeroesAdapter(requireContext()) }


//    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as AppApplication).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)



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