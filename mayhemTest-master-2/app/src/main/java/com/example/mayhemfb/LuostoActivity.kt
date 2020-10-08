package com.example.mayhemfb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mayhemfb.Adapters.MyPagerAdapterLuosto
import kotlinx.android.synthetic.main.activity_luosto_tester.*

class LuostoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luosto_tester)

        val fragmentAdapter = MyPagerAdapterLuosto(
            supportFragmentManager
        )
        viewPager.adapter = fragmentAdapter

        tabLayout.setupWithViewPager(viewPager)
    }
}
