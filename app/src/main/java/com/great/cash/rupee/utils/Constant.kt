package com.great.cash.rupee.utils

import com.great.cash.rupee.BuildConfig

object Constant {
//    var debug = BuildConfig.DEBUG
    var debug = false

    const val CHANNEL_VALUE = "google"
    const val APP_NAME = "100017"
    const val APP_VERSION = BuildConfig.VERSION_NAME
    const val DATA = "data"

    var SYC_RELEASE = "https://sdk.greaterupee.in"
//    var SYC_BETA = "http://test-sdk.yinlas.com"
    var SYC_BETA = ""
    var SYC_UPDATEURL = if (debug) SYC_BETA else SYC_RELEASE

    var AF_KEY = "rvGK4JG5onmKBxZge3RNBY"

    val APP_ID = "FiWallet"
    var APP_KEY_TEST = "769c8ln2ba4z04JS8BUVUGB87IkU2R0j"
    var APP_KEY_PROD = "gqSecB22MnTej43V33o51OGZ7J2VaGTz"
    var APP_KEY = if (debug) APP_KEY_TEST else APP_KEY_PROD
    const val BUNDLE_DATA = "bundle_data"
    const val BORROW_ID = "borrowId"
    const val TITLE = "title"
    const val URL = "url"
}
