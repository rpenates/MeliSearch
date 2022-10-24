package com.rpenates.melisearch.models

import com.google.gson.annotations.SerializedName

class MlaResponse {

    @SerializedName("site_id")
    val siteId: String? = null

    @SerializedName("query")
    val query: String? = null

    @SerializedName("paging")
    val paging: MlaPaging? = null

    @SerializedName("results")
    val results : List<MlaItem>? = null




}