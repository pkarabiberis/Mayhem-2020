package com.example.mayhemfb.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mayhemfb.yllasFragments.FragmentInfoYllas
import com.example.mayhemfb.yllasFragments.FragmentSportsYllas
import com.example.mayhemfb.yllasFragments.FragmentTimeTablesYllas

class MyPagerAdapterYllas (fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentInfoYllas()
            }
            1 -> {
                FragmentSportsYllas()
            }
            else -> {
                return FragmentTimeTablesYllas()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Info"
            1 -> "Sports"
            else -> {
                return "Timetables"
            }
        }
    }
}