package com.example.admin.pager2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.pager2.stickerview.StickerData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var cateList = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = view_pager

        val data = getCategories()

        val adapter = CustomPagerAdapter(this, data)
        viewPager.offscreenPageLimit = 0;

        viewPager.adapter = adapter

        for (index in data.categoryList.indices) {
            tabs.addTab(tabs.newTab().setText(data.categoryList[index]))

        }
        tabs.setupWithViewPager(viewPager)
    }

    private fun getCategories(): StickerData {
        var folderName = ArrayList<String>()


        val res = resources //if you are in an activity
        val am = res.assets
        val folders = am.list("stickers/")
        for (i in folders.indices) {
            folderName.add("${folders[i]}")
        }


        return StickerData(folderName)
    }

}
