package com.example.rickandmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.rickandmorty.R
import com.example.rickandmorty.presentation.MainActivity
import com.example.rickandmorty.presentation.viewModels.CharactersViewModel

class AllCharactersFragment: Fragment(R.layout.fragment_all_characters) {

    lateinit var viewModel: CharactersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}