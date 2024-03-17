@file:Suppress("UnusedImport")

package com.example.submissionandroidexpertpertama.core.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionandroidexpertpertama.databinding.ListRestoBinding

class RestaurantAdapter(private val listener : OnClick): RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<com.example.submissionandroidexpertpertama.core.domain.model.Restaurant>(){
        override fun areItemsTheSame(oldItem: com.example.submissionandroidexpertpertama.core.domain.model.Restaurant, newItem: com.example.submissionandroidexpertpertama.core.domain.model.Restaurant): Boolean {
            return oldItem.id == newItem.id
        }
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: com.example.submissionandroidexpertpertama.core.domain.model.Restaurant, newItem: com.example.submissionandroidexpertpertama.core.domain.model.Restaurant): Boolean {
            return oldItem.id.hashCode() == newItem.id.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this,diffUtil)

    fun submit(data : List<com.example.submissionandroidexpertpertama.core.domain.model.Restaurant>) = differ.submitList(data)

    interface OnClick{
        fun onDetail(restaurant : com.example.submissionandroidexpertpertama.core.domain.model.Restaurant)
    }
    inner class RestaurantViewHolder(val binding : ListRestoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(ListRestoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.binding.apply {
            val item = differ.currentList[position]
            restoTittle.text = item.name
            Glide.with(root).load("https://restaurant-api.dicoding.dev/images/small/${item.pictureId}").into(restoImage)
            cardResto.setOnClickListener {
                listener.onDetail(item)
            }
        }
    }


}

