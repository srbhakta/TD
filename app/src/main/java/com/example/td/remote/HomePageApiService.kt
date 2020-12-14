package com.example.td.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com/test/"

/**
 * Contains supported api information
 */
interface HomePageApiService {
    /**
     * home api provides the home page information.
     */
    @GET("home")
    suspend fun getCards(): HomePageData
}

/**
 * Main entry point for network access.
 */
object HomePageApi {
    private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    private val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()

    /**
     * Creates retrofit service instance.
     * By using this will be be calling the states.json api.
     */
    val retrofitService: HomePageApiService by lazy {
        retrofit.create(HomePageApiService::class.java)
    }
}
