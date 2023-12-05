package com.app.rapidnumberconverter.network

import com.app.rapidnumberconverter.common.ContentCardItem
import retrofit2.Response
import retrofit2.http.GET

interface ConverterApiService {

    @GET("/help_articles")
    suspend fun getLearnArticles() : Response<List<ContentCardItem>>
}