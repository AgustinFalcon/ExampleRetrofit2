package com.example.exampleretrofit2.ui

import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampleretrofit2.databinding.FragmentDogsBinding
import com.example.exampleretrofit2.ui.adapter.DogAdapter
import com.example.exampleretrofit2.ui.viewmodels.DogViewModel


class DogsFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentDogsBinding
    private val dogViewModel by viewModels<DogViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDogsBinding.inflate(inflater, container, false)

        // Hacemos uso de la interfaz del search view
        binding.searchBar.setOnQueryTextListener(this)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())


        // Observamos el cambio de los datos
        dogViewModel.dogs.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                binding.recyclerview.adapter = DogAdapter(it)
            }
        }


        return binding.root
    }

    // Cuando hace click en buscar
    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrBlank()) {
            dogViewModel.getDogsByBreed(query)
        }
        return true
    }

    // Cuando va cambiando el texto
    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }


}