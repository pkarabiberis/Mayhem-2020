package com.example.mayhemfb.olosFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mayhemfb.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.fragment_timetables_olos.*
import kotlinx.android.synthetic.main.timetables_layout.view.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentTimeTablesOlos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutOlosTimeTables = inflater.inflate(R.layout.fragment_timetables_olos, container, false)

        val db = FirebaseFirestore.getInstance()
        val sportTimes = db.collection("Locations").document("Olos").collection("Timetables")
        val infoText = db.collection("Locations").document("Olos").collection("Timetables").document("info")


        infoText
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val info = document.data?.get("infoText")
                    if (info != null) {
                        infoText_olos.text = info.toString()
                    }
                } else {
                    Log.w("Pate", "no document found")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("PATE", "Error getting documents: ", exception)
            }
        sportTimes
            .orderBy("startTime", Query.Direction.ASCENDING)
            .get()
            .addOnSuccessListener { documents ->
                for ((index, doc) in documents.withIndex()) {
                    val testeri = inflater.inflate(R.layout.timetables_layout, null)
                    testeri.times_textView.text = doc.data["startTime"].toString()
                    testeri.content_textView.text = doc.data["content"].toString()
                    timetables.addView(testeri)
                }
            }
            .addOnFailureListener { exception ->
                Log.w("PATE", "Error getting documents: ", exception)
            }

        return layoutOlosTimeTables
        }
    }

