package com.kotlinexample.businesscontentapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.kotlinexample.businesscontentapp.utils.Resource
import com.kotlinexample.businesscontentapp.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
/*
@AndroidEntryPoint
class ItemInfoFragment : Fragment() {

    private var binding: IteminfoFragmentBinding by autoCleared()
    private val viewModel: IteminfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = IteminfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.character.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindCharacter(it.data!!)
                    binding.progressBar.visibility = View.GONE
                    binding.characterCl.visibility = View.VISIBLE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.characterCl.visibility = View.GONE
                }
            }
        })
    }

    private fun bindBusiness(character: BusinessC) {
        binding.name.text = character.name
        binding.species.text = character.species
        binding.status.text = character.status
        binding.gender.text = character.gender
        Glide.with(binding.root)
            .load(character.image)
            .transform(CircleCrop())
            .into(binding.image)
    }
}

 */