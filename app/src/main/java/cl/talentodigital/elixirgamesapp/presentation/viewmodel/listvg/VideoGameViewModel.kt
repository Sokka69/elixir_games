package cl.talentodigital.elixirgamesapp.presentation.viewmodel.listvg

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.talentodigital.elixirgamesapp.data.response.VideoGameResponse
import cl.talentodigital.elixirgamesapp.domain.VideoGameUseCase
import kotlinx.coroutines.launch

class VideoGameViewModel(private val useCase: VideoGameUseCase): ViewModel() {

    private var videoGameList = MutableLiveData<MutableList<VideoGameResponse>>()

    val videoGameLv
        get() = videoGameList


    init {
        viewModelScope.launch {
            videoGameList.value = useCase.getAllVideoGamesOnStock()
        }
    }

}