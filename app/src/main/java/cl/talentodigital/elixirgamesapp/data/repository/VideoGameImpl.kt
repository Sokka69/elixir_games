package cl.talentodigital.elixirgamesapp.data.repository

import cl.talentodigital.elixirgamesapp.data.network.api.VideoGameService
import cl.talentodigital.elixirgamesapp.data.response.VideoGameDetailResponse
import cl.talentodigital.elixirgamesapp.data.response.VideoGameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoGameImpl(private var apiservice : VideoGameService): VideoGameRepository {
    override suspend fun fetchVideoGames(): MutableList<VideoGameResponse> {
        return withContext(Dispatchers.IO){
            val listVideoGames = apiservice.getAllVideoGames()
            listVideoGames
        }
    }

    override suspend fun fetchVideoGameById(idVideoGameService: Long): VideoGameDetailResponse {
        return  withContext(Dispatchers.IO){
            val videoGeamDetail = apiservice.getVideoGameById(idVideoGameService)
            videoGeamDetail
        }
    }
}