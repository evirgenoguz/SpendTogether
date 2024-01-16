package com.evirgenoguz.domain

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.data.SampleRepository
import com.evirgenoguz.model.SampleModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSampleDataUseCase @Inject constructor(
    private val sampleRepository: SampleRepository
) {

    suspend operator fun invoke(): Flow<ResponseState<SampleModel>> {
        return sampleRepository.getSampleData()
    }

}