package com.example.rickandmorty.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.models.Character

class CharactersAdapter: ListAdapter<Character, CharacterViewHolder>(DiffUtilCallback()) {

    var setOnItemClickListener: ((Character) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_character_preview,
            parent
            ,false
        )
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = currentList[position]

        Glide.with(holder.itemView).load(item.image).into(holder.image)
        holder.name.text = item.name
        holder.status.text = item.status
        holder.itemView.setOnClickListener {
            setOnItemClickListener?.invoke(item)
        }
    }
}