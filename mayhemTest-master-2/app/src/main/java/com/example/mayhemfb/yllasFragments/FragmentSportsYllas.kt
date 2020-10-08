package com.example.mayhemfb.yllasFragments

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mayhemfb.R
import com.example.mayhemfb.yllasSportsActivities.*
import kotlinx.android.synthetic.main.activity_yllas.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentSportsYllas : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutYllas = inflater.inflate(R.layout.activity_yllas, null)

        val fatbike_btn : ImageView = layoutYllas.findViewById(R.id.fatbike_btn)
        val hillClimb_btn : ImageView = layoutYllas.findViewById(R.id.hillClimb_btn)
        val hillCross_btn : ImageView = layoutYllas.findViewById(R.id.hillCross_btn)
        val xCountry_btn : ImageView = layoutYllas.findViewById(R.id.xcountry_btn)
        val banked_btn : ImageView = layoutYllas.findViewById(R.id.banked_btn)
        val slopeStyle_btn : ImageView = layoutYllas.findViewById(R.id.slopeStyle_btn)
        val snowboard_slope_btn : ImageView = layoutYllas.findViewById(R.id.snowboard_slope_btn)
        val motulsnowcross_btn : ImageView = layoutYllas.findViewById(R.id.motulsnowcross_btn)
        val motulvintage_btn : ImageView = layoutYllas.findViewById(R.id.motulvintagesnowcross_btn)
        val snakerail_btn : ImageView = layoutYllas.findViewById(R.id.snake_rail_btn)
        val pimp_btn : ImageView = layoutYllas.findViewById(R.id.pimp_btn)
        val pool_btn : ImageView = layoutYllas.findViewById(R.id.pool_btn)

        fatbike_btn.setOnClickListener {
            val intent = Intent(activity, FatBikeChallengeYllas::class.java)
            startActivity(intent)
        }

        hillClimb_btn.setOnClickListener {
            val intent = Intent(activity, ScottHillClimbActivityYllas::class.java)
            startActivity(intent)
        }

        hillCross_btn.setOnClickListener {
            val intent = Intent(activity, HillCrossSeriesActivityYllas::class.java)
            startActivity(intent)
        }

        xCountry_btn.setOnClickListener {
            val intent = Intent(activity, xCountrySkiHillClimbYllas::class.java)
            startActivity(intent)
        }

        banked_btn.setOnClickListener {
            val intent = Intent(activity, BankedSlalomYllas::class.java)
            startActivity(intent)
        }

        motulsnowcross_btn.setOnClickListener {
            val intent = Intent(activity, MotulSnowcrossActivityYllas::class.java)
            startActivity(intent)
        }

        motulvintage_btn.setOnClickListener {
            val intent = Intent(activity, MotulVintageSnowcrossActivityYllas::class.java)
            startActivity(intent)
        }

        slopeStyle_btn.setOnClickListener {
            val intent = Intent(activity, SkiSlopeStyleActivityYllas::class.java)
            startActivity(intent)
        }

        snowboard_slope_btn.setOnClickListener {
            val intent = Intent(activity, SnowboardSlopeActivityYllas::class.java)
            startActivity(intent)
        }

        snakerail_btn.setOnClickListener {
            val intent = Intent(activity, SnakeRailActivityYllas::class.java)
            startActivity(intent)
        }

        pimp_btn.setOnClickListener {
            val intent = Intent(activity, PimpMyPulkkaActivityYllas::class.java)
            startActivity(intent)
        }

        pool_btn.setOnClickListener {
            val intent = Intent(activity, PoolCrossingActivityYllas::class.java)
            startActivity(intent)
        }

        return layoutYllas
    }
}

