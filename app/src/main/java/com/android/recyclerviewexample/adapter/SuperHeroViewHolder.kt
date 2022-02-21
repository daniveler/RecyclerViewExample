package com.android.recyclerviewexample.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewexample.R
import com.android.recyclerviewexample.SuperHero
import com.android.recyclerviewexample.databinding.ItemSuperheroBinding
import com.bumptech.glide.Glide

class SuperHeroViewHolder(val view: View) : RecyclerView.ViewHolder(view)
{
    val binding = ItemSuperheroBinding.bind(view)

    fun render(superHero: SuperHero, onClickListener: (SuperHero) -> Unit)
    {
        binding.textViewSuperHeroName.text = superHero.name
        binding.textViewSuperHeroRealName.text = superHero.realName
        binding.textViewSuperHeroPublisher.text = superHero.publisher
        Glide.with(binding.imageViewSuperHero.context).load(superHero.photo)
            .into(binding.imageViewSuperHero)

        itemView.setOnClickListener { onClickListener(superHero) }
    }
}