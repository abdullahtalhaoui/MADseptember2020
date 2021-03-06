package com.example.capstoneproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.capstoneproject.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivOefeningen.setOnClickListener{
            findNavController().navigate(
                R.id.action_navigation_home_to_exercisesFragment)
        }

        ivInstellingen.setOnClickListener{
            findNavController().navigate(
                R.id.action_navigation_home_to_navigation_settings)
        }

        ivProfiel.setOnClickListener{
            findNavController().navigate(
                R.id.action_navigation_home_to_navigation_profile)
        }
    }
}