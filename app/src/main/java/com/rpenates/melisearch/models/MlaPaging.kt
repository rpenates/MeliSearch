package com.rpenates.melisearch.models

import com.google.gson.annotations.SerializedName

class MlaPaging {

    @SerializedName("total")
    val total: Int? = null

    @SerializedName("primary_results")
    val primaryResults: Int? = null

    @SerializedName("offset")
    val offset: Int? = null

    @SerializedName("limit")
    val limit: Int? = null
}