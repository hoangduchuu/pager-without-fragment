package com.example.admin.pager2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = view_pager
        val adapter = CustomPagerAdapter(this)
        viewPager.adapter = adapter
        tabs.addTab(tabs.newTab().setText("111"))
        tabs.addTab(tabs.newTab().setText("222"))
        tabs.addTab(tabs.newTab().setText("333"))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.e6))
//        tabs.setupWithViewPager(viewPager)
    }

}
