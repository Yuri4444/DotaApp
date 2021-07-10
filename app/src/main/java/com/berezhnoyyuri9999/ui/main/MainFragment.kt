package com.berezhnoyyuri9999.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.berezhnoyyuri9999.dotaapp.databinding.FragmentMainBinding
import com.berezhnoyyuri9999.ui.main.adapter.HeroesAdapter
import com.berezhnoyyuri9999.utils.appComponent
import javax.inject.Inject

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: MainFragmentViewModel

    private val adapter by lazy { HeroesAdapter(requireContext()) }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this@MainFragment, viewModelFactory).get(MainFragmentViewModel::class.java)

        binding?.rvHeroes?.adapter = adapter
        viewModel.heroesList.observe(viewLifecycleOwner, {
            adapter.setData(it)
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