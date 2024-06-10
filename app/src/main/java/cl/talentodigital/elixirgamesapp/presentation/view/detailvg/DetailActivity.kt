package cl.talentodigital.elixirgamesapp.presentation.view.detailvg

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.elixirgamesapp.R
import cl.talentodigital.elixirgamesapp.data.network.api.VideoGameService
import cl.talentodigital.elixirgamesapp.data.network.retrofit.RetrofitHelper
import cl.talentodigital.elixirgamesapp.data.repository.VideoGameImpl
import cl.talentodigital.elixirgamesapp.databinding.ActivityDetailBinding
import cl.talentodigital.elixirgamesapp.domain.VideoGameUseCase
import cl.talentodigital.elixirgamesapp.presentation.viewmodel.detailvg.DetailViewModel
import cl.talentodigital.elixirgamesapp.presentation.viewmodel.detailvg.ViewModelDetailFactory
import kotlin.math.log

class DetailActivity : AppCompatActivity() {

    private lateinit var bindingDetail: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bindingDetail = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(bindingDetail.root)

        val idVideogame = intent.getLongExtra("ID_VIDEOGAME", -1)
        if (idVideogame == -1L) {
            finish()
        }

        val apiService = RetrofitHelper.getRetrofit().create(VideoGameService::class.java)
        val repository = VideoGameImpl(apiService)
        val useCase = VideoGameUseCase(repository)

        val viewModelFactory = ViewModelDetailFactory(useCase)
        val viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]

        viewModel.getDetailVideoGameById(idVideogame)
        viewModel.videoGamedetailLV.observe(this){
            Log.i("DetailSActivity", it.toString())
        }

        bindingDetail.idGame.text = idVideogame.toString()
    }
}