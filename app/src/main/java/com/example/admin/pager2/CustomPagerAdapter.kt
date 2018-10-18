package com.example.admin.pager2

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.admin.pager2.stickerview.StickerData

class CustomPagerAdapter(private val mContext: Context, var data: StickerData) : PagerAdapter() {

    lateinit var cloneView2: ImageView

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {

        cloneView2 = ImageView(mContext)
        cloneView2.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT) as ViewGroup.LayoutParams?
        cloneView2.setImageResource(R.mipmap.ic_launcher)

        if (position == 0) {
            cloneView2.setImageResource(R.drawable.e3)
        }
        if (position == 1) {
            cloneView2.setImageResource(R.drawable.e4)
        }
        if (position == 2) {
            cloneView2.setImageResource(R.drawable.e6)
        }
        if (position == 3) {
            cloneView2.setImageResource(R.drawable.e6)
        }
        if (position == 4) {
            cloneView2.setImageResource(R.mipmap.ic_launcher)
        }

//        val customPagerEnum = CustomPagerEnum.values()[position]
//        val inflater = LayoutInflater.from(mContext)
//        val layout = inflater.inflate(customPagerEnum.layoutResId, collection, false) as ViewGroup
        collection.addView(cloneView2)
        return cloneView2
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
