package cl.talentodigital.elixirgamesapp.domain

import cl.talentodigital.elixirgamesapp.data.repository.VideoGameImpl
import cl.talentodigital.elixirgamesapp.data.response.VideoGameDetailResponse
import cl.talentodigital.elixirgamesapp.data.response.VideoGameResponse

class VideoGameUseCase(private val repository: VideoGameImpl) {
    suspend fun getAllVideoGamesOnStock(): MutableList<VideoGameResponse>{
        return repository.fetchVideoGames()
    }
    suspend fun getVideoGameByIdOnStock(idVideoGame: Long): VideoGameDetailResponse{
        return repository.fetchVideoGameById(idVideoGame)
    }

}