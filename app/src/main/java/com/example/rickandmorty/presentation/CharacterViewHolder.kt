package com.example.rickandmorty.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandmorty.R

class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val image = itemView.findViewById<ImageView>(R.id.item_character_img)
    val name = itemView.findViewById<TextView>(R.id.item_name)
    val status = itemView.findViewById<TextView>(R.id.item_status)
}