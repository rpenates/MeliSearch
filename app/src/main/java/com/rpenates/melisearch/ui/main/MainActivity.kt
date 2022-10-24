package com.rpenates.melisearch.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.rpenates.melisearch.R
import com.rpenates.melisearch.models.MlaItem
import com.rpenates.melisearch.models.MlaResponse
import com.rpenates.melisearch.network.ApiClient.getClient
import com.rpenates.melisearch.network.mla.MlaApiInterface
import com.rpenates.melisearch.ui.adapters.ResultItemAdapter
import com.rpenates.melisearch.ui.detail.DetailActivity
import com.rpenates.melisearch.utils.DataUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val viewModel: MainActivityViewModel by viewModels()
    private val listAdapter = ResultItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val searchBtn = findViewById<ImageButton>(R.id.search_action_btn)
        val searchInput = findViewById<EditText>(R.id.search_input_text)
        val progressIndicator = findViewById<ProgressBar>(R.id.progress_indicator)
        val linkRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        viewModel.isLoading.observe(this) {
            if (it == true) {
                progressIndicator.visibility = View.VISIBLE
            } else {
                progressIndicator.visibility = View.GONE
            }
        }

        viewModel.resultList.observe(this) { list ->
            linkRecyclerView.layoutManager = LinearLayoutManager(this)
            listAdapter.itemList = list as ArrayList<MlaItem>
            linkRecyclerView.adapter = listAdapter
            listAdapter.notifyDataSetChanged()
        }

        viewModel.hasError.observe(this) {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }

        searchBtn.setOnClickListener{
            val urlText = searchInput.text.toString()
            performSearch(urlText)
            searchInput.text.clear()
        }

        listAdapter.onItemClick = {
            val detailIntent = Intent(this, DetailActivity::class.java)

            val mlaString = DataUtils.mlaSerialize(it)

            detailIntent.putExtra("mlaitem", mlaString)
            startActivity(detailIntent)
        }
    }

    fun performSearch(term: String) {
        if (term.isNullOrEmpty()) {
            Toast.makeText(this, "El campo no debe estar vacio", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.makeSearch(term)
        }
    }

}