package com.example.admin.pager2.stickerview

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.admin.pager2.R
import com.example.admin.pager2.StickerAdapter
import com.example.admin.pager2.exts.inflate


class StickerView : LinearLayout{


    lateinit var mContext: Context
    lateinit var categoryPath: String

 var urlList = ArrayList<String>()


    constructor(context: Context) : super(context) {
        mContext = context

        this.initView()
    }
    constructor(context: Context,categoryPath:String) : super(context) {
        mContext = context

        this.categoryPath = categoryPath
        urlList = getPatFromFolder(categoryPath)
        this.initView()

    }

    private fun getPatFromFolder(categoryPath:String): ArrayList<String> {
         var stickerPathList = ArrayList<String>()


        val res = resources //if you are in an activity
        val am = res.assets
        val stickerList = am.list("stickers/$categoryPath")
        for (i in stickerList.indices) {
            stickerPathList.add("stickers/$categoryPath/${stickerList[i]}")
        }

        return stickerPathList
    }

    private fun initView() {
        inflate(com.example.admin.pager2.R.layout.view_list_sticker,true)


        val rvStickers: RecyclerView = this.findViewById(R.id.rvStickers)


        rvStickers.layoutManager = GridLayoutManager(mContext, 5, LinearLayoutManager.VERTICAL, false) as RecyclerView.LayoutManager?
        val stickerAdapter =StickerAdapter(mContext,urlList)
        rvStickers.adapter = stickerAdapter;

    }
}