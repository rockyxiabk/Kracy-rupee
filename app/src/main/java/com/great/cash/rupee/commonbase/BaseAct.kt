package com.great.cash.rupee.commonbase

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.great.cash.rupee.App
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.LowEvent
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.view.dialog.DialogUtil
import com.great.cash.rupee.view.loading.ProgressUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.TimeUnit


abstract class BaseAct<TBinding : ViewDataBinding, TModel : BaseViewModel>(modelClass: Class<TModel>) :
    AppCompatActivity(),
    IBase, View.OnClickListener {
    protected val viewModel by lazy { ViewModelProvider(this)[modelClass] }
    protected var dataBing: TBinding? = null
    private var mDisposable: Disposable? = null
    private var progressDialog: ProgressUtil? = null

    override fun onCreate(savedInstanceState: Bundle?) {
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

        dataBing = DataBindingUtil.setContentView(this, getLayout())
        dataBing!!.lifecycleOwner = this
        setLightBar(false)
        initView(savedInstanceState)
        initData()
    }

    protected fun setLightBar(flag: Boolean = false) {
        if (flag) {
            StatusBarUtil.setLightMode(this)
            StatusBarUtil.setColor(this, resources.getColor(R.color.white))
        } else {
            StatusBarUtil.setDarkMode(this)
            StatusBarUtil.setColor(this, resources.getColor(R.color.colorAccent))
        }
    }

    protected abstract fun getLayout(): Int

    protected abstract fun initView(savedInstanceState: Bundle?)
    protected abstract fun initData()
    override fun onClick(view: View) {
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
            R.id.iv_back -> {
                finish()
            }
        }
        if (!isFastClick) onViewClick(view)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onMessageEvent(event: LowEvent) { /* Do something */
        DialogUtil.showCancelConfirmDialog(
            this@BaseAct, event.msg,
            View.OnClickListener {
                goMarket(App.instance!!, App.instance!!.packageName)
                System.exit(0)
            },
            View.OnClickListener {
                System.exit(0)
            })
    }

    override fun onDestroy() {
        super.onDestroy()
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

        if (mDisposable != null && !mDisposable!!.isDisposed) {
            mDisposable!!.dispose()
        }
    }

    protected abstract fun onViewClick(view: View?)
    private var lastClick: Long = 0
    private val isFastClick: Boolean
        get() {
            val now = System.currentTimeMillis()
            if (now - lastClick >= 200) {
                lastClick = now
                return false
            }
            lastClick = now
            return true
        }
    override fun onStart() {
        super.onStart()
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

        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
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

        EventBus.getDefault().unregister(this)
    }
    override fun showMsg(msg: String?) {
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

        debug(msg.toString())
        showShort(msg)
    }

    override fun showDialog() {
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

        progressDialog = ProgressUtil.create(this)
            .setStyle(ProgressUtil.Style.SPIN_INDETERMINATE)
            .setCancellable(false)
            .show()
    }

    override fun dismissDialog() {
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

        try {
            progressDialog!!.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun toOtherActivity(cls: Class<*>?) {
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

        val register = Intent(this, cls)
        startActivity(register)
    }

    override fun toOtherActivity(cls: Class<*>?, bundle: Bundle?) {
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

        val intent = Intent(this, cls)
        if (null != bundle) {
            intent.putExtra(Constant.BUNDLE_DATA, bundle)
        }
        startActivity(intent)
    }

    override fun toOtherActivityAndFinish(cls: Class<*>?, bundle: Bundle?) {
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

        val intent = Intent(this, cls)
        if (null != bundle) {
            intent.putExtra(Constant.BUNDLE_DATA, bundle)
        }
        startActivity(intent)
        finish()
    }

    override fun toOtherActivityAndFinishCurrent(cls: Class<*>?) {
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

        val register = Intent(this, cls)
        startActivity(register)
        finish()
    }

    override fun toOtherActivityAndFinishCurrent(cls: Class<*>?, delayTime: Long) {
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

        mDisposable =
            Observable.timer(delayTime, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    toOtherActivityAndFinishCurrent(
                        cls
                    )
                }
    }
}
