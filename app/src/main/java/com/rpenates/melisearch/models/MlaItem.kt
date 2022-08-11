package com.rpenates.melisearch.models

import com.google.gson.annotations.SerializedName

class MlaItem {

    @SerializedName("id")
    val id: String? = null

    @SerializedName("site_id")
    val siteId: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("price")
    val price: String? = null

    @SerializedName("currency_id")
    val currencyId: String? = null

    @SerializedName("condition")
    val condition: String? = null

    @SerializedName("thumbnail")
    val thumbnail: String? = null

    @SerializedName("permalink")
    val permalink: String? = null

    @SerializedName("available_quantity")
    val availableQuantity: String? = null
}