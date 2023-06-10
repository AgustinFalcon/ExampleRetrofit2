package com.example.exampleretrofit2.data.source.repository

import com.example.exampleretrofit2.data.source.responses.DogResponse
import com.example.exampleretrofit2.data.source.service.DogApi
import com.example.exampleretrofit2.data.source.service.RetrofitService
import retrofit2.Call


class Repository {

    private val retrofit: DogApi = RetrofitService.getInstance()


    fun getDogByBreed(breed: String): Call<DogResponse> {
        return retrofit.getDogsByBreed("$breed/images")
    }


}