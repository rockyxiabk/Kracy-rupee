package com.great.cash.rupee.entity

import com.google.gson.annotations.SerializedName

class BaseResultArray<T> {
    var code = 0
    var msg: String? = null

    @SerializedName("data")
    var data: ListData<T>? = null
    var page: PageBean? = null
}
