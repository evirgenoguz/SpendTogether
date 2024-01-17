package com.evirgenoguz.network.source.rest

import com.evirgenoguz.network.dto.SampleResponse
import retrofit2.Response
import retrofit2.http.GET

interface SampleApi {
    @GET("character")
    suspend fun getSampleData(): Response<SampleResponse>

}