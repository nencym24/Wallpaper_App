package com.nency.wallpaperapp.API

import com.nency.wallpaperapp.Model.WallpaperModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")

    fun getWallpaper(
        @Header("Authorization")auth: String,
        @Query("query")query: String
    ): Call<WallpaperModel>
}