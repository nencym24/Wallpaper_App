package com.nency.wallpaperapp

import android.graphics.ColorSpace.Model
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.nency.wallpaperapp.API.ApiClient
import com.nency.wallpaperapp.API.ApiInterface
import com.nency.wallpaperapp.Adapter.WallPaperAdapter
import com.nency.wallpaperapp.Model.PhotoModel
import com.nency.wallpaperapp.Model.PhotosItem
import com.nency.wallpaperapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: WallPaperAdapter
    var auth = "yE3MfGPhMucNhYqYSlWrjwalrPvk92c6vlOfXxUJdkLu345OGHPhtFnL"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = WallPaperAdapter()
        binding.btnSearch.setOnClickListener {
            callApi()
        }

    }

    private fun callApi() {

        var txt =binding.edtSearch.text.toString()

        var api : ApiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        api.getWallpaper(auth, txt).enqueue(object : Callback<PhotoModel> {

            override fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>) {
                if (response.isSuccessful) {
                    var photos = response.body()?.photos
                    adapter.setWallpaper(photos as List<PhotosItem>)
                    binding.rcvWallpaper.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    binding.rcvWallpaper.adapter = adapter

                }
            }
            override fun onFailure(call: Call<PhotoModel>, t: Throwable) {
            }
        })
    }
}