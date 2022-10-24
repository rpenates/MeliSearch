package com.rpenates.melisearch.network.mla

import android.util.Log
import com.rpenates.melisearch.models.MlaItem
import com.rpenates.melisearch.models.MlaResponse
import com.rpenates.melisearch.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MlaService {

    val TAG = "MlaService"

    fun search(term: String, success: (results: List<MlaItem>) -> Unit, failure:() -> Unit ) {
        val mlaApi: MlaApiInterface = ApiClient.getClient().create(MlaApiInterface::class.java)
        val call: Call<MlaResponse> = mlaApi.searchQuery(term)
        call.enqueue(object : Callback<MlaResponse?> {
            override fun onResponse(call: Call<MlaResponse?>?, response: Response<MlaResponse?>) {
                Log.i(TAG, "Response code => " + response.code())
                Log.i (TAG, "Current items => ${response.body()!!.results!!.size}")

                response.body()!!.results.let {
                    if (it != null) {
                        success(it)
                    }
                }
            }

            override fun onFailure(call: Call<MlaResponse?>, t: Throwable?) {
                call.cancel()
                failure()
            }
        })
    }
}