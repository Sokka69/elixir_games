package cl.talentodigital.elixirgamesapp.data.repository

import cl.talentodigital.elixirgamesapp.data.response.VideoGameResponse

interface VideoGameRepository {

    suspend fun fetchVideoGames():MutableList<VideoGameResponse>
}