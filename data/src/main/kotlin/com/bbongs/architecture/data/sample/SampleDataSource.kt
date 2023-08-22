package com.bbongs.architecture.data.sample

import com.bbongs.architecture.net.ApiResult


interface SampleDataSource {
    suspend fun getSampleList(sampleIds: String): ApiResult<Unit>
}