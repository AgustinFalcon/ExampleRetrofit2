package com.example.exampleretrofit2.data.source.responses

import com.google.gson.annotations.SerializedName


data class DogResponse(
    @SerializedName("message")// parseo de la variable del json response
    val dogsImages: List<String>,
    val status: String,
)