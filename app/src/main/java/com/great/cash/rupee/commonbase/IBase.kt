package com.great.cash.rupee.commonbase

import android.os.Bundle

interface IBase {
    fun showMsg(msg: String?)
    fun showDialog()
    fun dismissDialog()
    fun toOtherActivity(cls: Class<*>?)
    fun toOtherActivity(cls: Class<*>?, bundle: Bundle?)
    fun toOtherActivityAndFinish(cls: Class<*>?, bundle: Bundle?)
    fun toOtherActivityAndFinishCurrent(cls: Class<*>?)
    fun toOtherActivityAndFinishCurrent(cls: Class<*>?, delayTime: Long)
}
