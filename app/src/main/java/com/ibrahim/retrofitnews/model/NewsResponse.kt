package com.ibrahim.retrofitnews.model

data class NewsResponse(
	val totalResults: Int? = null,
	val articles: List<NewsItem?>? = null,
	val status: String? = null
)
