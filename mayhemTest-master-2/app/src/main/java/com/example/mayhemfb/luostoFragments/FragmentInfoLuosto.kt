package com.example.mayhemfb.luostoFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mayhemfb.R
import kotlinx.android.synthetic.main.fragment_info_luosto.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentInfoLuosto : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutLuostoInfo = inflater.inflate(R.layout.fragment_info_luosto, container, false)
        val car_textView : TextView = layoutLuostoInfo.findViewById(R.id.car_textView)
        val train_textView : TextView = layoutLuostoInfo.findViewById(R.id.train_textView)
        val plane_textView : TextView = layoutLuostoInfo.findViewById(R.id.plane_textView)

        var carInfoSwitch = false
        var trainInfoSwitch = false
        var planeInfoSwitch = false

        car_textView.setOnClickListener {
            if (!carInfoSwitch) {
                car_info.text = "If you arrive from the south, continue from Rovaniemi towards Ivalo / Kemijärvi (E75)." +
                        " Continue on the road to the north for a little less than 90km. Take the Pyhä-Luostontie (962) " +
                        "and continue driving about 15km, until you arrive to the village. Turn to left to Luostotunturin " +
                        "and you will see The Lapland Hotel Luostotunturi on the right side of the road. After few hundreds meters you have arrived at the ski resort."
                car_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_remove_black_24dp, 0)
                carInfoSwitch = true
            } else {
                car_info.text = ""
                car_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_add_black_24dp, 0)
                carInfoSwitch = false
            }
        }

        train_textView.setOnClickListener {
            if (!trainInfoSwitch) {
                train_info.text = "Rovaniemi Railway station is located approximately 120 km from Luosto. If you arrive by car train, " +
                        "continue in the Ivalo / Kemijärvi direction (E75) from the station. Continue on the road to the north for a little" +
                        " less than 90km. Take the Pyhä-Luostontie (962) and continue driving about 15km, until you arrive to the village. " +
                        "Turn to left to Luostotunturin and you will see The Lapland Hotel Luostotunturi on the right side of the road. " +
                        "After few hundreds meters you have arrived at the ski resort."
                train_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_remove_black_24dp, 0)
                trainInfoSwitch = true
            } else {
                train_info.text = ""
                train_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_add_black_24dp, 0)
                trainInfoSwitch = false
            }
        }

        plane_textView.setOnClickListener {
            if (!planeInfoSwitch) {
                plane_info.text = "Rovaniemi Airport is located approximately 110 kilometers from Luosto. The transport connection" +
                        " from Rovaniemi to Luosto takes about 1h 30 minutes. From Kittilä it takes about 1h 50 min. SkiBus runs to" +
                        " Luosto every day flights and trains from Rovaniemi. During the winter season, SkiBus connection drives four" +
                        " times a day, in the summer twice a day. Additional information from Airport Express Rovaniemi Oy, tel. +358 40 724 9563."
                plane_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_remove_black_24dp, 0)
                planeInfoSwitch = true
            } else {
                plane_info.text = ""
                plane_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_add_black_24dp, 0)
                planeInfoSwitch = false
            }
        }

        return layoutLuostoInfo
        }
    }

