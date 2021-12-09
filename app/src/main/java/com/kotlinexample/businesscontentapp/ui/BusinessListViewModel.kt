package com.kotlinexample.businesscontentapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kotlinexample.businesscontentapp.repository.BusinessRepository
import com.kotlinexample.businesscontentapp.rest.BusinessContent
import com.kotlinexample.businesscontentapp.utils.Resource

class BusinessListViewModel @ViewModelInject constructor(
    private val repository: BusinessRepository
) : ViewModel() {
    val businesses = repository.getBusinesses()
}