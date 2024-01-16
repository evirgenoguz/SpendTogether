package com.evirgenoguz.data

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.model.SampleModel
import kotlinx.coroutines.flow.Flow

interface SampleRepository {
    suspend fun getSampleData(): Flow<ResponseState<SampleModel>>
}