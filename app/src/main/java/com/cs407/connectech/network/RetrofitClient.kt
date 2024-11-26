package com.cs407.connectech.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object RetrofitClient {
//    private const val BASE_URL = "https://api.connectech.com/"
//
//    val apiService: ApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//}
object RetrofitClient {
    private const val BASE_URL = "https://mock-api.com/" // Or any valid URL

    val apiService: ApiService by lazy {
        val mockInterceptor = MockInterceptor()

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(mockInterceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
