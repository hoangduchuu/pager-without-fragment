package com.example.admin.pager2.stickerview

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.admin.pager2.R
import com.example.admin.pager2.StickerAdapter
import com.example.admin.pager2.exts.inflate


class StickerView : LinearLayout {


    lateinit var mContext: Context
    lateinit var categoryPath: String

    var urlList = ArrayList<String>()


    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, categoryPath: String, pagePosition: Int) : super(context) {
        mContext = context

        this.categoryPath = categoryPath
        urlList = getListUrlStickerFactory(categoryPath, pagePosition)
        this.initView(pagePosition)

    }

    private fun getListUrlStickerFactory(folderName: String, pagePosition: Int): ArrayList<String> {
        var stickerPathList: ArrayList<String>

        if (pagePosition == 0) {
            stickerPathList = getListUrlStickerHistory()
        } else {
            stickerPathList = getLtUrlStickerByFolderName(folderName)
        }
        return stickerPathList

    }

    private fun getLtUrlStickerByFolderName(folderName: String): ArrayList<String> {
        var list = ArrayList<String>()
        val res = resources //if you are in an activity
        val am = res.assets
        val stickerList = am.list("stickers/$folderName")
        for (i in stickerList.indices) {
            list.add("stickers/$folderName/${stickerList[i]}")
        }
        return list
    }

    private fun getListUrlStickerHistory(): ArrayList<String> {
return arrayListOf("","","")
    }

    private fun initView(pagePosition: Int) {
        inflate(R.layout.view_list_sticker, true)
        val rvStickers: RecyclerView = this.findViewById(R.id.rvStickers)
        rvStickers.layoutManager = GridLayoutManager(mContext, 5, LinearLayoutManager.VERTICAL, false) as RecyclerView.LayoutManager?
        val stickerAdapter = StickerAdapter(mContext, urlList)
        rvStickers.adapter = stickerAdapter;

    }
}