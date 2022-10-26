package com.great.cash.rupee.entity

import com.google.gson.annotations.SerializedName

class BaseResult<T> {
    var code = 0
    var msg: String? = null
    var downloadUrl: String? = null

    @SerializedName("data")
    var data: T? = null
}
