package com.example.mayhemfb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mayhemfb.Adapters.MyPagerAdapterYllas
import kotlinx.android.synthetic.main.activity_olos_tester.*

class YllasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yllas_tester)

        val fragmentAdapter = MyPagerAdapterYllas(
            supportFragmentManager
        )
        viewPager.adapter = fragmentAdapter

        tabLayout.setupWithViewPager(viewPager)
    }
}
