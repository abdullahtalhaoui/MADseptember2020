package com.example.capstoneproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.capstoneproject.R
import com.example.capstoneproject.model.User
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {
    private lateinit var user: User

    private val viewModel: UserViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        observeAddUserResult()
    }

    private fun observeAddUserResult() {
        viewModel.user.observe(viewLifecycleOwner, Observer { newUser ->
            if (newUser == null) {
                etOefeningenAantal.isEnabled = false
            } else {
                etOefeningenAantal.append(newUser.amountExercises.toString())
            }
        })
    }

    private fun initViews() {
        checkBox.setOnClickListener{
        onCheckboxClicked(checkBox)}
        checkBox2.setOnClickListener{
            onCheckboxClicked(checkBox2)}
    }



    private fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox -> {
                    if (checked) {
                        checkBox2.setChecked(false);
                    } else {
                        checkBox.setChecked(false);
                    }

                }
                R.id.checkBox2 -> {
                    if (checked) {
                        checkBox.setChecked(false);
                    } else {
                        checkBox2.setChecked(false);
                    }
                }
            }
        }

    }



}