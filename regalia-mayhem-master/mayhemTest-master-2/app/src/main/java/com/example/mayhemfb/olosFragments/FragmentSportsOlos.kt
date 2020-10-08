package com.example.mayhemfb.olosFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mayhemfb.R
import com.example.mayhemfb.olosSportsActivities.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentSportsOlos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutOlos = inflater.inflate(R.layout.activity_olos, null)

        val hillClimb_btn : ImageView = layoutOlos.findViewById(R.id.hillClimb_btn)
        val hillCross_btn : ImageView = layoutOlos.findViewById(R.id.hillCross_btn)
        val slopeStyle_btn : ImageView = layoutOlos.findViewById(R.id.slopeStyle_btn)
        val snowboard_slope_btn : ImageView = layoutOlos.findViewById(R.id.snowboard_slope_btn)
        hillClimb_btn.setOnClickListener {
            val intent = Intent(activity, ScottHillClimbActivityOlos::class.java)
            startActivity(intent)
        }

        hillCross_btn.setOnClickListener {
            val intent = Intent(activity, HillCrossSeriesActivityOlos::class.java)
            startActivity(intent)
        }

        slopeStyle_btn.setOnClickListener {
            val intent = Intent(activity, SkiSlopeStyleActivityOlos::class.java)
            startActivity(intent)
        }

        snowboard_slope_btn.setOnClickListener {
            val intent = Intent(activity, SnowboardSlopeActivityOlos::class.java)
            startActivity(intent)
        }

        return layoutOlos
    }
}

