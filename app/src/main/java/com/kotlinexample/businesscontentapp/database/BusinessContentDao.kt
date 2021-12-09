package com.kotlinexample.businesscontentapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kotlinexample.businesscontentapp.rest.BusinessContent

@Dao
interface BusinessContentDao {
    @Query("SELECT * FROM businesses")
    fun getAllBusinesses(): LiveData<List<BusinessContent>>

    @Query("SELECT * FROM businesses WHERE id = :id")
    fun getBusiness(id: Long): LiveData<BusinessContent>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(businesses: List<BusinessContent>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(business: BusinessContent)

    @Update
    fun updateBusiness(business: BusinessContent)
}