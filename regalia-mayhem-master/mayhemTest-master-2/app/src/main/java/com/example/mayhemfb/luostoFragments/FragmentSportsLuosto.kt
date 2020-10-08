package com.example.mayhemfb.luostoFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mayhemfb.R
import com.example.mayhemfb.luostoSportsActivities.*
import kotlinx.android.synthetic.main.activity_hillclimb.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentSportsLuosto : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutLuosto = inflater.inflate(R.layout.activity_luosto, null)

        val hillClimb_btn : ImageView = layoutLuosto.findViewById(R.id.hillClimb_btn)
        val hillCross_btn : ImageView = layoutLuosto.findViewById(R.id.hillCross_btn)
        val slopeStyle_btn : ImageView = layoutLuosto.findViewById(R.id.slopeStyle_btn)
        val snowboard_slope_btn : ImageView = layoutLuosto.findViewById(R.id.snowboard_slope_btn)
        val snowmobile_drag_race_btn : ImageView = layoutLuosto.findViewById(R.id.snowmobile_drag_race_btn)

        hillClimb_btn.setOnClickListener {
            val intent = Intent(activity, ScottHillClimbActivity::class.java)
            startActivity(intent)
        }

        hillCross_btn.setOnClickListener {
            val intent = Intent(activity, HillCrossSeriesActivity::class.java)
            startActivity(intent)
        }

        slopeStyle_btn.setOnClickListener {
            val intent = Intent(activity, SkiSlopeStyleActivity::class.java)
            startActivity(intent)
        }

        snowboard_slope_btn.setOnClickListener {
            val intent = Intent(activity, SnowboardSlopeActivity::class.java)
            startActivity(intent)
        }

        snowmobile_drag_race_btn.setOnClickListener {
            val intent = Intent(activity, SnowMobileDragRaceActivity::class.java)
            startActivity(intent)
        }
        return layoutLuosto
    }
}

