package com.example.exampleretrofit2.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exampleretrofit2.databinding.ItemDogAdapterBinding


class DogAdapter(private val dogList: List<String>): RecyclerView.Adapter<DogAdapter.DogViewHolder>() {


    // Maneja cada una de las celdas del recyclerview
    inner class DogViewHolder(val binding: ItemDogAdapterBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(dog: String) {
            Glide.with(itemView.context).load(dog).into(binding.ivImageDog)
        }
    }

    // Infla la vista del view holder, el binding (xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = ItemDogAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(binding = binding)
    }

    // Retorna el tamaño del recyclerview
    override fun getItemCount(): Int {
        return dogList.size
    }

    // Toma el valor del cada una de las posiciones, cuando hagan click sabran en que position la hicierion
    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dog = dogList[position]
        holder.bind(dog)
    }


}