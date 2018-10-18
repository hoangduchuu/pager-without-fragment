package com.example.admin.pager2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.pager2.stickerview.StickerData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var cateList = ArrayList<String>()
    var stickerPathList = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = view_pager

        val data = getData()

        val adapter = CustomPagerAdapter(this, data)
        viewPager.adapter = adapter
        tabs.addTab(tabs.newTab().setText("111"))
        tabs.addTab(tabs.newTab().setText("222"))
        tabs.addTab(tabs.newTab().setText("333"))
        tabs.addTab(tabs.newTab().setText("444"))
        tabs.addTab(tabs.newTab().setText("555"))
        tabs.setupWithViewPager(viewPager)
    }

    private fun getData(): StickerData {
        cateList.add("cate1")
        cateList.add("cate2")
        cateList.add("cate3")
        cateList.add("cate4")
        cateList.add("cate5")


        stickerPathList.add("path1")
        stickerPathList.add("path2")
        stickerPathList.add("path3")
        stickerPathList.add("path4")
        stickerPathList.add("path5")
        stickerPathList.add("path6")

        return StickerData(cateList, stickerPathList)
    }

}
