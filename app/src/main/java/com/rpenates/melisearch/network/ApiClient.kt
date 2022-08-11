package com.rpenates.melisearch.network

import com.rpenates.melisearch.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getClient(): Retrofit {
        val interceptor = HttpLoggingInterceptor()

        // Request logging stuff
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.api_url + BuildConfig.site_id + "/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    }
}