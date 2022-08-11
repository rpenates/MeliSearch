package com.rpenates.melisearch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rpenates.melisearch.models.MlaResponse
import com.rpenates.melisearch.network.ApiClient.getClient
import com.rpenates.melisearch.network.MlaApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testRequest()
    }

    private fun testRequest() {
        val mlaApi: MlaApiInterface = getClient().create(MlaApiInterface::class.java)
        val call: Call<MlaResponse> = mlaApi.searchQuery("nokia")
        call.enqueue(object : Callback<MlaResponse?> {
            override fun onResponse(call: Call<MlaResponse?>?, response: Response<MlaResponse?>) {
                Log.i(TAG, "Response code => " + response.code())
                Log.i (TAG, "Current items => ${response.body()!!.results!!.size}")
            }

            override fun onFailure(call: Call<MlaResponse?>, t: Throwable?) {
                call.cancel()
            }
        })
    }
}