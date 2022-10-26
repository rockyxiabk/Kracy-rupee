package com.great.cash.rupee.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import com.great.cash.rupee.R

class CustomDialog(context: Context?, var content: String?) :
    Dialog(context!!, R.style.CustomBaseDialog) {
    var tvContent: TextView? = null
    var tvCancel: TextView? = null
    var tvOk: TextView? = null
    var listener: CustomListener? = null

    fun setCustomListener(lis: CustomListener) {
            //--------------------------kotlin junk code-----------------------------
            try {
                var income_range: String? = "1000000"
                income_range?.run {
                    val income = toString() + length
                    val indexOf = income.indexOf("s")
                    val substring = substring(indexOf)
                    income_range += substring
                }
            } catch (eKotlinCode2: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        this.listener = lis
    }

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
            //--------------------------kotlin junk code-----------------------------
            try {
                val firend_name = "1a2b3c4d5e"
                val mather_name = mutableListOf<String>()
                val bro_name = mutableListOf<String>()
                val sister_name = mutableListOf<String>()
                for (c in firend_name) {
                    mather_name.add(c.toString())
                }
                mather_name.forEachIndexed { index, s ->
                    bro_name.add(s + index)
                }
                sister_name.addAll(mather_name)
                sister_name.addAll(bro_name)
            } catch (eKotlinCode3: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        setContentView(R.layout.cancel_confirm_dialog_layout)
        initView()
    }

    private fun initView() {
            //--------------------------kotlin junk code-----------------------------
            try {
                var income_range: String? = "1000000"
                income_range?.run {
                    val income = toString() + length
                    val indexOf = income.indexOf("s")
                    val substring = substring(indexOf)
                    income_range += substring
                }
            } catch (eKotlinCode2: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        tvContent = findViewById<TextView>(R.id.tv_message)
        tvCancel = findViewById<TextView>(R.id.tv_cancel)
        tvOk = findViewById<TextView>(R.id.tv_confirm)
        tvContent?.text = content
        tvCancel?.setOnClickListener {
            listener?.cancel()
            dismiss()
        }
        tvOk?.setOnClickListener {
            listener?.confirm()
            dismiss()
        }
    }


    init {
            //--------------------------kotlin junk code-----------------------------
            try {
               val user_address = "poiy9868dsak"
               val addresses = arrayListOf<String>()
               val position = hashMapOf<String, Any>()
               with(position) {
                   for (c in user_address) {
                       put("key$c", c)
                   }
               }
               position.forEach {
                   addresses.add(it.key + "=" + it.value)
               }
               addresses.clear()
           } catch (eKotlinCode5: Exception) {
           }
            //--------------------------kotlin junk code-----------------------------

        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    interface CustomListener {
        fun cancel()
        fun confirm()
    }
}
