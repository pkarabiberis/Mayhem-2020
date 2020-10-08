package com.example.mayhemfb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        luosto_btn.setOnClickListener {
            val intent = Intent(this, LuostoActivity::class.java)
            startActivity(intent)
        }
        olos_btn.setOnClickListener {
            val intent = Intent(this, OlosActivity::class.java)
            startActivity(intent)
        }
        yllas_btn.setOnClickListener {
            val intent = Intent(this, YllasActivity::class.java)
            startActivity(intent)
        }
    }
}
