package com.bbongs.architecture.architecture.sample


interface SampleRepository {
    suspend fun getSampleList(sampleParameter: String): Unit
}