package com.great.cash.rupee.entity

import com.google.gson.annotations.SerializedName

class ListData<T> {
    @SerializedName("list")
    var list: MutableList<T>? = null
}
