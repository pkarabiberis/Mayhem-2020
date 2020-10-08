package com.example.mayhemfb.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mayhemfb.luostoFragments.FragmentInfoLuosto
import com.example.mayhemfb.luostoFragments.FragmentSportsLuosto
import com.example.mayhemfb.luostoFragments.FragmentTimeTablesLuosto

class MyPagerAdapterLuosto (fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentInfoLuosto()
            }
            1 -> {
                FragmentSportsLuosto()
            }
            else -> {
                return FragmentTimeTablesLuosto()
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