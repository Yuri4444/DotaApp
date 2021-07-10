package com.berezhnoyyuri9999.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.data.HeroesList
import com.berezhnoyyuri9999.dotaapp.databinding.ItemHeroesBinding
import com.bumptech.glide.Glide
import java.util.ArrayList

class HeroesAdapter(private val context: Context) : RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

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

    inner class ViewHolder(private val binding: ItemHeroesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val BASE_URL = "https://api.opendota.com/api/"

        fun bind(heroesList: HeroesList) {
            Glide.with(context).load("https://cdn.cloudflare.steamstatic.com${heroesList.image}").into(binding.ivIconHeroes)

            binding.tvIdHeroes.text = heroesList.id.toString()
            binding.tvNameHeroes.text = heroesList.name
        }
    }
}