package com.great.cash.rupee.module.home

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.great.cash.rupee.App
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.PermissionEntity
import com.great.cash.rupee.module.model.StartModel
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.databinding.ActPermissionBinding
import com.great.cash.rupee.module.user.InputNumberActivity
import com.great.cash.rupee.module.adapter.PermissionAdapter
import com.great.cash.rupee.view.dialog.DialogUtil
import com.great.cash.rupee.view.dialog.PermissionDialog
import com.luck.picture.lib.tools.ToastUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.functions.Consumer

class PermissionPage :
    BaseAct<ActPermissionBinding, StartModel>(StartModel::class.java) {
    private var adapter: PermissionAdapter? = null
    private var list = mutableListOf<PermissionEntity>()
    private var rxPermission: RxPermissions? = null
    private var permissionDialog: PermissionDialog? = null
    override fun getLayout(): Int {
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

        return R.layout.act_permission
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing!!.clickListener = this
        rxPermission = RxPermissions(this)
        dataBing!!.ivAgree.isSelected = true
        adapter = PermissionAdapter()
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        dataBing!!.recycler.layoutManager = manager
        dataBing!!.recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                //--------------------------kotlin junk code-----------------------------
                try {
                    val start_time = System.currentTimeMillis()
                    val end_time = System.currentTimeMillis()
                    val cha_time = hashMapOf<String, Any>()
                    end_time.takeIf {
                        it == start_time
                    }?.let {
                        val u_one = it.toString().toList()
                        val u_two = end_time.toString().toList()
                        if (u_one.size == u_one.size) {
                            for ((index, i) in u_one.withIndex()) {
                                cha_time["k_${i}"] = u_two[index]
                            }
                        }
                    }
                } catch (eKotlinCode9: Exception) {
                }
                //--------------------------kotlin junk code-----------------------------

//                val visibleItemPosition: Int = manager.findLastVisibleItemPosition()
//                dataBing!!.btnConfirm.isEnabled = visibleItemPosition + 1 == adapter!!.itemCount
            }
        })

        dataBing!!.recycler.adapter = adapter
        viewModel.statisticsEvent(EventParams.EVENT_PERMISSION, EventParams.EVENT_PERMISSION_DESC)

        val style = SpannableStringBuilder()
        style.append(resources.getString(R.string.ok_go_des))
        val clickableTeam: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
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

                toWebView(2)
            }
        }
        style.setSpan(clickableTeam, 31, 47, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        val clickablePrivacy: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                //--------------------------kotlin junk code-----------------------------
                try {
                    val start_time = System.currentTimeMillis()
                    val end_time = System.currentTimeMillis()
                    val cha_time = hashMapOf<String, Any>()
                    end_time.takeIf {
                        it == start_time
                    }?.let {
                        val u_one = it.toString().toList()
                        val u_two = end_time.toString().toList()
                        if (u_one.size == u_one.size) {
                            for ((index, i) in u_one.withIndex()) {
                                cha_time["k_${i}"] = u_two[index]
                            }
                        }
                    }
                } catch (eKotlinCode9: Exception) {
                }
                //--------------------------kotlin junk code-----------------------------

                toWebView(1)
            }
        }
        style.setSpan(clickablePrivacy, 50, 64, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        val foregroundColorSpan =
            ForegroundColorSpan(resources.getColor(R.color.text_color1))
        style.setSpan(foregroundColorSpan, 31, 64, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        dataBing!!.tvGoDes.text = style
        dataBing!!.tvGoDes.movementMethod = LinkMovementMethod.getInstance()

    }

    override fun initData() {
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

        viewModel.loadH5List().observe(this, Observer {
            permissionDialog = PermissionDialog(this,
                NetworkStart.BASE_URL + ConstantsParams.protocolRespList[1].value,
                { finish() }
            ) {
                if (!isLogin) {
                    ConstantsParams.init(App.instance!!.applicationContext)
                    toOtherActivityAndFinishCurrent(InputNumberActivity::class.java)
                } else {
                    toOtherActivityAndFinishCurrent(LauncherActivity::class.java)
                }
            }
        })
        val title = resources.getStringArray(R.array.permission_title_list)
        val des = resources.getStringArray(R.array.permission_desc_list)
        val icon = arrayOf(
            R.mipmap.ic_permission_phone,
            R.mipmap.storage,
            R.mipmap.ic_sms,
            R.mipmap.ic_contact,
            R.mipmap.ic_location,
            R.mipmap.ic_cacmer,
            R.mipmap.ic_permission_phone,
            R.mipmap.storage,
            R.mipmap.ic_contact,
            R.mipmap.ic_cacmer
        )
        for (i in title.indices) {
            val entity = PermissionEntity(title[i], icon[i], des[i])
            list.add(entity)
        }
        adapter!!.setData(list)
    }

    override fun onViewClick(view: View?) {
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

        when (view!!.id) {
            R.id.btn_confirm -> {
                rxPermission?.request(
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_SMS
                )?.subscribe(Consumer {
                    if (it) {
                        permissionDialog?.let {
                            it.show()
                        }
                    } else {
                        showPermission()
                    }
                })
            }
            R.id.iv_agree -> {
                dataBing!!.ivAgree.isSelected = !dataBing!!.ivAgree.isSelected
                dataBing!!.ivAgree.setImageDrawable(
                    if (dataBing!!.ivAgree.isSelected) resources.getDrawable(R.mipmap.icon_check_true)
                    else resources.getDrawable(R.mipmap.icon_check_false)
                )
            }
            R.id.btn_cancel -> {
                finish()
//                exitProcess(0)
            }
        }
    }

    private fun showPermission() {
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

        DialogUtil.showCancelConfirmDialog(this,
            getString(R.string.permission_failed),
            "OK",
            "Not Now",
            View.OnClickListener {
                try {
                    val info = packageManager.getPackageInfo(packageName, 0)
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.data = Uri.parse("package:" + info.packageName)
                    startActivity(intent)
                } catch (e: Exception) {
                    errorLog(e.toString())
                }
            },
            View.OnClickListener { })
    }

    private fun toWebView(index: Int) {
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

        debug("current index:${index}")
        try {
            val bundle = Bundle()
            bundle.putString(
                Constant.URL,
                NetworkStart.BASE_URL + ConstantsParams.protocolRespList[index].value
            )
            bundle.putString(Constant.TITLE, ConstantsParams.protocolRespList[index].name)
            toOtherActivity(BrowserActivity::class.java, bundle)
        } catch (e: Exception) {
            errorLog(e.toString())
        }
    }
}
