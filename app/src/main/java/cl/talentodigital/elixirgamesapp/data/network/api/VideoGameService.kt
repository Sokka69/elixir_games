package cl.talentodigital.elixirgamesapp.data.network.api

import cl.talentodigital.elixirgamesapp.data.response.VideoGameDetailResponse
import cl.talentodigital.elixirgamesapp.data.response.VideoGameResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface VideoGameService {
    @GET("games")
    suspend fun getAllVideoGames(): MutableList<VideoGameResponse>

    @GET("games/{id}")
    suspend fun getVideoGameById(@Path("id") idVideoGame: Long): VideoGameDetailResponse

}