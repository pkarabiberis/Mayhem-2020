package com.example.mayhemfb.yllasFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mayhemfb.R
import kotlinx.android.synthetic.main.fragment_info_yllas.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentInfoYllas : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutYllasInfo = inflater.inflate(R.layout.fragment_info_yllas, container, false)
        val car_textView : TextView = layoutYllasInfo.findViewById(R.id.car_yllas_textView)
        val train_textView : TextView = layoutYllasInfo.findViewById(R.id.train_yllas_textView)
        val plane_textView : TextView = layoutYllasInfo.findViewById(R.id.plane_yllas_textView)

        var carInfoSwitch = false
        var trainInfoSwitch = false
        var planeInfoSwitch = false

        car_textView.setOnClickListener {
            if (!carInfoSwitch) {
                car_yllas_info.text = "If you arrive by car you can find us in Äkäslompolo village, at the address: Tunturintie 56.\n" +
                        "\n" +
                        "If you’re coming from the south, from the direction of Tornio on the E8, after you pass Kolari, " +
                        "continue driving for about another 8km. Turn right to Ylläksentie, there is a sign for Äkäslompolo " +
                        "at the crossing. When you arrive at Äkäslompolo village, turn right to Tunturintie (9401) and, after " +
                        "about five kilometer up to the fell, you can see Y1 main building on the left."
                car_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_remove_black_24dp, 0)
                carInfoSwitch = true
            } else {
                car_yllas_info.text = ""
                car_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_add_black_24dp, 0)
                carInfoSwitch = false
            }
        }

        train_textView.setOnClickListener {
            if (!trainInfoSwitch) {
                train_yllas_info.text = "Kolari Railway Station: Asematie 7, 95900 Kolari\n" +
                        "\n" +
                        "Car night train takes you to the Kolari Railway Station, which is about 35km from Ylläs. " +
                        "If you arrive by car train, continue in the direction of Muonio (E8) from the station. " +
                        "Continue about 8km on this road and turn right to Ylläksentie. There is a sign for Äkäslompolo at the crossing." +
                        " When you arrive at Äkäslompolo village, turn right to Tunturintie (9401) and, after about five kilometer up to " +
                        "the fell, you can see Y1 main building on the left.\n" +
                        "\n" +
                        "There is a bus connection from the railway station to Ylläs and back, according to the train timetable. Find out more about the timetables.\n" +
                        "\n" +
                        "If you intend to take a taxi from the railway station, the taxi stop is near the main entrance of the railway station."
                train_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_remove_black_24dp, 0)
                trainInfoSwitch = true
            } else {
                train_yllas_info.text = ""
                train_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_add_black_24dp, 0)
                trainInfoSwitch = false
            }
        }

        plane_textView.setOnClickListener {
            if (!planeInfoSwitch) {
                plane_yllas_info.text = "Kittilä Airport: Levintie 259, 99100 Kittilä\n" +
                        "\n" +
                        "The direct flight from Helsinki to Kittilä takes 1.5 hours. Both Finnair and Norwegian fly to Kittilä Airport.\n" +
                        "\n" +
                        "Bus transport to Äkäslompolo is also available. The airport bus operates for all domestic flights between Äkäslompolo - Ylläsjärvi" +
                        " - Kittilä Airport - Ylläsjärvi - Äkäslompolo during the holiday season and from May to August, as requested. Reservations should " +
                        "be made at least one day before your flight, at the latest. For more details regarding the connections and reservations for on-call connections," +
                        " please tel. 0200 14919 (€ 1.17 + local call charge) One-way transport from Äkäslompolo to Kittilä Airport is about € 15 for an adult and € 8 for a child under 12 years of age.\n" +
                        "\n" +
                        "Taxis are located just outside the airport door."
                plane_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_remove_black_24dp, 0)
                planeInfoSwitch = true
            } else {
                plane_yllas_info.text = ""
                plane_textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_add_black_24dp, 0)
                planeInfoSwitch = false
            }
        }

        return layoutYllasInfo
        }
    }

