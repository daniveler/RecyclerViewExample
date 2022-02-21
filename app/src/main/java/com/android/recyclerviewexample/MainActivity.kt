package com.android.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewexample.adapter.SuperHeroAdapter
import com.android.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView()
    {
        val manager = GridLayoutManager(this, 2)
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.recyclerSuperHero.layoutManager = LinearLayoutManager(this)
        binding.recyclerSuperHero.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList) { superhero ->
            onItemSelected(
                superhero
            )
        }

        binding.recyclerSuperHero.addItemDecoration(decoration)
    }

    fun onItemSelected (superHero: SuperHero)
    {
        Toast.makeText(this, superHero.name, Toast.LENGTH_SHORT).show()
    }
}