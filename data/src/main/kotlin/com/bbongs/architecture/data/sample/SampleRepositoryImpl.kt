package com.bbongs.architecture.data.sample

import com.bbongs.architecture.architecture.sample.SampleRepository
import javax.inject.Inject


class SampleRepositoryImpl @Inject constructor(
    private val localDataSource: SampleDataSource? = null,
    private val remoteDataSource: SampleDataSource
) : SampleRepository {
    override suspend fun getSampleList(sampleParameter: String) {
        localDataSource?.getSampleList(sampleParameter) ?: run {
            remoteDataSource.getSampleList(sampleParameter)
        }
    }
}