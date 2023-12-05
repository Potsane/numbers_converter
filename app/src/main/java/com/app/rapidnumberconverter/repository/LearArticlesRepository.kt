package com.app.rapidnumberconverter.repository

import com.app.rapidnumberconverter.common.ContentCardItem
import com.app.rapidnumberconverter.network.ConverterApiService
import retrofit2.Response
import javax.inject.Inject

class LearArticlesRepository @Inject constructor(private val converterApiService: ConverterApiService) {

    suspend fun fetchLearnArticles(): Response<List<ContentCardItem>> {
        return converterApiService.getLearnArticles()
    }
}