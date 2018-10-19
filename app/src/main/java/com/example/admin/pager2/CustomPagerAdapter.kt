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
import com.example.admin.pager2.stickerview.StickerView

class CustomPagerAdapter(private val mContext: Context, var data: StickerData) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val stickerView = StickerView(mContext,data.categoryList[position], position)
        collection.addView(stickerView)
        return stickerView
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
