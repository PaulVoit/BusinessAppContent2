package com.kotlinexample.businesscontentapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinexample.businesscontentapp.R
import com.kotlinexample.businesscontentapp.adapters.BusinessListAdapter
import com.kotlinexample.businesscontentapp.databinding.BusinessListBinding
import com.kotlinexample.businesscontentapp.ui.BusinessListViewModel
import com.kotlinexample.businesscontentapp.utils.Resource
import com.kotlinexample.businesscontentapp.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class BusinessListFragment : Fragment(), BusinessListAdapter.BusinessContentItemListener {

    private var binding: BusinessListBinding by autoCleared()
    private val viewModel: BusinessListViewModel by viewModels()
     private lateinit var adapter: BusinessListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BusinessListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = BusinessListAdapter(this)
        binding.businesslist.layoutManager = LinearLayoutManager(requireContext())
        binding.businesslist.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.businesses.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickedBusiness(characterId: Long) {
        findNavController().navigate(
            R.id.action_list_to_itemInfoFragment,
            bundleOf("id" to characterId)
        )
    }
}