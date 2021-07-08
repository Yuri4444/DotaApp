package com.berezhnoyyuri9999.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.data.HeroesList
import com.berezhnoyyuri9999.dotaapp.databinding.ItemHeroesBinding
import java.util.ArrayList

class HeroesAdapter : RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

    private val list: MutableList<HeroesList> = ArrayList()

    fun setData(newList: List<HeroesList>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHeroesBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    override fun getItemCount() = list.count()

    class ViewHolder(private val binding: ItemHeroesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(heroesList: HeroesList) {
            binding.tvIdHeroes.text = heroesList.id.toString()
            binding.tvNameHeroes.text = heroesList.name
        }
    }
}