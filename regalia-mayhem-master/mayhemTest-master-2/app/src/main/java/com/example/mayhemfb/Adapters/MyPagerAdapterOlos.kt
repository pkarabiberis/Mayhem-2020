package com.example.mayhemfb.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mayhemfb.olosFragments.FragmentInfoOlos
import com.example.mayhemfb.olosFragments.FragmentSportsOlos
import com.example.mayhemfb.olosFragments.FragmentTimeTablesOlos

class MyPagerAdapterOlos (fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentSportsOlos()
            }
            1 -> {
                FragmentTimeTablesOlos()
            }
            else -> {
                return FragmentInfoOlos()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Sports"
            1 -> "Timetables"
            else -> {
                return "Info?"
            }
        }
    }
}