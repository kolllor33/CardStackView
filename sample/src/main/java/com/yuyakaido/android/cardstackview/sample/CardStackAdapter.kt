package com.yuyakaido.android.cardstackview.sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide

class CardStackAdapter(
        private var spots: List<Spot> = emptyList()
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_spot, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spot = spots[position]
        holder.name.text = "${spot.id}. ${spot.name}"
        holder.city.text = spot.city
        Glide.with(holder.image)
                .load(spot.url)
                .into(holder.image)
        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, spot.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    fun setSpots(spots: List<Spot>) {
        this.spots = spots
    }

    fun getSpots(): List<Spot> {
        return spots
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnTouchListener {

        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            v?.parent?.requestDisallowInterceptTouchEvent(true)
            return false
        }

        val name: TextView = view.findViewById(R.id.item_name)
        var city: TextView = view.findViewById(R.id.item_city)
        var image: ImageView = view.findViewById(R.id.item_image)
        var scrollView: ScrollView = view.findViewById(R.id.scoll)
//        var videoView: VideoView = view.findViewById(R.id.videoviewer)

        init {
            scrollView.setOnTouchListener(this)
//            videoView.setVideoURI(Uri.parse(Environment.getExternalStorageDirectory().absolutePath + "/" + Environment.DIRECTORY_MOVIES + "/Never_Settle.mp4"))
//            videoView.start()
        }
    }

}
