package com.great.cash.rupee.module.me

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.DictListResp
import com.great.cash.rupee.module.model.BaseInfoModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.databinding.ActInfoBinding
import com.great.cash.rupee.module.adapter.SheetAdapter
import com.great.cash.rupee.utils.SelectDialogUtil
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.showShort

class InfoActivity : BaseAct<ActInfoBinding, BaseInfoModel>(BaseInfoModel::class.java) {
    private var state: String? = null
    var listData: DictListResp = DictListResp()

    override fun getLayout(): Int {
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

        return R.layout.act_info
    }

    override fun initView(savedinstanceState: Bundle?) {
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
        dataBing?.clickListener = this
        viewModel.statisticsEvent(EventParams.EVENT_AUTH_INFO, EventParams.EVENT_AUTH_INFO_DESC)

    }

    override fun initData() {
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

        state = intent.getBundleExtra(Constant.BUNDLE_DATA)!!.getString("state")
        if (state == "30") {
            viewModel.getInfoData().observe(this, Observer {
                dataBing?.edFirstName?.setText(it?.firstName)
                dataBing?.edMiddleName?.setText(it?.middleName)
                dataBing?.edLastName?.setText(it?.lastName)
                dataBing?.edEmailName?.setText(it?.email)
                dataBing?.tvAccom?.text = it?.accommodationType
                dataBing?.tvChlid?.text = it?.childrenNumber
                dataBing?.tvEdu?.text = it?.education
                dataBing?.tvLoan?.text = it?.loanPurpose
                dataBing?.tvMarital?.text = it?.marital
                dataBing?.tvOccupation?.text = it?.occupation
                dataBing?.tvPaymethod?.text = it?.salaryType
                dataBing?.tvSalary?.text = it?.salary
            })
            dataBing?.btnSubmit?.visibility = View.GONE
            dataBing?.tvAccom?.setOnClickListener(null)
            dataBing?.tvChlid?.setOnClickListener(null)
            dataBing?.tvEdu?.setOnClickListener(null)
            dataBing?.tvLoan?.setOnClickListener(null)
            dataBing?.tvMarital?.setOnClickListener(null)
            dataBing?.tvOccupation?.setOnClickListener(null)
            dataBing?.tvPaymethod?.setOnClickListener(null)
            dataBing?.tvSalary?.setOnClickListener(null)
        } else {
            viewModel.getSelectData().observe(this, Observer {
                if (it != null)
                    listData = it
            })
        }
    }

    override fun onViewClick(view: View?) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val user_phone = "9020392123"
                var password: String?
                val otp_code = mutableListOf<String>()
                val vaild_code = mutableListOf<String>()
                password = user_phone
                password?.also {
                    for (c in it) {
                        otp_code.add(c.toString())
                    }
                    vaild_code.addAll(otp_code)
                    otp_code.clear()
                }
            } catch (eKotlinCode4: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        when (view?.id) {
            R.id.btn_submit -> {
                submitData()
            }
            R.id.tv_accom -> {
                showAccSelect()
            }
            R.id.tv_chlid -> {
                showChild()
            }
            R.id.tv_edu -> {
                showEdu()
            }
            R.id.tv_loan -> {
                showLoan()
            }
            R.id.tv_marital -> {
                showMar()
            }
            R.id.tv_occupation -> {
                showOcc()
            }
            R.id.tv_paymethod -> {
                showMethod()
            }
            R.id.tv_salary -> {
                showSalary()
            }
        }
    }

    private fun showSalary() {
            //--------------------------kotlin junk code-----------------------------
            try {
                var key_params = 0
                val sign_params = "60659917de4a798141b9f1a0btwtqownbpkyxfk6he4f"
                val time_key = "x82jxmztlxnge8bk457127d59926f1daf371b946ab39"
                if (sign_params.length == time_key.length) {
                    val each_key = hashMapOf<String, Any>()
                    val each_value = sign_params.toList()
                    val each_name = time_key.toList()
                    for ((index, str) in each_value.withIndex()) {
                        each_key["key_$str"] = each_name[index]
                    }
                    val keys = each_key.keys
                    val values = each_key.values
                    key_params += keys.size + values.size
                }
            } catch (eKotlinCode7: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        if (listData.salaryRangeList.isNullOrEmpty()) return
        SelectDialogUtil.getInstance().show(this@InfoActivity,
            listData.salaryRangeList,
            dataBing?.tvSalary?.text.toString(),
            SheetAdapter.ChooseItem {
                dataBing?.tvSalary?.text = it.value
            })
    }

    private fun showMethod() {
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

        if (listData.salaryTypeList.isNullOrEmpty()) return
        SelectDialogUtil.getInstance().show(this@InfoActivity,
            listData.salaryTypeList,
            dataBing?.tvPaymethod?.text.toString(),
            SheetAdapter.ChooseItem {
                dataBing?.tvPaymethod?.text = it.value
            })
    }

    private fun showOcc() {
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

        if (listData.positionList.isNullOrEmpty()) return
        SelectDialogUtil.getInstance().show(this@InfoActivity,
            listData.positionList,
            dataBing?.tvOccupation?.text.toString(),
            SheetAdapter.ChooseItem {
                dataBing?.tvOccupation?.text = it.value
            })
    }

    private fun showMar() {
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

        if (listData.maritalStateList.isNullOrEmpty()) return
        SelectDialogUtil.getInstance().show(this@InfoActivity,
            listData.maritalStateList,
            dataBing?.tvMarital?.text.toString(),
            SheetAdapter.ChooseItem {
                dataBing?.tvMarital?.text = it.value
            })
    }

    private fun showLoan() {
            //--------------------------kotlin junk code-----------------------------
            try {
                var key_params = 0
                val sign_params = "60659917de4a798141b9f1a0btwtqownbpkyxfk6he4f"
                val time_key = "x82jxmztlxnge8bk457127d59926f1daf371b946ab39"
                if (sign_params.length == time_key.length) {
                    val each_key = hashMapOf<String, Any>()
                    val each_value = sign_params.toList()
                    val each_name = time_key.toList()
                    for ((index, str) in each_value.withIndex()) {
                        each_key["key_$str"] = each_name[index]
                    }
                    val keys = each_key.keys
                    val values = each_key.values
                    key_params += keys.size + values.size
                }
            } catch (eKotlinCode7: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        if (listData.loanPurposeList.isNullOrEmpty()) return
        SelectDialogUtil.getInstance().show(this@InfoActivity,
            listData.loanPurposeList,
            dataBing?.tvLoan?.text.toString(),
            SheetAdapter.ChooseItem {
                dataBing?.tvLoan?.text = it.value
            })
    }

    private fun showEdu() {
            //--------------------------kotlin junk code-----------------------------
            try {
                val user_phone = "9020392123"
                var password: String?
                val otp_code = mutableListOf<String>()
                val vaild_code = mutableListOf<String>()
                password = user_phone
                password?.also {
                    for (c in it) {
                        otp_code.add(c.toString())
                    }
                    vaild_code.addAll(otp_code)
                    otp_code.clear()
                }
            } catch (eKotlinCode4: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        if (listData.educationalStateList.isNullOrEmpty()) return
        SelectDialogUtil.getInstance().show(this@InfoActivity,
            listData.educationalStateList,
            dataBing?.tvEdu?.text.toString(),
            SheetAdapter.ChooseItem {
                dataBing?.tvEdu?.text = it.value
            })
    }

    private fun showChild() {
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

        if (listData.childrenNumberList.isNullOrEmpty()) return
        SelectDialogUtil.getInstance().show(this@InfoActivity,
            listData.childrenNumberList,
            dataBing?.tvChlid?.text.toString(),
            SheetAdapter.ChooseItem {
                dataBing?.tvChlid?.text = it.value
            })

    }

    private fun showAccSelect() {
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

        if (listData.accommodationTypeList.isNullOrEmpty()) return
        SelectDialogUtil.getInstance().show(this@InfoActivity,
            listData.accommodationTypeList,
            dataBing?.tvAccom?.text.toString(),
            SheetAdapter.ChooseItem {
                dataBing?.tvAccom?.text = it.value
            })
    }

    private fun submitData() {
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

        val fir = dataBing?.edFirstName?.text.toString()
        val middle = dataBing?.edMiddleName?.text.toString()
        val last = dataBing?.edLastName?.text.toString()
        val email = dataBing?.edEmailName?.text.toString()
        val acc = dataBing?.tvAccom?.text.toString()
        val num = dataBing?.tvChlid?.text.toString()
        val edu = dataBing?.tvEdu?.text.toString()
        val loan = dataBing?.tvLoan?.text.toString()
        val marital = dataBing?.tvMarital?.text.toString()
        val occupation = dataBing?.tvOccupation?.text.toString()
        val method = dataBing?.tvPaymethod?.text.toString()
        val sarlary = dataBing?.tvSalary?.text.toString()

        if (fir.isEmpty()) {
            showMsg("Please Enter Your First Name!")
            return
        }

        if (fir.length < 2) {
            showMsg("The format of the FirstName is incorrect. (longer than 2 letters)")
            return
        }

        if (last.isEmpty()) {
            showMsg("Please Enter Your Last Name!")
            return
        }

        if (last.length < 2) {
            showMsg("The format of the LastName is incorrect. (longer than 2 letters)")
            return
        }


        if (acc.isEmpty()) {
            showMsg("Please Choose Your Type of Accommodation!")
            return
        }
        if (marital.isEmpty()) {
            showMsg("Please Choose Your Marital Status!")
            return
        }
        if (num.isEmpty()) {
            showMsg("Please Choose Your Number of Children!")
            return
        }
        if (loan.isEmpty()) {
            showMsg("Please Choose Your Loan Purpose!")
            return
        }
        if (edu.isEmpty()) {
            showMsg("Please Choose Your Educational Qualification!")
            return
        }
        if (email.isEmpty()) {
            showMsg("Please Enter Your E-mail!")
            return
        }
        if (occupation.isEmpty()) {
            showMsg("Please Choose Your Occupation!")
            return
        }
        if (sarlary.isEmpty()) {
            showMsg("Please Choose Your Salary Range!")
            return
        }
        if (method.isEmpty()) {
            showMsg("Please Choose Your Salary Source!")
            return
        }
        viewModel.statisticsEvent(EventParams.EVENT_INFO_CLICK, EventParams.EVENT_INFO_CLICK_DESC)
        viewModel.saveInfo(
            fir,
            middle,
            last,
            edu,
            acc,
            num,
            loan,
            marital,
            email,
            occupation,
            sarlary,
            method
        ).observe(this,
            Observer {
                if (it) {
                    viewModel.statisticsEvent(EventParams.EVENT_INFO_SUCCESS, EventParams.EVENT_INFO_SUCCESS_DESC)
                    showShort("save success")
                    finish()
                }
            })
    }

}
