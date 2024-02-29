package com.redbus.postalcodeapp.model

// model classes

data class Place(
    var placeName: String,
    var adminName2: String, // City
    var adminName1: String, // State
    var countryCode: String,
    var lat: Double,
    var lng: Double)

data class PlaceResponse(
    var postalCodes: List<Place>
)