package com.rpenates.melisearch.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rpenates.melisearch.models.MlaItem
import java.lang.reflect.Type


object DataUtils {

    val gson = Gson()
    var mlaType: Type = object : TypeToken<MlaItem?>() {}.type


    fun mlaSerialize(data: MlaItem): String {
        return  gson.toJson(data, mlaType)
    }

    fun mlaDeserialize(data: String) : MlaItem {
        return gson.fromJson(data, mlaType)
    }
}