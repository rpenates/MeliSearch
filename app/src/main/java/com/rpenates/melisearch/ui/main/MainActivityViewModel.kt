package com.rpenates.melisearch.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rpenates.melisearch.models.MlaItem
import com.rpenates.melisearch.network.mla.MlaService

class MainActivityViewModel() : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val hasError = MutableLiveData<String>()
    val resultList = MutableLiveData<List<MlaItem>>()

    val service: MlaService = MlaService()

    fun makeSearch(term: String) {
        isLoading.value = true
        service.search(term,
            success = { results ->
                resultList.value = results
                isLoading.value = false

            }, failure = {
                hasError.value = "Ha ocurrido un error de red"
                isLoading.value = false
            })
    }


}