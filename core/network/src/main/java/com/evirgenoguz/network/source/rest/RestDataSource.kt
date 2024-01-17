package com.evirgenoguz.network.source.rest

import com.evirgenoguz.network.dto.SampleResponse
import retrofit2.Response

interface RestDataSource {
    suspend fun getSampleData(): Response<SampleResponse>

}