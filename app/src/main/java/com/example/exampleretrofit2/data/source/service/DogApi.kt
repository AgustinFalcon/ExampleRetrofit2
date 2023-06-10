package com.example.exampleretrofit2.data.source.service

import com.example.exampleretrofit2.data.source.responses.DogResponse
import com.example.exampleretrofit2.data.source.responses.RandomResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface DogApi {

    @GET
    fun getDogsByBreed(@Url dog: String): Call<DogResponse>

    @GET("images/random")
    fun getDogsByBreedRandom(): Call<RandomResponse>

}