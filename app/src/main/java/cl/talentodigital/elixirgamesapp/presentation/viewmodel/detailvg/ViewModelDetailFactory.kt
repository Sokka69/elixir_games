package cl.talentodigital.elixirgamesapp.presentation.viewmodel.detailvg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.elixirgamesapp.domain.VideoGameUseCase

class ViewModelDetailFactory(private val videoGameUseCase: VideoGameUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(videoGameUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}