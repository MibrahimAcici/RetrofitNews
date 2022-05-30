package com.ibrahim.retrofitnews.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPI {
    //https://newsapi.org/v2/everything?q=bitcoin&apiKey=57aa8a24cfff432db1dd4f251726269e
    private val BASE_URL = "https://newsapi.org/v2/"

    private val newsApi: NewsService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsService::class.java)

    fun getNewsService() = newsApi
}