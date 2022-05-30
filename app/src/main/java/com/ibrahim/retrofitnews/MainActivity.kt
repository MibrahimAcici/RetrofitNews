package com.ibrahim.retrofitnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.retrofitnews.adapter.NewsAdapter
import com.ibrahim.retrofitnews.databinding.ActivityMainBinding
import com.ibrahim.retrofitnews.model.NewsResponse
import com.ibrahim.retrofitnews.service.NewsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var newsAdapter: NewsAdapter  //Adapter tanımlama
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        fetchNews()
    }
    private fun initAdapter() {
        //Adapter Tanımlayıp başlatma
        newsAdapter = NewsAdapter()
        binding.recyclerView.adapter = newsAdapter
        //Adapterin Ekrandaki Görünümü
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
    }
    private fun fetchNews() {
        binding.recyclerView.isVisible = false
        binding.progress.isVisible = true
        //Servise istek atma
        //val request=PlaceAPI().getPlaceService().getPlaces(100)
        //https://newsapi.org/v2/top-headlines/sources?apiKey=API_KEY
        val request=NewsAPI().getNewsService().getNews("apple","57aa8a24cfff432db1dd4f251726269e")
        request.enqueue(object : Callback<NewsResponse> {//Liste değil [ ile başlamıyor Callback<List<şeklinde yazmadık
        override fun onResponse(
            call: Call<NewsResponse>,
            response: Response<NewsResponse>
        ) {
            //Toast.makeText(applicationContext, response.body()?.result?.get(0)?.lokasyon,Toast.LENGTH_LONG).show()

            newsAdapter.setList(response.body()?.articles ?: emptyList())
            binding.recyclerView.isVisible = true
            binding.progress.isVisible = false
        }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Toast.makeText(applicationContext,t.message.toString(), Toast.LENGTH_LONG).show()
                binding.recyclerView.isVisible = true
                binding.progress.isVisible = false
            }
        })
    }}
