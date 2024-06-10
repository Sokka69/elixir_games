package cl.talentodigital.elixirgamesapp.presentation.viewmodel.detailvg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.talentodigital.elixirgamesapp.data.response.VideoGameDetailResponse
import cl.talentodigital.elixirgamesapp.domain.VideoGameUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val userCase:VideoGameUseCase) : ViewModel() {

    private val _videoGamedetail = MutableLiveData<VideoGameDetailResponse>()
    val videoGamedetailLV: MutableLiveData<VideoGameDetailResponse>
        get() = _videoGamedetail

    fun getDetailVideoGameById(idVideoGame:Long){
        viewModelScope.launch {
           val videoGame = userCase.getVideoGameByIdOnStock(idVideoGame)
            _videoGamedetail.value = videoGame
        }
    }
}