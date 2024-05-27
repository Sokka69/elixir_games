package cl.talentodigital.elixirgamesapp.data.network.api

import cl.talentodigital.elixirgamesapp.data.network.retrofit.RetrofitHelper
import cl.talentodigital.elixirgamesapp.data.response.VideoGameResponse

class VideoGameApiClient {

    private val retrofit = RetrofitHelper.getRetrofit()

     suspend fun getVideoGames(): MutableList<VideoGameResponse>{
        val response = retrofit.create(VideoGameService::class.java).getAllVideoGames()
         return response
    }
}