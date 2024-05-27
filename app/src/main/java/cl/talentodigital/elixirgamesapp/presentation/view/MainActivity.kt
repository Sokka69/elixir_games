package cl.talentodigital.elixirgamesapp.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.talentodigital.elixirgamesapp.R
import cl.talentodigital.elixirgamesapp.data.network.api.VideoGameService
import cl.talentodigital.elixirgamesapp.data.network.retrofit.RetrofitHelper
import cl.talentodigital.elixirgamesapp.data.repository.VideoGameImpl
import cl.talentodigital.elixirgamesapp.databinding.ActivityMainBinding
import cl.talentodigital.elixirgamesapp.domain.VideoGameUseCase
import cl.talentodigital.elixirgamesapp.presentation.viewmodel.VideoGameViewModel
import cl.talentodigital.elixirgamesapp.presentation.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService = RetrofitHelper.getRetrofit().create(VideoGameService::class.java)
        val repository = VideoGameImpl(apiService)
        val useCase = VideoGameUseCase(repository)

        val viewModelFactory = ViewModelFactory(useCase)
        val viewModel = ViewModelProvider(this, viewModelFactory)[VideoGameViewModel::class.java]

        val adapterVideoGame = VideoGameAdapter()
        binding.vgRecycler.adapter = adapterVideoGame
        binding.vgRecycler.layoutManager = LinearLayoutManager(this)

        viewModel.videoGameLv.observe(this){
            Log.i("GAMES", it.toString())
            adapterVideoGame.videoGames = it
        }
    }
}