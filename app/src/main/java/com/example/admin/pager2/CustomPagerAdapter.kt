package com.example.admin.pager2

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.admin.pager2.stickerview.StickerData

class CustomPagerAdapter(private val mContext: Context, var data: StickerData) : PagerAdapter() {

    lateinit var cloneView2: ImageView
    private var stickerPathUrlArrayList = ArrayList<String>()

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        stickerPathUrlArrayList.clear()
        cloneView2 = ImageView(mContext)
        cloneView2.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT) as ViewGroup.LayoutParams?
        cloneView2.setImageResource(R.mipmap.ic_launcher)
        val inflater = LayoutInflater.from(mContext)


        val layout = inflater.inflate(R.layout.view_list_sticker, collection, false) as ViewGroup
        val stickerAdapter = StickerAdapter(mContext, stickerPathUrlArrayList)
        val rvStickers: RecyclerView = layout.findViewById(R.id.rvStickers)


        rvStickers.layoutManager = GridLayoutManager(mContext, 5, LinearLayoutManager.VERTICAL, false) as RecyclerView.LayoutManager?

//        stickerAdapter.setPathList(loadData(data.categoryList[position]))
        Log.e("CustomPagerAdapter ", "position $position")
        rvStickers.adapter = stickerAdapter;

        collection.addView(layout)
        return layout
    }

    private fun loadData(folder: String): ArrayList<String> {
        stickerPathUrlArrayList.clear()
        Log.e("CustomPagerAdapter:", folder)
        for (index in 0..18) {
            stickerPathUrlArrayList.add("stickers/$folder/$index.png")
        }
        return stickerPathUrlArrayList
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return data.categoryList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return data.categoryList[position]
    }

}
