package com.example.mayhemfb.luostoSportsActivities

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mayhemfb.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_hillclimb.*
import kotlinx.android.synthetic.main.activity_hillclimb.listOfScores
import kotlinx.android.synthetic.main.activity_hillclimb.registration_btn
import kotlinx.android.synthetic.main.activity_slopestyle.*
import kotlinx.android.synthetic.main.activity_snowboard_slope.*
import kotlinx.android.synthetic.main.results_layout.view.*
import kotlinx.android.synthetic.main.testerihorizontalresults.view.*

class SnowboardSlopeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snowboard_slope)

        val db = FirebaseFirestore.getInstance()

        val textWidth = getScreenWidth()/3
        val captions = listOf("Position", "Name", "Best time", "Sponsor", "Club", "Number")

        val luosto = db.collection("Locations").document("Luosto")
        val snowboard_slopeStyle = luosto.collection("Sports").document("snowboard-slopestyle")
        val sportTime = luosto.collection("Timetables").document("snowboard-slopestyle")

        registration_btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mayhem.fi/fi/registration"))
            startActivity(intent)
        }

        sportTime
            .get()
            .addOnSuccessListener { documents ->
                val startTime = documents.data?.get("startTime")
                val endTime = documents.data?.get("endTime")
                if (startTime != null && endTime != null) {
                    timeSnowboard.text = startTime.toString() + " - " + endTime.toString()
                }
            }

        snowboard_slopeStyle.collection("results")
            .orderBy("time", Query.Direction.ASCENDING)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    val emptyScoreText = "No results yet."
                    emptyScore_snowboard.text = emptyScoreText
                } else {
                    for (title in captions) {
                        val caption = TextView(this)
                        caption.text = title
                        caption.width = textWidth
                        caption.typeface = Typeface.DEFAULT_BOLD
                        caption.gravity = Gravity.CENTER
                        captionsLayoutSnowboard_luosto.addView(caption)
                    }
                    for ((index, doc) in documents.withIndex()) {
                        val position = index + 1
                        val name = doc.data.get("name")
                        val time = doc.data.get("time")
                        val sponsor = doc.data.get("sponsor")
                        val club = doc.data.get("club")
                        val athleteNumber = doc.data.get("number")

                        val scoreView = layoutInflater.inflate(R.layout.testerihorizontalresults, null)

                        scoreView.testeriPosition_textView.text = position.toString() + "."
                        scoreView.testeriPosition_textView.width = textWidth
                        scoreView.testeriPosition_textView.gravity = Gravity.CENTER

                        scoreView.testeriName_textView.text = name.toString()
                        scoreView.testeriName_textView.width = textWidth
                        scoreView.testeriName_textView.gravity = Gravity.CENTER

                        scoreView.testeriTime_textView.text = time.toString()
                        scoreView.testeriTime_textView.width = textWidth
                        scoreView.testeriTime_textView.gravity = Gravity.CENTER

                        scoreView.testeriSponsor_textView.text = sponsor.toString()
                        scoreView.testeriSponsor_textView.width = textWidth
                        scoreView.testeriSponsor_textView.gravity = Gravity.CENTER

                        scoreView.testeriClub_textView.text = club.toString()
                        scoreView.testeriClub_textView.width = textWidth
                        scoreView.testeriClub_textView.gravity = Gravity.CENTER

                        scoreView.testeriAthleteNumber_textView.text = athleteNumber.toString()
                        scoreView.testeriAthleteNumber_textView.width = textWidth
                        scoreView.testeriAthleteNumber_textView.gravity = Gravity.CENTER

                        listOfScores.addView(scoreView)
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Pate", "Error: $exception")
            }
    }

    private fun getScreenWidth(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        return displayMetrics.widthPixels
    }
}

