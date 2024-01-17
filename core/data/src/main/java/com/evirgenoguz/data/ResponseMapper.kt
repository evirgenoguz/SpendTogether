package com.evirgenoguz.data

import com.evirgenoguz.model.SampleModel
import com.evirgenoguz.network.dto.SampleResponse
import retrofit2.Response

fun Response<SampleResponse>.toSampleData(): SampleModel {
    return body()!!.run {
        SampleModel(
            id = id,
            user = user
        )
    }
}