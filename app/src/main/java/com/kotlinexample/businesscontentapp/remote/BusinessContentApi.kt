package com.kotlinexample.businesscontentapp.remote

import com.kotlinexample.businesscontentapp.rest.BusinessContent
import com.kotlinexample.businesscontentapp.rest.BusinessListContent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BusinessContentApi {
    @GET("api/businesscontentapi")
    suspend fun getAllBusinesses(): Response<BusinessListContent>

    @GET("api/businesscontentapi/{id}")
    suspend fun getBusiness(@Path("id") id: Long): Response<BusinessContent>
}