package com.bbongs.architecture.architecture.sample

import com.bbongs.architecture.architecture.UseCaseResult



class SampleUseCase constructor(
    private val repository: SampleRepository
) {
    companion object {
        private const val TAG = "SampleUseCase"
    }

    suspend fun getSampleList(sampleParameter: String): UseCaseResult<Unit> {
        return try {
            UseCaseResult.Success(repository.getSampleList(sampleParameter))
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }
}