package com.nency.wallpaperapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.nency.wallpaperapp.Model.WallpaperModel
import com.nency.wallpaperapp.databinding.WallpaperItemBinding

class WallPaperAdapter : RecyclerView.Adapter<WallPaperAdapter.WallpaperHolder>(){

    lateinit var photos: ArrayList<WallpaperModel.PhotosItem>
    lateinit var context: Context

    class WallpaperHolder(itemView: WallpaperItemBinding) : ViewHolder(itemView.root){
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperHolder {
        context = parent.context
        var binding = WallpaperItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WallpaperHolder(binding)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: WallpaperHolder, position: Int) {

        holder.binding.apply {
            photos.get(position)?.src?.apply {
                Glide.with(context).load(portrait).into(imgWallpaper)
            }
        }
    }

    fun setWallpaper(photos: List<WallpaperModel.PhotosItem>) {
        this.photos = (photos as ArrayList<WallpaperModel.PhotosItem>)
    }
}