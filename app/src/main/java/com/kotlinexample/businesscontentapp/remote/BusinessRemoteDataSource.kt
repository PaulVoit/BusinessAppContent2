package com.kotlinexample.businesscontentapp.remote

import javax.inject.Inject

class BusinessRemoteDataSource @Inject constructor(
    private val businessContentApi: BusinessContentApi
) : BaseDataSource() {

    suspend fun getBusinesses() = getResult { businessContentApi.getAllBusinesses() }
    suspend fun getBusiness(id: Long) = getResult { businessContentApi.getBusiness(id) }
}
