package com.evirgenoguz.domain

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.data.SampleRepository
import com.evirgenoguz.model.SampleModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetSampleDataUseCase @Inject constructor(
    private val sampleRepository: SampleRepository
) {

    suspend operator fun invoke(): Flow<ResponseState<SampleModel>> {
        // return sampleRepository.getSampleData()
        delay(300L)
        return flowOf(ResponseState.Success(SampleModel(0, "tasci")))
    }

}