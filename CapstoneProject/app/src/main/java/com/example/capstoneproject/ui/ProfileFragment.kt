package com.example.capstoneproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.capstoneproject.R
import com.example.capstoneproject.model.User
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private val viewModel: UserViewmodel by viewModels()

    private var currentUser = User()
    var OefeningenAantal=4

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSave.setOnClickListener{
            saveUser()
        }
        observeUser()
    }
   private fun observeUser() {
       viewModel.user.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                user  ->

           if (user != null){
               etVoornaam.setText(user.surName)
               etAchternaam.setText(user.lastName)
               etLeeftijd.setText(user.age.toString())
               etGewicht.setText(user.weight.toString())
               currentUser = user
           }

       })

        viewModel.error.observe(viewLifecycleOwner, androidx.lifecycle.Observer { message ->
           Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        })

      viewModel.success.observe(viewLifecycleOwner, androidx.lifecycle.Observer { success ->
            //"pop" the backstack, this means we destroy this    fragment and go back to the RemindersFragment
            findNavController().popBackStack()
       })
   }
    private fun saveUser() {
        val voornaam = etVoornaam.text.toString()
        val achternaam = etAchternaam.text.toString()
        val leeftijd = etLeeftijd.text.toString().toInt()
        val gewicht = etGewicht.text.toString().toInt()
        val aantal = OefeningenAantal

        val newUser = User(voornaam, achternaam, leeftijd, gewicht, aantal, 1)


        if (this.currentUser.id == null  ){
            viewModel.insertUser(newUser)
        }else {
            viewModel.updateUser(newUser)
        }

        findNavController().navigate(
            R.id.action_navigation_profile_to_navigation_home)

    }
}