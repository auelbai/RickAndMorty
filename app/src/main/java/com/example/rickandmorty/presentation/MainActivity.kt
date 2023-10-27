package com.example.rickandmorty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharacterDatabase
import com.example.rickandmorty.presentation.viewModels.CharactersViewModel
import com.example.rickandmorty.presentation.viewModels.CharactersViewModelProvider
import com.example.rickandmorty.repository.CharactersRepository
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: CharactersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBottomNavigation()
        setUpViewModel()

    }

    private fun setUpViewModel() {
        val repository = CharactersRepository(CharacterDatabase(this))
        val viewModelProviderFactory = CharactersViewModelProvider(repository)
        viewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        )[CharactersViewModel::class.java]
    }

    private fun setUpBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.characters_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
            .setupWithNavController(navController)
    }
}