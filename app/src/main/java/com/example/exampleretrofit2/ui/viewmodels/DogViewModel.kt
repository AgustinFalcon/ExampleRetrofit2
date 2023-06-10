package com.example.exampleretrofit2.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exampleretrofit2.data.source.repository.Repository
import com.example.exampleretrofit2.data.source.responses.DogResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DogViewModel: ViewModel() {

    private val repository = Repository()

    private val _dogs = MutableLiveData<List<String>>()
    val dogs: LiveData<List<String>> get() = _dogs

    var message: String? = null



    fun getDogsByBreed(breed: String) {

        // Llamado al servicio (aca se podria lanzar un hilo y hacerlo en background)
        repository.getDogByBreed(breed).enqueue(object : Callback<DogResponse> {

            // Respuesta del servicio
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {

                if(response.isSuccessful && response.body() != null) {
                    _dogs.value = response.body()!!.dogsImages // guardo los datos
                }
            }

            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                message = t.message
            }

        })
    }

}