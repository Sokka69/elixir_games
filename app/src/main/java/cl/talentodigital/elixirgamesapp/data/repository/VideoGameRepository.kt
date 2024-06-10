package cl.talentodigital.elixirgamesapp.data.repository

import cl.talentodigital.elixirgamesapp.data.network.api.VideoGameService
import cl.talentodigital.elixirgamesapp.data.response.VideoGameDetailResponse
import cl.talentodigital.elixirgamesapp.data.response.VideoGameResponse

interface VideoGameRepository {

    suspend fun fetchVideoGames():MutableList<VideoGameResponse>

    suspend fun fetchVideoGameById(idVideoGameService: Long): VideoGameDetailResponse
    

}