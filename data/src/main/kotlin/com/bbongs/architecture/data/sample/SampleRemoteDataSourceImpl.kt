package com.bbongs.architecture.data.sample

import com.bbongs.architecture.architecture.sample.SampleRepository
import com.bbongs.architecture.net.ApiResult
import javax.inject.Inject


class SampleRemoteDataSourceImpl @Inject constructor(
    private val remoteDataSource: SampleDataSource
) : SampleRepository {

    override suspend fun getSampleList(sampleParameter: String): Unit {
        return when (val response = remoteDataSource.getSampleList(sampleParameter)) {
            is ApiResult.Success -> {

            }
            is ApiResult.Failure -> {

            }
        }
    }
}