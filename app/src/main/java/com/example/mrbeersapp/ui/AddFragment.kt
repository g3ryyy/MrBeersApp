package com.example.mrbeersapp.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mrbeersapp.R
import com.example.mrbeersapp.model.Beer
import com.example.mrbeersapp.viewmodels.BeerViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var  mBeerViewModel: BeerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mBeerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)

        view.add_btn.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val name = addName_et.text.toString()
        val taste = addTaste_et.text.toString()

        if (inputCheck(name, taste)){
            val beer = Beer(0, name, taste)
            mBeerViewModel.addBeer(beer)
            Toast.makeText(requireContext(),"added", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, taste: String):Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(taste))
    }
}
