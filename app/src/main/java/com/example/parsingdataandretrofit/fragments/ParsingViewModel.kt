package com.example.parsingdataandretrofit.fragments

import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parsingdataandretrofit.molel.Product
import com.example.parsingdataandretrofit.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ParsingViewModel : ViewModel() {

    private val _response = MutableLiveData<Product>()
    val response : LiveData<Product> = _response

    fun getDataFromApi() {
        val apiData = RetrofitInstance.retrofitBuilder
        viewModelScope.launch(Dispatchers.IO) {
            val response = apiData.getData()
            if (response.isSuccessful) {
                _response.value = response.body()
            }
        }
    }
}