package com.example.admin.pager2

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_sticker.view.*
import java.io.InputStream

/**
 * Created by hoangduchuuvn@gmail.com on 10/18/18 .
 */
class StickerAdapter(val context: Context,
                     var stickerPathUrlArrays: ArrayList<String>) : RecyclerView.Adapter<StickerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sticker, parent, false))
    }

    override fun getItemCount(): Int {
        return stickerPathUrlArrays.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            val img: InputStream = context.getAssets().open(stickerPathUrlArrays[position])
//
            val d: Drawable = Drawable.createFromStream(img, null)
            holder.ivSticker.setImageDrawable(d)
        } catch (e: Exception) {

        }
        holder.ivSticker.setOnClickListener {

        }

    }

    fun setPathList(stickerList: ArrayList<String>) {
        this.stickerPathUrlArrays = stickerList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivSticker = view.ivSticker
    }


}