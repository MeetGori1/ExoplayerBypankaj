package com.example.ExoplayerBypankaj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.temp.R
import com.example.temp.databinding.ActivityMainBinding
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.master.exoplayer.MasterExoPlayerHelper

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: VideoPlayAdapter
    lateinit var layoutManager: GridLayoutManager

    val list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        layoutManager = GridLayoutManager(this, 1)
        layoutManager.initialPrefetchItemCount = 5
        binding.rwRecyclerView.layoutManager = layoutManager

        val recyclerView: RecyclerView = binding.rwRecyclerView
        adapter = VideoPlayAdapter()
        binding.rwRecyclerView.adapter = adapter
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rwRecyclerView)
        val masterExoPlayerHelper = MasterExoPlayerHelper(mContext = this, id = R.id.media3PlayerView)
        masterExoPlayerHelper.makeLifeCycleAware(this)
        masterExoPlayerHelper.attachToRecyclerView(recyclerView)

//Used to customize attributes
        masterExoPlayerHelper.getPlayerView().apply {
            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
        }




//        for (i in 1..10) {
        list.add("http://content.jwplatform.com/manifests/vM7nH0Kl.m3u8")
        list.add("https://devstreaming-cdn.apple.com/videos/streaming/examples/img_bipbop_adv_example_fmp4/master.m3u8")
        list.add("http://playertest.longtailvideo.com/adaptive/wowzaid3/playlist.m3u8")
        list.add("https://assets.afcdn.com/video49/20210722/v_645516.m3u8")
        list.add("http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8")
//        }


        adapter.setItems(list)


    }}


