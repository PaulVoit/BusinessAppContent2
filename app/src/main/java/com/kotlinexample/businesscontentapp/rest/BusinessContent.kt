package com.kotlinexample.businesscontentapp.rest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "businesses")
data class BusinessContent(
        @PrimaryKey
        val id: Long,
        val rating: Int,
        val price: String,
        val phone: String,
        val is_closed: Boolean,
        val review_count: Int,
        val name: String,
        val url: String,
        val image_url: String
)


/*
@SerializedName("rating")
val rating: Int,
@SerializedName("price")
val price: String,
@SerializedName("phone")
val phone: String,
@SerializedName("is_closed")
val isClosed: Boolean,
@SerializedName("review_count")
val reviewCount: Int,
@SerializedName("name")
val name: String,
@SerializedName("url")
val url: String,
@SerializedName("coordinates")
val coordinates: Coordinates,
@SerializedName("image_url")
val imageUrl: String,
@SerializedName("location")
val location: Location
)

data class Coordinates(
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
)

data class Location(
    @SerializedName("city") val city: String,
    @SerializedName("country") val country: String
    */


