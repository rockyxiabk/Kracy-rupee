package com.great.cash.rupee.module.me

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.great.cash.rupee.R
import com.great.cash.rupee.module.model.CardModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.databinding.ActNewCardBinding

class NewCardActivity : BaseAct<ActNewCardBinding, CardModel>(CardModel::class.java) {
    override fun getLayout(): Int {
        //--------------------------kotlin junk code-----------------------------
        try {
            val nameList = arrayListOf<String>()
            val userName = arrayListOf<String>()
            userName.add("userName_code0")
            userName.add("userName_code1")
            userName.add("userName_code2")
            userName.add("userName_code3")
            userName.add("userName_code4")
            userName.add("userName_code5")
            nameList.addAll(userName)
        } catch (eKotlinCode0: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

        return R.layout.act_new_card
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing!!.clickListener = this
        viewModel.statisticsEvent(
            EventParams.EVENT_AUTH_BANK,
            EventParams.EVENT_AUTH_BANK_DESC
        )
    }


    override fun onViewClick(view: View?) {
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

        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.tv_ifc -> {
                var intent = Intent(this, IfacActivity::class.java)
                startActivityForResult(intent, 2)
            }
            R.id.btn_submit -> {
                submitCard()
            }
        }
    }

    private fun submitCard() {
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

        val code = dataBing?.edIfsc?.text.toString().trim()
        val no1 = dataBing?.edAccount?.text.toString().trim()
        val no2 = dataBing?.edReAccount?.text.toString().trim()
        if (code.isNullOrEmpty()) {
            showMsg("please select or enter IFSC code")
            return
        }
        if (no1.isNullOrEmpty() || no2.isNullOrEmpty()) {
            showMsg("please enter or confirm bank account")
            return
        }

        if (!no1.equals(no2)) {
            showMsg("please enter same bank account")
            return
        }
        showDialog()
        viewModel.statisticsEvent(EventParams.EVENT_BANK_CLICK, EventParams.EVENT_BANK_CLICK_DESC)
        viewModel.saveBank(code, no1).observe(this, Observer {
            dismissDialog()
            if (it) {
                viewModel.statisticsEvent(EventParams.EVENT_BANK_success, EventParams.EVENT_BANK_success_DESC)
                showMsg("save success")
                finish()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //--------------------------kotlin junk code-----------------------------
        try {
            var name = "asd"
            name.indexOf("a").takeIf { it >= 0 }?.let {
                name.plus("qwe")
            }
            name.indexOf("d")
                    .takeUnless {
                        it < 0
                    }
                    ?.let {
                        val length = name.length
                        name += length
                    }
        } catch (eKotlinCode1: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

        if (resultCode == Activity.RESULT_OK && requestCode == 2) {
            val code = data?.getStringExtra("code")
            dataBing?.edIfsc?.setText(code)
        }
    }

    override fun initData() {
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

    }
}
