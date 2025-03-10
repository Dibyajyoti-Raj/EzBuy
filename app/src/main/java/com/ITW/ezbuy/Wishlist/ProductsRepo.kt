package com.ITW.ezbuy.Wishlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIservice{
    @GET("products")
    suspend fun getProduct():List<Product>
}

object RetrofitClint{
    private const val BASE_URL = "https://fakestoreapi.com/"
    val apiService: APIservice by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIservice::class.java)
    }
}

class ProductRepo(private val apiService: APIservice) {
    suspend fun getProduct(): List<Product>{
        return apiService.getProduct()
    }
}

class ProductViewModel: ViewModel(){
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    private val repository = ProductRepo(RetrofitClint.apiService)

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val productList = repository.getProduct()
                _products.postValue(productList)
                println("API Data Called: $productList")
            } catch (e: Exception) {
                println("API Data Call: Error")
            }
        }
    }
}




























