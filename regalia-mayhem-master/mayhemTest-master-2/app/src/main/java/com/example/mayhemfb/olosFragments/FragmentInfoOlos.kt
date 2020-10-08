package com.example.mayhemfb.olosFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mayhemfb.R

/**
 * A simple [Fragment] subclass.
 */
class FragmentInfoOlos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_olos, container, false)
        }
    }

