package cl.talentodigital.elixirgamesapp.data.network.api

import cl.talentodigital.elixirgamesapp.data.response.VideoGameResponse
import retrofit2.http.GET

interface VideoGameService {
    @GET("games")
    suspend fun getAllVideoGames(): MutableList<VideoGameResponse>
}