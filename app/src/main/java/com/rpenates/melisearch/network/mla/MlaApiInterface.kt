package com.rpenates.melisearch.network.mla

import com.rpenates.melisearch.models.MlaResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MlaApiInterface {

    @GET("search")
    fun searchQuery(
        @Query("q") searchQuery: String
    ) : Call<MlaResponse>
}