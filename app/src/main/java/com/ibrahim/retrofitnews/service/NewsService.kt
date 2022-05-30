package com.ibrahim.retrofitnews.service

import com.ibrahim.retrofitnews.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
//https://newsapi.org/v2/everything?q=bitcoin&apiKey=57aa8a24cfff432db1dd4f251726269e
interface NewsService {
    @GET("everything")
    fun getNews(@Query("q") q: String,@Query("apiKey") apiKey: String) : Call<NewsResponse>
}