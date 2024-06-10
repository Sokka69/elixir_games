package cl.talentodigital.elixirgamesapp.data.local

data class VideoGameDetail(
    val idDetail: Long,
    val playtime: Long,
    val platforms: String,
    val genres: String,
    val format: String,
    val price: Double,
    val lastPrice: Double,
    val delivery: Boolean
)
