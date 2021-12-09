package com.kotlinexample.businesscontentapp.repository

import com.kotlinexample.businesscontentapp.database.BusinessContentDao
import com.kotlinexample.businesscontentapp.remote.BusinessRemoteDataSource
import com.kotlinexample.businesscontentapp.rest.BusinessContent
import com.kotlinexample.businesscontentapp.utils.performGetOperation
import javax.inject.Inject

class BusinessRepository @Inject constructor(
    private val remoteDataSource: BusinessRemoteDataSource,
    private val localDataSource: BusinessContentDao
) {

    fun getBusiness(id: Long) = performGetOperation(
        databaseQuery = { localDataSource.getBusiness(id) },
        networkCall = { remoteDataSource.getBusiness(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getBusinesses() = performGetOperation(
        databaseQuery = { localDataSource.getAllBusinesses() },
        networkCall = { remoteDataSource.getBusinesses() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )

    fun updateBusiness(business: BusinessContent){
       localDataSource.updateBusiness(business)
    }
}


