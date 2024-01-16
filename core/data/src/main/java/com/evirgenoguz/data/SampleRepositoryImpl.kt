package com.evirgenoguz.data

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.model.SampleModel
import com.evirgenoguz.model.mapTo
import com.evirgenoguz.network.source.rest.RestDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val restDataSource: RestDataSource
) : SampleRepository {
    override suspend fun getSampleData(): Flow<ResponseState<SampleModel>> {
        return flow {
            emit(ResponseState.Loading)
            val response = restDataSource.getSampleData()
            emit(ResponseState.Success(response.mapTo {
                it.toSampleData()
            }))
        }
    }

}