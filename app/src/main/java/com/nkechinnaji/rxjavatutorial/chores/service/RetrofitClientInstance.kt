package com.nkechinnaji.rxjavatutorial.chores.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Nkechi Nnaji on 4/22/21.
 * Description:
 */
class RetrofitClientInstance {

    companion object{

        //Create Logger
        var logger: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        //Create Http client
        var okhttp: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logger)

        private fun getRetrofit(Url: String): Retrofit {
            return Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory( GsonConverterFactory.create())
                .baseUrl(Url)
                .client(okhttp.build())
                .build()
        }

        fun getApiData(): Retrofit {
            val retrofitApi = getRetrofit("http://10.0.2.2:3000/")
            return retrofitApi
        }

        fun callApi(): ApiService{
            val retrofitCall = getApiData()
            return retrofitCall.create(ApiService::class.java)
        }
    }
}