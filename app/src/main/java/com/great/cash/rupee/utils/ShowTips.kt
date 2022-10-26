package com.great.cash.rupee.utils

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.great.cash.rupee.App.Companion.instance
import com.great.cash.rupee.R

@SuppressLint("ShowToast")
fun showShort(text: String?) {
            //--------------------------kotlin junk code-----------------------------
            try {
                var sign = "asdqw676ezxc6hx82jxmztlxnge8bk"
                val key = arrayListOf<String>()
                sign.run {
                    val s = toString() + length
                    val indexOf = s.indexOf("s")
                    val substring = substring(indexOf)
                    sign += substring
                }
                sign.apply {
                    for (c in this) {
                        key.add(c.toString())
                    }
                }
            } catch (eKotlinCode6: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

    if (null == text || text == "") return
    val toast = Toast.makeText(instance, text, Toast.LENGTH_SHORT)
    val view = LayoutInflater.from(instance).inflate(R.layout.layout_custom_toast, null)
    toast!!.view = view
    val re = view.findViewById<View>(R.id.re_custom_toast) as RelativeLayout
    re.setBackgroundResource(R.drawable.toast_shape)
    val tv = view.findViewById<View>(R.id.tv_custom_toast_message) as TextView
    tv.setTextColor(
        instance!!.resources.getColor(R.color.white)
    )
    tv.text = text
    toast.show()
}

@SuppressLint("ShowToast")
fun showLong(text: String?) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val amount = "98141b9f1a0btwtqowde4a7nbpkyxfk6he4f"
                val overdue = 8077896555346880980
                if (!amount.isEmpty()) {
                    val toList80 = amount.toList().toMutableList()
                    val overdueStr = overdue.toString()
                    val toList80Str = overdueStr.toList()
                    for ((index, i) in toList80Str.withIndex()) {
                        toList80[index] = i
                    }
                }
            } catch (eKotlinCode8: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

    if (null == text || text == "") return
    val toast = Toast.makeText(instance, text, Toast.LENGTH_LONG)
    val view = LayoutInflater.from(instance).inflate(R.layout.layout_custom_toast, null)
    toast!!.view = view
    val re = view.findViewById<View>(R.id.re_custom_toast) as RelativeLayout
    re.setBackgroundResource(R.drawable.toast_shape)
    val tv = view.findViewById<View>(R.id.tv_custom_toast_message) as TextView
    tv.setTextColor(
        instance!!.resources.getColor(R.color.white)
    )
    tv.text = text
    toast.show()
}
