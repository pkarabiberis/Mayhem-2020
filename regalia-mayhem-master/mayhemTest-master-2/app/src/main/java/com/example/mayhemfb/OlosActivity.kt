package com.example.mayhemfb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mayhemfb.Adapters.MyPagerAdapterOlos
import kotlinx.android.synthetic.main.activity_olos_tester.*

class OlosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olos_tester)

        val fragmentAdapter = MyPagerAdapterOlos(
            supportFragmentManager
        )
        viewPager.adapter = fragmentAdapter

        tabLayout.setupWithViewPager(viewPager)
    }
}
