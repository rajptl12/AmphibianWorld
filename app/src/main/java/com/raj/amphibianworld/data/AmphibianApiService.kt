package com.raj.amphibianworld.data
import retrofit2.http.GET
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
private val jsonFormat = Json { ignoreUnknownKeys = true }

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(jsonFormat.asConverterFactory("application/json".toMediaType()))
    .build()
interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<AmphibianModel>
}
object AmphibianApi {
    val apiService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }
}
