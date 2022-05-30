package com.ibrahim.retrofitnews.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahim.retrofitnews.databinding.ItemNewsBinding
import com.ibrahim.retrofitnews.model.NewsItem

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsVH>() {

    private var newsList: ArrayList<NewsItem?> = arrayListOf()

    fun setList(newList: List<NewsItem?>) {
        this.newsList.clear()
        this.newsList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class NewsVH(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
/*
        fun bind(s: PlaceItem?) {
            s?.date?.let {
                if (it.length > 15) {
                    itemView.tv_item.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.purple_700
                        )
                    )
                }
            }
        }*/
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        return NewsVH(ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        val news=newsList[position]

        Glide.with(holder.binding.imageNews.context)
            .load(news?.urlToImage)
            .into(holder.binding.imageNews)

        holder.binding.tvNewsName.text=news?.title
        holder.binding.tvNewsCategory.text=news?.author
        holder.binding.tvNewsDescription.text = news?.description
    }

    override fun getItemCount(): Int = newsList.size

}