package com.example.ExoplayerBypankaj

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.temp.databinding.ItemVideoBinding
import com.master.exoplayer.ExoPlayerHelper


class VideoPlayAdapter() :
    RecyclerView.Adapter<VideoPlayAdapter.MyViewHolder>() {
    lateinit var list: ArrayList<String>
    fun setItems(dataList: List<String>) {
        list = dataList as ArrayList<String>
        notifyDataSetChanged()
    }

    fun upDateItem(dataList: ArrayList<String>) {
        list.addAll(dataList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int,
    ): MyViewHolder {
        val binding =
            ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(bean: String) {

            binding.media3PlayerView.url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
//           BasePlayer.play(itemView.context,binding.media3PlayerView,bean)


            binding.media3PlayerView.listener = object : ExoPlayerHelper.Listener {

                //Listen for buffering listener
                override fun onBuffering(isBuffering: Boolean) {
                    super.onBuffering(isBuffering)
                    Log.i("TAG", isBuffering.toString())
                }

                //Update mute/unmute icon on player ready callback.

                override fun onPlayerReady() {
                    super.onPlayerReady()
//                    binding.ivVolume.visibility = View.VISIBLE
//                    if (binding.frame.isMute) {
//                        binding.ivVolume.setImageResource(R.drawable.ic_volume_off)
//                    } else {
//                        binding.ivVolume.setImageResource(R.drawable.ic_volume_on)
//                    }
                }

                override fun onStop() {
                    super.onStop()
//                    binding.ivVolume.visibility = View.GONE
                }
            }

        }
    }
}