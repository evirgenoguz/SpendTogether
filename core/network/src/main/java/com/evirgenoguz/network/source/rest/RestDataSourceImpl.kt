package com.evirgenoguz.network.source.rest

import com.evirgenoguz.network.dto.SampleResponse
import retrofit2.Response
import javax.inject.Inject

class RestDataSourceImpl @Inject constructor(private val sampleApi: SampleApi) :
    RestDataSource {
    override suspend fun getSampleData(): Response<SampleResponse> {
        return sampleApi.getSampleData()
    }
}